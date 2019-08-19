package id.aasumitro.jetpro.ui.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.aasumitro.jetpro.R
import id.aasumitro.jetpro.data.model.Entity


/**
 * Created by A. A. Sumitro on 8/11/2019
 * aasumitro@merahputih.id
 * https://aasumitro.id
 */

class EntityAdapter (
    private val data: ArrayList<Entity>,
    private val listener: EntityListener
) : RecyclerView.Adapter<EntityViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EntityViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_holder, parent, false)
        return EntityViewHolder(view)
    }

    override fun onBindViewHolder(holder: EntityViewHolder, position: Int) =
        holder.bind(data[position], listener)

    override fun getItemCount(): Int = data.count()

}