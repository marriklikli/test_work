package com.example.testwork

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testwork.databinding.ActivitySpecialScreenBinding

class SpecialScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySpecialScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySpecialScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val animationDrawable = binding.background.background as AnimationDrawable
        animationDrawable.setEnterFadeDuration(2500)
        animationDrawable.setExitFadeDuration(1000)
        animationDrawable.start()
        binding.start.setOnClickListener{
            val intent = Intent(this, CatalogeActivity::class.java)
            startActivity(intent)
        }
    }
}