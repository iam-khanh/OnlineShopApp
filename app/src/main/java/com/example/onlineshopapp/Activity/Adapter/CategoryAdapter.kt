package com.example.onlineshopapp.Activity.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.onlineshopapp.Activity.Model.CategoryModel
import com.example.onlineshopapp.databinding.ViewhoderCategoryBinding
import com.example.onlineshopapp.databinding.ViewholderBestSellerBinding

class CategoryAdapter(val items:MutableList<CategoryModel>): RecyclerView.Adapter<CategoryAdapter.Viewholder>() {
    private lateinit var context: Context

    inner class Viewholder(val binding: ViewhoderCategoryBinding ):
    RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): CategoryAdapter.Viewholder {
        context = parent.context
        val binding = ViewhoderCategoryBinding.inflate(LayoutInflater.from(context), parent, false)
        return Viewholder(binding)
    }

    override fun onBindViewHolder(holder: CategoryAdapter.Viewholder, position: Int) {
        val item = items[position]
        holder.binding.titleCat.text = item.title

        Glide.with(holder.itemView.context)
            .load(item.picUrl)
            .into(holder.binding.picCat)
    }

    override fun getItemCount(): Int = items.size
}