package com.example.onlineshopapp

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import com.example.onlineshopapp.Activity.Adapter.SliderAdapter
import com.example.onlineshopapp.Activity.Model.SliderModel
import com.example.onlineshopapp.Activity.ViewModel.MainViewModel
import com.example.onlineshopapp.Activity.baseActivity
import com.example.onlineshopapp.databinding.ActivityMainBinding
import kotlin.jvm.internal.MagicApiIntrinsics

private lateinit var binding: ActivityMainBinding
class MainActivity : baseActivity() {
    private val viewModel =  MainViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initBanner()
    }

    private fun initBanner() {
        TODO("Not yet implemented")
    }

    private fun banner(image:List<SliderModel>){
        binding.viewPagerSlider.adapter = SliderAdapter(image, binding.viewPagerSlider)
        binding.viewPagerSlider.clipToPadding = false
        binding.viewPagerSlider.clipChildren= false
        binding.viewPagerSlider.offscreenPageLimit = 3
        binding.viewPagerSlider.getChildAt(0).overScrollMode=RecyclerView.OVER_SCROLL_NEVER

        val compositePageTransformer = CompositePageTransformer().apply {
            
        }
    }
}