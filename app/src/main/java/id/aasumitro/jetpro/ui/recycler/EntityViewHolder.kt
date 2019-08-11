package id.aasumitro.jetpro.ui.recycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import id.aasumitro.jetpro.data.model.Entity
import id.aasumitro.jetpro.util.Constants.MOVIE
import id.aasumitro.jetpro.util.Constants.SHOW

/**
 * Created by A. A. Sumitro on 8/11/2019
 * aasumitro@merahputih.id
 * https://aasumitro.id
 */

class EntityViewHolder(
    view: View
) : RecyclerView.ViewHolder(view) {

    fun bind(
        entity: Entity,
        listener: EntityListener,
        type: String
    ) {
        when(type) {
            MOVIE -> {}
            SHOW -> {}
        }
    }

}