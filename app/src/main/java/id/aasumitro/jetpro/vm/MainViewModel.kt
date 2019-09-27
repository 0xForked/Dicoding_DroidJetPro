package id.aasumitro.jetpro.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.aasumitro.jetpro.data.Repository
import id.aasumitro.jetpro.data.models.Entity
import id.aasumitro.jetpro.utils.EspressoIdlingResource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by A. A. Sumitro on 8/11/2019
 * aasumitro@merahputih.id
 * https://aasumitro.id
 */

class MainViewModel : ViewModel() {

    private var mRepository: Repository = Repository()

    private var mListMovies: MutableLiveData<ArrayList<Entity>>? = null
    private var mListShows: MutableLiveData<ArrayList<Entity>>? = null

    val mSelectionListener = MutableLiveData<Entity>()

    private var mMainNavigator: MainNavigator? = null

    fun initVM(
        navigator: MainNavigator
    ) {
        this.mMainNavigator = navigator
    }

    fun movies() : LiveData<ArrayList<Entity>> {
        if (mListMovies == null) {
            mListMovies = MutableLiveData()
            getMovies()
        }
        return mListMovies as MutableLiveData
    }

    fun shows() : LiveData<ArrayList<Entity>> {
        if (mListShows == null) {
            mListShows = MutableLiveData()
            getShows()
        }
        return mListShows as MutableLiveData
    }

    private fun getMovies() {
        EspressoIdlingResource.increment()
        this.mMainNavigator?.onLoadData(true)
        mRepository.let {
            it.getMovies()
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe({ onSuccess ->
                    mListMovies?.value = onSuccess.results as ArrayList<Entity>
                    this.mMainNavigator?.onLoadData(false)
                    if (!EspressoIdlingResource.espressoIdlingResourceForMainActivity.isIdleNow) {
                        EspressoIdlingResource.decrement()
                    }
                }, { onError ->
                    onError.printStackTrace()
                    this.mMainNavigator?.onErrorCallback(onError.message as String)
                    if (!EspressoIdlingResource.espressoIdlingResourceForMainActivity.isIdleNow) {
                        EspressoIdlingResource.decrement()
                    }
                })
        }
    }

    private fun getShows() {
        EspressoIdlingResource.increment()
        mRepository.let {
            it.getShows()
                ?.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe({ onSuccess ->
                    mListShows?.value = onSuccess.results as ArrayList<Entity>
                    if (!EspressoIdlingResource.espressoIdlingResourceForMainActivity.isIdleNow) {
                        EspressoIdlingResource.decrement()
                    }
                }, { onError ->
                    onError.printStackTrace()
                    this.mMainNavigator?.onErrorCallback(onError.message as String)
                    if (!EspressoIdlingResource.espressoIdlingResourceForMainActivity.isIdleNow) {
                        EspressoIdlingResource.decrement()
                    }
                })
        }
    }

}
