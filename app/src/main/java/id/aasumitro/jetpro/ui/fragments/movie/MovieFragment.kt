package id.aasumitro.jetpro.ui.fragments.movie

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
import id.aasumitro.jetpro.data.model.Entity
import id.aasumitro.jetpro.vm.MainViewModel
import id.aasumitro.jetpro.ui.rv.EntityListener
import kotlinx.android.synthetic.main.fragment_movie.*
import id.aasumitro.jetpro.ui.rv.EntityAdapter

/**
 * Created by A. A. Sumitro on 8/11/2019
 * aasumitro@merahputih.id
 * https://aasumitro.id
 */

class MovieFragment : Fragment(), EntityListener {

    private lateinit var mRepository: Repository
    private lateinit var mViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_movie, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mRepository = Repository(activity)
        mViewModel = ViewModelProvider(activity as FragmentActivity)
                        .get(MainViewModel::class.java)
        mViewModel.inject(mRepository)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        movie_recycler_view.setHasFixedSize(true)
        val mLayoutManager : RecyclerView.LayoutManager =
            GridLayoutManager(activity, 2)
        movie_recycler_view.layoutManager = mLayoutManager
        movie_recycler_view.itemAnimator = DefaultItemAnimator()
        mViewModel.movies().observe(this, movies)
    }

    private val movies = Observer<ArrayList<Entity>> {
        movie_recycler_view.adapter = EntityAdapter(it, this)
    }

    override fun onEntitySelected(entity: Entity?) {
        mViewModel.mSelectionListener.postValue(entity)
    }

}
