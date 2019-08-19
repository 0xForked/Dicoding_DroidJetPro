package id.aasumitro.jetpro.ui.activities.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import id.aasumitro.jetpro.R
import id.aasumitro.jetpro.ui.fragments.movie.MovieFragment
import id.aasumitro.jetpro.ui.fragments.show.ShowFragment

/**
 * Created by A. A. Sumitro on 8/11/2019
 * aasumitro@merahputih.id
 * https://aasumitro.id
 */

class MainViewPagerAdapter(
    fragmentManager: FragmentManager,
    context: Context
) : FragmentStatePagerAdapter(
    fragmentManager,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
) {

    private val mFragment = listOf(MovieFragment(), ShowFragment())

    private val mFragmentTitle = listOf(context.getString(R.string.text_movie), context.getString(R.string.text_show))

    override fun getItem(position: Int): Fragment = mFragment[position] as Fragment

    override fun getPageTitle(position: Int): CharSequence? = mFragmentTitle[position]

    override fun getCount(): Int = mFragment.size

}