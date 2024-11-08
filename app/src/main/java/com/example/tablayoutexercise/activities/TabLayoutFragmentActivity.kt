package com.example.tablayoutexercise.activities

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.tablayoutexercise.adapters.TabLayoutFragmentAdapter
import com.example.tablayoutexercise.databinding.ActivityMainBinding
import com.example.tablayoutexercise.databinding.ActivityTabLayoutFragmentBinding
import com.google.android.material.tabs.TabLayoutMediator

class TabLayoutFragmentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTabLayoutFragmentBinding
    private lateinit var adapter: TabLayoutFragmentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityTabLayoutFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter= TabLayoutFragmentAdapter(this)
        binding.pager.adapter=adapter
        TabLayoutMediator(binding.tabLayout, binding.pager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Fragment1"

                }
                1 -> {
                    tab.text = "Fragment2"
                }
                2 -> {
                    tab.text = "Fragment3"
                }
            }
        }.attach()

    }
}