package id.aasumitro.jetpro.utils

import androidx.test.espresso.IdlingResource
import androidx.test.espresso.idling.CountingIdlingResource


/**
 * Created by A. A. Sumitro on 22/09/19.
 * aasumitro@merahputih.id
 * https://aasumitro.id
 */

internal object EspressoIdlingResource {

    private const val RESOURCE = "GLOBAL"

    private val espressoTestIdlingResource = CountingIdlingResource(RESOURCE)

    val espressoIdlingResourceForMainActivity: IdlingResource
        get() = espressoTestIdlingResource

    fun increment() {
        espressoTestIdlingResource.increment()
    }

    fun decrement() {
        espressoTestIdlingResource.decrement()
    }

}