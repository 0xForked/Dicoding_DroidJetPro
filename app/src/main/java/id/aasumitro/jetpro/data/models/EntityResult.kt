package id.aasumitro.jetpro.data.models

/**
 * Created by A. A. Sumitro on 18/09/19.
 * aasumitro@merahputih.id
 * https://aasumitro.id
 */

data class EntityResult(
    var page: Int? = null,
    var total_results: Long? = null,
    var total_pages: Long? = null,
    var results: List<Entity>? = emptyList()
)
