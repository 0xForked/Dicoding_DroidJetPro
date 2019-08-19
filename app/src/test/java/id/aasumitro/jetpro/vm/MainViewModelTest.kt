package id.aasumitro.jetpro.vm

import android.content.Context
import id.aasumitro.jetpro.data.Repository
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import androidx.test.core.app.ApplicationProvider


/**
 * Created by A. A. Sumitro on 19/08/19.
 * aasumitro@merahputih.id
 * https://aasumitro.id
 */
class MainViewModelTest {

    private val context = ApplicationProvider.getApplicationContext<Context>()
    private lateinit var mRepository: Repository
    private var mViewModel: MainViewModel? = null

    @Before
    fun setUp() {
        mRepository = Repository(context)
        mViewModel = MainViewModel()
        mViewModel?.inject(mRepository)
    }

    @Test
    fun getMovies() {
        val movies = mViewModel?.movies()
        assertNotNull(movies)
    }

    @Test
    fun getShows() {
        val shows = mViewModel?.shows()
        assertNotNull(shows)
    }

}