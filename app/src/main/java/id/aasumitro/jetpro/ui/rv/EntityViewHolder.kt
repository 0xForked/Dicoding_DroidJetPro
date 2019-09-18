package id.aasumitro.jetpro.ui.rv

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.Picasso
import id.aasumitro.jetpro.data.models.Entity
import kotlinx.android.synthetic.main.item_list_holder.view.*
import id.aasumitro.jetpro.R
import id.aasumitro.jetpro.data.sources.remote.ApiConst.IMAGE_URL
import id.aasumitro.jetpro.data.sources.remote.ApiConst.POSTER_SIZE

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
        listener: EntityListener
    ) = with(itemView) {
        Picasso.get()
            .load(IMAGE_URL + POSTER_SIZE + entity.poster)
            .placeholder(R.drawable.ic_cloud_download_gray_24dp)
            .error(R.drawable.ic_broken_image_gray_24dp)
            .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
            .into(item_poster)
        item_ratting.text = entity.rating
        item_container.setOnClickListener { listener.onEntitySelected(entity) }
    }

}