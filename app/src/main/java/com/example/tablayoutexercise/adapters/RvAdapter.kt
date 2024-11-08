package com.example.tablayoutexercise.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tablayoutexercise.data.ProductModel
import com.example.tablayoutexercise.databinding.RvListCardBinding

class RvAdapter(val list: List<ProductModel>) : RecyclerView.Adapter<RvAdapter.RvViewHolder>() {
    inner class RvViewHolder(val binding: RvListCardBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvViewHolder {
        val binding = RvListCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RvViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RvViewHolder, position: Int) {
        val product = list[position]
        holder.binding.productImageView.setImageResource(product.yemek_resim_adi)
        holder.binding.productPriceText.text = "€ ${product.yemek_fiyat}"
        holder.binding.productNameText.text = product.product_name
        holder.binding.bilgiText.text = product.bilgi

    }
}