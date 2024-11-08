package com.example.tablayoutexercise.fragments

import android.icu.text.Transliterator.Position
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSmoothScroller
import androidx.recyclerview.widget.SnapHelper
import com.example.tablayoutexercise.R
import com.example.tablayoutexercise.adapters.RvAdapter
import com.example.tablayoutexercise.data.CategoryData
import com.example.tablayoutexercise.data.ProductData
import com.example.tablayoutexercise.databinding.FragmentFirtsBinding
import com.example.tablayoutexercise.databinding.FragmentSecondBinding
import com.google.android.material.tabs.TabLayout
import com.iammert.tabscrollattacherlib.TabScrollAttacher


class SecondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding

    private val categoryData= CategoryData(
        listOf("1","2","3"),
        listOf(0,6,10)
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return (binding.root)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = RvAdapter(ProductData.getAyran())
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        categoryData.categories.forEach {category ->
          binding.tabLayout.addTab(binding.tabLayout.newTab().setText(category))
        }


        TabScrollAttacher2()

      /*   val attacher = TabScrollAttacher(binding.tabLayout, binding.recyclerView, categoryData.categoryIndexOffsetList){
            scrollSmoothly()
        }
        attacher.attach()

*/

    }


    private fun TabScrollAttacher(){
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            val layoutManager= binding.recyclerView.layoutManager as LinearLayoutManager
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.let {
                    val position = tab.position
                    val index = categoryData.categoryIndexOffsetList[position]
                    layoutManager.scrollToPositionWithOffset(index, 0)

                }
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {}

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
        })
    }
    private fun TabScrollAttacher2(){
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {


            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.let {
                    val position = tab.position
                    val index = categoryData.categoryIndexOffsetList[position]
                    smoothScrollPosition(index)

                }
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {}

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
        })
    }


    private fun  smoothScrollPosition(position: Int){
        val layoutManager= binding.recyclerView.layoutManager as LinearLayoutManager
        val smoothScroller = object : LinearSmoothScroller(context){
            override fun getVerticalSnapPreference(): Int {
                return SNAP_TO_START
            }
        }
        smoothScroller.targetPosition = position
        layoutManager.startSmoothScroll(smoothScroller)


    }

}