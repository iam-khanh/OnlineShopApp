package com.example.onlineshopapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.example.onlineshopapp.Activity.Adapter.BestsellerAdapter
import com.example.onlineshopapp.Activity.Adapter.CategoryAdapter

import com.example.onlineshopapp.Activity.Adapter.SliderAdapter
import com.example.onlineshopapp.Activity.Model.SliderModel
import com.example.onlineshopapp.Activity.ViewModel.MainViewModel
import com.example.onlineshopapp.Activity.baseActivity
import com.example.onlineshopapp.databinding.ActivityMainBinding



class MainActivity : baseActivity() {

    private val viewModel =  MainViewModel()
    private lateinit var binding: ActivityMainBinding
    private lateinit var sliderAdapter: SliderAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initBanner()
        initCategories()
        initBestseller()

    }

    private fun initBestseller() {
       binding.progressBarBestSeller.visibility = View.VISIBLE
        viewModel.bestseller.observe(this, Observer {
            binding.rvBestSeller.layoutManager = GridLayoutManager(this,2)
            binding.rvBestSeller.adapter = BestsellerAdapter(it)
            binding.progressBarBestSeller.visibility = View.GONE
        })
        viewModel.LoadBestseller()
    }

    private fun initCategories() {
        binding.progressBarCategories.visibility = View.VISIBLE
        viewModel.categories.observe(this, Observer {
            binding.rvCatgories.layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
            binding.rvCatgories.adapter = CategoryAdapter(it)
            binding.progressBarCategories.visibility = View.GONE
        })
        viewModel.LoadCategory()
    }


    private fun initBanner() {
        binding.progressBarBanner.visibility = View.VISIBLE
        viewModel.banners.observe(this, Observer {
            banner(it)
            binding.progressBarBanner.visibility = View.GONE
        })
        viewModel.LoadBanner()
    }

    private fun banner(images:List<SliderModel>){
        binding.viewPagerSlider.adapter = SliderAdapter(images, binding.viewPagerSlider)
        binding.viewPagerSlider.clipToPadding = false
        binding.viewPagerSlider.clipChildren= false
        binding.viewPagerSlider.offscreenPageLimit = 3
        binding.viewPagerSlider.getChildAt(0).overScrollMode=RecyclerView.OVER_SCROLL_NEVER

        val compositePageTransformer = CompositePageTransformer().apply {
            addTransformer(MarginPageTransformer(40))
        }

        binding.viewPagerSlider.setPageTransformer(compositePageTransformer)
        if(images.size>1){
            binding.dotIndicator.visibility = View.VISIBLE
            binding.dotIndicator.attachTo(binding.viewPagerSlider)
        }
        }
    }