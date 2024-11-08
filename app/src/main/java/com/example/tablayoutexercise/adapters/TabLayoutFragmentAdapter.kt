package com.example.tablayoutexercise.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.tablayoutexercise.fragments.FirstFragment
import com.example.tablayoutexercise.fragments.SecondFragment
import com.example.tablayoutexercise.fragments.ThirdFragment

class TabLayoutFragmentAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity){

    private val fragmentList = listOf(FirstFragment(), SecondFragment(), ThirdFragment())

    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }
}