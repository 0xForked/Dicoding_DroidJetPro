package id.aasumitro.jetpro

import id.aasumitro.jetpro.data.Repository
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.Assert.assertNotNull

/**
 * Created by A. A. Sumitro on 19/08/19.
 * aasumitro@merahputih.id
 * https://aasumitro.id
 */
class RepositoryTest {

    private val mRepository = Repository()

    @Test
    fun test_get_movies() {
        val movies = mRepository.getMovies()
        assertNotNull(movies)
        assertEquals(10, movies.size)
    }

    @Test
    fun test_get_shows() {
        val shows = mRepository.getMovies()
        assertNotNull(shows)
        assertEquals(10, shows.size)
    }

}