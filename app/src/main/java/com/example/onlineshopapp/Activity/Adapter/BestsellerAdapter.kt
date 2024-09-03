package com.example.onlineshopapp.Activity.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.request.RequestOptions
import com.example.onlineshopapp.Activity.Model.BestsellerModel
import com.example.onlineshopapp.databinding.ViewholderBestSellerBinding

class BestsellerAdapter(val items:MutableList<BestsellerModel>): RecyclerView.Adapter<BestsellerAdapter.Viewholder>() {
    private var context: Context? = null
    class Viewholder(val binding: ViewholderBestSellerBinding):
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): BestsellerAdapter.Viewholder {
        context = parent.context
        val binding = ViewholderBestSellerBinding.inflate(LayoutInflater.from(context), parent, false)
        return Viewholder(binding)
    }

    override fun onBindViewHolder(holder: BestsellerAdapter.Viewholder, position: Int) {
        holder.binding.txttitle.text = items[position].title
        holder.binding.txtrating.text = items[position].rating.toString()
        holder.binding.txtprice.text = "$" + items[position].price.toString()

        val requetOption = RequestOptions().transform(CenterCrop())

        Glide.with(holder.itemView.context)
            .load(items[position].picUr[0])
            .apply(requetOption)
            .into(holder.binding.picBestSeller)

    }

    override fun getItemCount(): Int  = items.size
}