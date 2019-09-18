package id.aasumitro.jetpro.data.sources

import id.aasumitro.jetpro.data.models.EntityResult
import io.reactivex.Observable


/**
 * Created by A. A. Sumitro on 8/11/2019
 * aasumitro@merahputih.id
 * https://aasumitro.id
 */

interface RemoteRepository {

    fun getMovies(): Observable<EntityResult>?

    fun getShows(): Observable<EntityResult>?

}