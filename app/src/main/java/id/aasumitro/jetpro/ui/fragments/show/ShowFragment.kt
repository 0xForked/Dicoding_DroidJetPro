package id.aasumitro.jetpro.ui.fragments.show

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.aasumitro.jetpro.R
import id.aasumitro.jetpro.data.Repository
import id.aasumitro.jetpro.data.models.Entity
import id.aasumitro.jetpro.vm.MainViewModel
import id.aasumitro.jetpro.ui.rv.EntityListener
import kotlinx.android.synthetic.main.fragment_show.*
import id.aasumitro.jetpro.ui.rv.EntityAdapter

/**
 * Created by A. A. Sumitro on 8/11/2019
 * aasumitro@merahputih.id
 * https://aasumitro.id
 */

class ShowFragment : Fragment(), EntityListener {

    private lateinit var mRepository: Repository
    private lateinit var mViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_show, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        mRepository = Repository()
        mViewModel = ViewModelProvider(activity as FragmentActivity)
                        .get(MainViewModel::class.java)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        show_recycler_view.setHasFixedSize(true)
        val mLayoutManager : RecyclerView.LayoutManager =
            GridLayoutManager(activity, 2)
        show_recycler_view.layoutManager = mLayoutManager
        show_recycler_view.itemAnimator = DefaultItemAnimator()
        mViewModel.shows().observe(this, shows)
    }

    private val shows = Observer<ArrayList<Entity>> {
        show_recycler_view.adapter = EntityAdapter(it, this)
    }

    override fun onEntitySelected(entity: Entity?) {
        mViewModel.mSelectionListener.postValue(entity)
    }

}
