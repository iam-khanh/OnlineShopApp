package com.example.onlineshopapp.Activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.onlineshopapp.MainActivity
import com.example.onlineshopapp.R
import com.example.onlineshopapp.databinding.ActivityIntroBinding


private  lateinit var binding: ActivityIntroBinding
class IntroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnstart.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

    }
}