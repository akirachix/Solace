package com.yasmin.solace_application

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import com.yasmin.solace_application.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var binding:ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnLogin.setOnClickListener { validateLogin()}
        castView()
    }
        fun castView() {
            binding.btnLogin
            binding.tvsignup.setOnClickListener { startActivity(Intent(this,SignupActivity::class.java)) }
          }
            fun validateLogin(){
                var error=false
                var password = binding.etpassword.text.toString()
                var email=binding.etemail.text.toString()
                binding.tilEmail.error=null
                binding.tilpassword.error=null
                if (email.isBlank()){
                    binding.tilEmail.error="Email is required"
                    error=true
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    binding.tilEmail.error="Not a valid email address"
                    error=true
                }
              if (password.isBlank()){
                    binding.tilpassword.error="Password is required"
                    error=true
                }
                if (!error){


                }

            }
        }
