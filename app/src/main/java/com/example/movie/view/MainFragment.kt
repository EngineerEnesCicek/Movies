package com.example.movie.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.movie.R
import com.example.movie.databinding.FragmentMainBinding
import com.example.movie.core.extensions.callFragment
import com.example.movie.core.list.frameLayoutForMain

class MainFragment : Fragment() {
    private val fragmentList= arrayListOf(ChildMainFragment(), SearchResultsFragment())
    private lateinit var binding: FragmentMainBinding
    var active=fragmentList[0]
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        callFragment(active,childFragmentManager, frameLayoutForMain)
        binding = FragmentMainBinding.inflate(inflater, container, false)
        binding.bottomNav.setOnItemSelectedListener {
            when(it.itemId){
                R.id.search->{
                    callFragment(fragmentList[1],childFragmentManager, frameLayoutForMain)
                    active=fragmentList[1]
                    true
                }
                R.id.home->{
                    callFragment(fragmentList[0],childFragmentManager, frameLayoutForMain)
                    active=fragmentList[0]
                    true
                }
                else -> {
                    false
                }
            }

        }
        return (binding.root)
    }


}

