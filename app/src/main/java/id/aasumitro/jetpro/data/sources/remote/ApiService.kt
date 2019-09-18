package id.aasumitro.jetpro.data.sources.remote

import id.aasumitro.jetpro.data.models.EntityResult
import id.aasumitro.jetpro.data.sources.remote.ApiConst.API_KEY
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by A. A. Sumitro on 18/09/19.
 * aasumitro@merahputih.id
 * https://aasumitro.id
 */

interface ApiService {

    @GET("movie")
    fun getMovies(
        @Query("api_key") apiKey: String = API_KEY
    ): Observable<EntityResult>

    @GET("tv")
    fun getShow(
        @Query("api_key") apiKey: String = API_KEY
    ): Observable<EntityResult>

}