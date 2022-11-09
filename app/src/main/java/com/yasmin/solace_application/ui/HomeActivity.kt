package com.yasmin.solace_application.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.yasmin.solace_application.R
import com.yasmin.solace_application.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        castview()
        setupBottomNav()

        binding.tvMeditates.setOnClickListener {

            val intent= Intent(this,MeditationActivity::class.java)
            startActivity(intent)
        }
        binding.btnTalk.setOnClickListener {
            val intent= Intent(this,ChatbotActivity::class.java)
            startActivity(intent)
        }


    }

    fun castview(){
        binding.flFragment
        binding.bottomNavigationView
    }
    fun setupBottomNav(){
        binding.bottomNavigationView.setOnItemSelectedListener { item->
            when(item.itemId){
                R.id.home ->{
                    val  transaction=supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.fragmentContainerView,HomeFragment())
                    transaction.commit()
                    true
                }
                R.id.notification ->{
                    val  transaction=supportFragmentManager.beginTransaction()
                    transaction.replace(R.id.fragmentContainerView,NotificationFragment())
                    transaction.commit()
                    true
                }
                R.id.profile ->{
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView, ProfileFragment())
                    .commit()
                    true
                }

                else -> false

            }
        }

    }
}