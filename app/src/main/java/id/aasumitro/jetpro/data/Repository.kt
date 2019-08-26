package id.aasumitro.jetpro.data

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import id.aasumitro.jetpro.data.model.Entity
import java.io.InputStream
import java.io.InputStreamReader


/**
 * Created by A. A. Sumitro on 8/11/2019
 * aasumitro@merahputih.id
 * https://aasumitro.id
 */

class Repository(
    private val mContext: Context? = null
) {


    // sangan suram digunakan untuk unit/local testing
    fun fetchData(type: String): List<Entity>? {
        val gson = GsonBuilder().create()
        val dataFromAsset = loadFromAssets(type)
        val dataResultAsJsonArray = dataFromAsset?.get("results")?.asJsonArray
        return gson.fromJson(dataResultAsJsonArray, Array<Entity>::class.java).toList()
    }

    //penggunaan dihentikan karena fungsi perlu menggunakan context
    //dan sangan suram digunakan untuk unit/local testing
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private fun loadFromAssets(type: String): JsonObject? {
        try {
            mContext?.assets?.open("$type.json").use { `is` ->
                val parser = JsonParser()
                return parser.parse(InputStreamReader(`is` as InputStream)).asJsonObject
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }

    // alternatif lain menggunakan data object
    // dari pada data dari asset
    fun getMovies(): List<Entity> = DummyData.generateMovies()
    fun getShows(): List<Entity> = DummyData.generateShows()

}