package id.aasumitro.jetpro.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.aasumitro.jetpro.data.Repository
import id.aasumitro.jetpro.data.model.Entity

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
        val movies = mRepository.getMovies()
        mListMovies?.value = movies as ArrayList<Entity>?
    }

    private fun getShows() {
        val shows = mRepository.getShows()
        mListShows?.value = shows as ArrayList<Entity>
    }

}
