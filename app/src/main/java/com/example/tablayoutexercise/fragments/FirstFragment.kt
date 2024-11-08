package com.example.tablayoutexercise.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.tablayoutexercise.R
import com.example.tablayoutexercise.adapters.ViewPagerAdapter
import com.example.tablayoutexercise.data.PersonData
import com.example.tablayoutexercise.databinding.ActivityMainBinding
import com.example.tablayoutexercise.databinding.FragmentFirtsBinding


class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirtsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentFirtsBinding.inflate(inflater, container, false)

        binding.button.setOnClickListener {
            Toast.makeText(context, "Button Clicked", Toast.LENGTH_SHORT).show()
        }



        return (binding.root)
    }
}