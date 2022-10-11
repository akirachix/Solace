package com.yasmin.solace_application.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yasmin.solace_application.databinding.ActivityOnboardingMeditationBinding

class OnboardingMeditation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var binding: ActivityOnboardingMeditationBinding
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardingMeditationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnNEXT.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}