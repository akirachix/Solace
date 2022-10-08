package com.yasmin.solace_application

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yasmin.solace_application.databinding.ActivityOnboardingFriendsBinding

class OnboardingFriends : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var binding:ActivityOnboardingFriendsBinding
        super.onCreate(savedInstanceState)
        binding= ActivityOnboardingFriendsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnButton.setOnClickListener {
            startActivity(Intent(this,OnboardingMeditation::class.java))
        }
        binding.tvSkip.setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))}
    }
}
