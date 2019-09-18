package id.aasumitro.jetpro.ui.fragments.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.squareup.picasso.MemoryPolicy
import com.squareup.picasso.Picasso
import id.aasumitro.jetpro.R
import id.aasumitro.jetpro.data.models.Entity
import kotlinx.android.synthetic.main.component_detail.*
import kotlinx.android.synthetic.main.fragment_detail.*
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import id.aasumitro.jetpro.data.sources.remote.ApiConst.BACK_DROP_SIZE
import id.aasumitro.jetpro.data.sources.remote.ApiConst.IMAGE_URL
import id.aasumitro.jetpro.data.sources.remote.ApiConst.POSTER_SIZE
import id.aasumitro.jetpro.vm.MainViewModel

/**
 * Created by A. A. Sumitro on 12/08/19.
 * aasumitro@merahputih.id
 * https://aasumitro.id
 */

class DetailFragment : BottomSheetDialogFragment() {

    private lateinit var mViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog.setOnShowListener { dialog ->
            val dlg = dialog as BottomSheetDialog
            val bottomSheetInternal =
                dlg.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
            BottomSheetBehavior.from(bottomSheetInternal as View).state =
                BottomSheetBehavior.STATE_EXPANDED
        }
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mViewModel = ViewModelProvider(activity as FragmentActivity)
            .get(MainViewModel::class.java)
        mViewModel.mSelectionListener.observe(this, entity)
    }

    private val entity = Observer<Entity> { entity ->
        Picasso.get()
            .load(IMAGE_URL + BACK_DROP_SIZE + entity?.backdrop)
            .placeholder(R.drawable.ic_cloud_download_gray_24dp)
            .error(R.drawable.ic_broken_image_gray_24dp)
            .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
            .into(poster_backdrop_detail)
        Picasso.get()
            .load(IMAGE_URL + POSTER_SIZE + entity?.poster)
            .placeholder(R.drawable.ic_cloud_download_gray_24dp)
            .error(R.drawable.ic_broken_image_gray_24dp)
            .memoryPolicy(MemoryPolicy.NO_CACHE, MemoryPolicy.NO_STORE)
            .into(poster_detail)
        text_rate_display.text = entity?.rating.toString()
        text_overview_display.text = entity?.overview.toString()

        val date = if (entity?.first_air != null)
            entity.first_air.toString()
        else
            entity.release.toString()

        val title = if (entity?.title != null)
            entity.title.toString()
        else
            entity.name.toString()

        title_detail.text = title
        text_first_air_display.text = date

    }

}
