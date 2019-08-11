package id.aasumitro.jetpro.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import id.aasumitro.jetpro.R
import id.aasumitro.jetpro.data.SourceRepository
import id.aasumitro.jetpro.data.model.Entity

class MainActivity : AppCompatActivity() {

    lateinit var mViewModel: MainViewModel
    lateinit var mRepository: SourceRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mRepository = SourceRepository(this)
        mViewModel = ViewModelProvider(this@MainActivity)
            .get(MainViewModel::class.java)
        mViewModel.inject(mRepository)
        mViewModel.movies().observe(this, mMainMovie)
        mViewModel.shows().observe(this, mMainShow)
    }

    private val mMainMovie = Observer<ArrayList<Entity>> {
        Log.d("MainMovie", it.toString())
    }

    private val mMainShow = Observer<ArrayList<Entity>> {
        Log.d("MainShow", it.toString())
    }

}
