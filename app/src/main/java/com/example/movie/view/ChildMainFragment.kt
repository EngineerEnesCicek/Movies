package com.example.movie.view
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.movie.databinding.FragmentChildMainBinding
import com.example.movie.core.extensions.callFragment
import com.example.movie.core.extensions.set
import com.example.movie.core.list.frameLayoutForPopular
import com.example.movie.core.list.frameLayoutForTrends
import com.example.movie.core.list.popularTabLayoutList
import com.example.movie.core.list.trendsTabLayoutList

class ChildMainFragment : Fragment() {
    private val fragmentTrendsList= arrayListOf<Fragment>(
        TodayTrendsFragment(),
        ThisWeekTrendFragment()
    )
    private val fragmentPopularList= arrayListOf(
        PopularMoviesFragment(),
        PopularTvShowFragment(),
        PopularActorsFragment()
    )
    private lateinit var binding:FragmentChildMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentChildMainBinding.inflate(layoutInflater,container,false)
        val tabLayoutPopular=binding.tabsPopular
        tabLayoutPopular.set(tabLayoutPopular, popularTabLayoutList,childFragmentManager,fragmentPopularList,
            frameLayoutForPopular
        )
        callFragment(PopularMoviesFragment(),childFragmentManager, frameLayoutForPopular)
        val tabLayout = binding.tabs
        tabLayout.set(tabLayout,
            trendsTabLayoutList,childFragmentManager,fragmentTrendsList,
            frameLayoutForTrends
        )
        callFragment(TodayTrendsFragment(), childFragmentManager, frameLayoutForTrends)
        return binding.root
    }
}