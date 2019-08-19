package id.aasumitro.jetpro.data

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import id.aasumitro.jetpro.data.model.Entity
import java.io.InputStreamReader

/**
 * Created by A. A. Sumitro on 8/11/2019
 * aasumitro@merahputih.id
 * https://aasumitro.id
 */

class Repository(
    private val context: Context? = null
) {

    fun fetchData(type: String): List<Entity>? {
        val gson = GsonBuilder().create()
        val dataFromAsset = loadFromAssets(type)
        val dataResultAsJsonArray = dataFromAsset?.get("results")?.asJsonArray
        return gson.fromJson(dataResultAsJsonArray, Array<Entity>::class.java).toList()
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private fun loadFromAssets(type: String): JsonObject? {
        try {
            context?.assets?.open("$type.json").use { `is` ->
                val parser = JsonParser()
                return parser.parse(InputStreamReader(`is`)).asJsonObject
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }

}