package id.aasumitro.jetpro

import id.aasumitro.jetpro.data.Repository
import id.aasumitro.jetpro.data.models.EntityResult
import io.reactivex.observers.TestObserver
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.Before
import org.mockito.Mock

/**
 * Created by A. A. Sumitro on 19/08/19.
 * aasumitro@merahputih.id
 * https://aasumitro.id
 */
class RepositoryTest {

    @Mock
    private lateinit var mRepository: Repository

    @Before
    @Throws(Exception::class)
    fun setUp() {
        mRepository = Repository()
    }

    @Test
    fun test_get_movies() {
        val result =
            mRepository.getMovies()
        val testObserver = TestObserver<EntityResult>()
        result?.subscribe(testObserver)
        testObserver.assertComplete()
        testObserver.assertNoErrors()
        testObserver.assertValueCount(1)
        val listResult = testObserver.values()[0]
        assertEquals(20, listResult.results?.size)
    }

    @Test
    fun test_get_shows() {
        val result =
            mRepository.getShows()
        val testObserver = TestObserver<EntityResult>()
        result?.subscribe(testObserver)
        testObserver.assertComplete()
        testObserver.assertNoErrors()
        testObserver.assertValueCount(1)
        val listResult = testObserver.values()[0]
        assertEquals(20, listResult.results?.size)
    }

}