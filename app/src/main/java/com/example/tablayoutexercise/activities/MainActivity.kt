package com.example.tablayoutexercise.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.tablayoutexercise.R
import com.example.tablayoutexercise.adapters.ViewPagerAdapter
import com.example.tablayoutexercise.data.PersonData
import com.example.tablayoutexercise.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ViewPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = ViewPagerAdapter(PersonData.getImage())
        binding.viewPager2.adapter = adapter

        binding.button2.setOnClickListener { goToTabLayoutFragmentActivity()}



        TabLayoutMediator(binding.tabLayout, binding.viewPager2) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Tab1"
                    tab.icon = getDrawable(R.drawable.ic_launcher_background)
                }
                1 -> {
                    tab.text = "Tab2"
                    tab.icon = resources.getDrawable(R.drawable.ic_launcher_background)
                }
                2 -> {
                    tab.text = "Tab3"
                    tab.icon = resources.getDrawable(R.drawable.ic_launcher_background)
                }
                3 -> {
                    tab.text = "Tab4"

                }
                4 -> {
                    tab.text = "Tab5"

                }

            }
          tab.getOrCreateBadge()
            tab.badge?.number = 10
        }.attach()



        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab?) {
                // Handle tab select
                Toast.makeText(this@MainActivity, "Selected ${tab?.text}", Toast.LENGTH_SHORT).show()
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                // Handle tab reselect
                Toast.makeText(this@MainActivity, "Reselected ${tab?.text}", Toast.LENGTH_SHORT).show()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                // Handle tab unselect
                Toast.makeText(this@MainActivity, "Unselected ${tab?.text}", Toast.LENGTH_SHORT).show()
                tab?.removeBadge()

            }
        })

    }

    fun goToTabLayoutFragmentActivity(){
        val intent = Intent(this, TabLayoutFragmentActivity::class.java)
        startActivity(intent)
    }
}