package id.aasumitro.jetpro.data.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by A. A. Sumitro on 8/11/2019
 * aasumitro@merahputih.id
 * https://aasumitro.id
 */

@Parcelize
data class Entity(
    @SerializedName("poster_path")
    var poster: String? = null,
    @SerializedName("backdrop_path")
    var backdrop: String? = null,
    @SerializedName("release_date")
    var release: String? = null,
    @SerializedName("first_air_date")
    var first_air: String? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("title")
    var title: String? = null,
    @SerializedName("overview")
    var overview: String? = null,
    @SerializedName("vote_average")
    var rating: String? = null
) : Parcelable