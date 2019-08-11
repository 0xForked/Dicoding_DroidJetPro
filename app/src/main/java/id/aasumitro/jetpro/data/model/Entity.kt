package id.aasumitro.jetpro.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by A. A. Sumitro on 8/11/2019
 * aasumitro@merahputih.id
 * https://aasumitro.id
 */

@Parcelize
data class Entity(
    var poster: Int = 0,
    var title: String? = null,
    var overview: String? = null,
    var rating: String? = null
) : Parcelable