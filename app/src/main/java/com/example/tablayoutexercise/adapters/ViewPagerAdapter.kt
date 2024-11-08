package com.example.tablayoutexercise.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tablayoutexercise.activities.ScrollTabLayout
import com.example.tablayoutexercise.data.PersonModel
import com.example.tablayoutexercise.databinding.ViewPagerCardBinding

class ViewPagerAdapter(val list :List<PersonModel>) : RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>(){

    inner class ViewPagerViewHolder(val binding : ViewPagerCardBinding) : RecyclerView.ViewHolder(binding.root)

    override fun getItemCount(): Int = list.size

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewPagerAdapter.ViewPagerViewHolder {
        val binding = ViewPagerCardBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewPagerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewPagerAdapter.ViewPagerViewHolder, position: Int) {
        val item = list[position]
        holder.binding.imageView.setImageResource(item.image)
        holder.itemView.setOnClickListener {
        val intent = Intent(holder.itemView.context,ScrollTabLayout::class.java)
            holder.itemView.context.startActivity(intent)
        }
    }
}