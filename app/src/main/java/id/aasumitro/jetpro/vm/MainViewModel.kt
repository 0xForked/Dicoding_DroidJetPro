package id.aasumitro.jetpro.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.aasumitro.jetpro.data.Repository
import id.aasumitro.jetpro.data.model.Entity
import id.aasumitro.jetpro.util.Constants.MOVIE
import id.aasumitro.jetpro.util.Constants.SHOW

/**
 * Created by A. A. Sumitro on 8/11/2019
 * aasumitro@merahputih.id
 * https://aasumitro.id
 */

class MainViewModel : ViewModel() {

    private lateinit var mRepository: Repository

    private var mListMovies: MutableLiveData<ArrayList<Entity>>? = null
    private var mListShows: MutableLiveData<ArrayList<Entity>>? = null

    val mSelectionListener = MutableLiveData<Entity>()

    fun inject(repository: Repository) {
        this.mRepository = repository
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
        val movies = mRepository.fetchData(MOVIE)
        mListMovies?.value = movies as ArrayList<Entity>?
    }

    private fun getShows() {
        val shows = mRepository.fetchData(SHOW)
        mListShows?.value = shows as ArrayList<Entity>
    }

}
