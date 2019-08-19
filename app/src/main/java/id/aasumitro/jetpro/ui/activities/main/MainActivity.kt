package id.aasumitro.jetpro.ui.activities.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import id.aasumitro.jetpro.R
import id.aasumitro.jetpro.data.Repository
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.component_toolbar.*
import id.aasumitro.jetpro.data.model.Entity
import androidx.lifecycle.Observer
import id.aasumitro.jetpro.ui.fragments.detail.DetailFragment
import id.aasumitro.jetpro.vm.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var mViewPagerAdapter: MainViewPagerAdapter

    private lateinit var mRepository: Repository
    private lateinit var mViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        toolbar_title.text = getString(R.string.text_main_title)
        supportActionBar?.let { actionBar ->
            actionBar.setDisplayShowTitleEnabled(false)
            actionBar.setDisplayHomeAsUpEnabled(false)
        }
        mViewPagerAdapter = MainViewPagerAdapter(supportFragmentManager, this)
        main_view_pager.adapter = mViewPagerAdapter
        main_tab_layout.setupWithViewPager(main_view_pager)
        mRepository = Repository(this)
        mViewModel = ViewModelProvider(this)
            .get(MainViewModel::class.java)
        mViewModel.mSelectionListener.observe(this, loadDetail)
    }

    private val loadDetail = Observer<Entity> {
        val bottomDetailFragment = DetailFragment()
        bottomDetailFragment.show(supportFragmentManager, bottomDetailFragment.tag)
    }

}
