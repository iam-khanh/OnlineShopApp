package com.example.onlineshopapp.Activity.Adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.bumptech.glide.request.RequestOptions
import com.example.onlineshopapp.Activity.Model.SliderModel
import com.example.onlineshopapp.R
import com.google.firebase.database.core.Context

class SliderAdapter(
    private var sliderItems: List<SliderModel>,
    private val viewPager2: ViewPager2

): RecyclerView.Adapter<SliderAdapter.SliderViewholder>() {
        private lateinit var context: android.content.Context
        private val runnable = Runnable {
            sliderItems = sliderItems
            notifyDataSetChanged()
        }


    class SliderViewholder(itemView: View): RecyclerView.ViewHolder(itemView) {

        private val imageView: ImageView = itemView.findViewById(R.id.imageslide)

        fun setImage(sliderItems:SliderModel, context: android.content.Context){
            val requestOptions = RequestOptions().transform(CenterInside())

            Glide.with(context)
                .load(sliderItems.url)
                .apply(requestOptions)
                .into(imageView)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SliderAdapter.SliderViewholder {
        context = parent.context
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.slider_image_container, parent, false)
        return SliderViewholder(view)
    }

    override fun onBindViewHolder(holder: SliderAdapter.SliderViewholder, position: Int) {
        holder.setImage(sliderItems[position], context)
        if(position==sliderItems.lastIndex-1){
            viewPager2.post(runnable)
        }
    }

    override fun getItemCount(): Int = sliderItems.size
}