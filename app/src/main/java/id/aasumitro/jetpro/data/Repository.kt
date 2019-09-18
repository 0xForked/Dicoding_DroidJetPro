package id.aasumitro.jetpro.data

import id.aasumitro.jetpro.data.models.EntityResult
import id.aasumitro.jetpro.data.sources.RemoteRepository
import id.aasumitro.jetpro.data.sources.remote.ApiClient
import io.reactivex.Observable

/**
 * Created by A. A. Sumitro on 18/09/19.
 * aasumitro@merahputih.id
 * https://aasumitro.id
 */

class Repository(
    private val apiClient: ApiClient = ApiClient()
): RemoteRepository {

    override fun getMovies(): Observable<EntityResult>? =
        apiClient.apiServices()?.getMovies()

    override fun getShows(): Observable<EntityResult>? =
        apiClient.apiServices()?.getShow()

}