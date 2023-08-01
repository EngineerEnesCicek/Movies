package com.example.movie.core.extensions

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.tabs.TabLayout


fun TabLayout.set(stringList:ArrayList<String>,fragmentManager: FragmentManager, fragmentList:ArrayList<Fragment>, frameLayout:Int):TabLayout{
    stringList.forEach{
        this.addTab(this.newTab().setText(it))
    }
    callFragment(fragmentList[0],fragmentManager,frameLayout)
    this.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
        override fun onTabSelected(tab: TabLayout.Tab?) {
            when (this@set.selectedTabPosition) {
                0 -> {
                    callFragment(fragmentList[0], fragmentManager,frameLayout)
                }
                1 -> {
                    callFragment(fragmentList[1], fragmentManager,frameLayout)
                }
                else -> {
                    callFragment(fragmentList[2], fragmentManager,frameLayout)
                }
            }
        }
        override fun onTabUnselected(tab: TabLayout.Tab?) {
        }
        override fun onTabReselected(tab: TabLayout.Tab?) {
        }
    })
    return this
}
fun callFragment(fragment: Fragment, fragmentManager: FragmentManager, frameLayout: Int) {
    val fragmentTransaction = fragmentManager.beginTransaction()
    fragmentTransaction.replace(frameLayout, fragment).commit()
}