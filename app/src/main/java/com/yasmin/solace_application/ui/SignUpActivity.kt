package com.yasmin.solace_application.ui

import android.content.Intent
import android.icu.util.MeasureUnit.EM
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns.EMAIL_ADDRESS
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.util.PatternsCompat.EMAIL_ADDRESS
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.yasmin.solace_application.ViewModel.UserViewModel
import com.yasmin.solace_application.databinding.ActivitySignUpBinding
import com.yasmin.solace_application.models.RegisterRequest
import java.util.regex.Pattern

class SignUpActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignUpBinding
    val userViewModel:UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignup.setOnClickListener {
            validateSignup()
        }

        binding.btnSignup.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

        }
        binding.tvLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

        }
    }

    fun validateSignup() {
        var error = false
        binding.tilName.error = null
        binding.tilEmail.error = null
        binding.tilPassword.error = null
        binding.tilConfirm.error = null

        var name = binding.etName.text.toString()
        if (name.isBlank()) {
            binding.tilName.error = "First name is required"
            error = true
        }


        var Email = binding.etEmail.text.toString()
        if (Email.isBlank()) {
            binding.tilEmail.error = "Email is required"
            error = true
        }
//        if(!Pattern..matches()){
//            binding.tilEmail.error= "Not a valid email address"
//            error = true
//        }

        var password = binding.etPassword.text.toString()
        if (password.isBlank()) {
            binding.tilPassword.error = "Password is required"
            error = true
        }

        var confirm = binding.etConfirm.text.toString()
        if (confirm.isBlank()) {
            binding.tilConfirm.error = "Confirmation is required"
            error = true
        }
        if (password!=confirm){
            binding.tilConfirm.error= "Password does not match"
        }
        if (!error) {
            var registerRequest= RegisterRequest(name, Email,password)
            userViewModel.registerUser(registerRequest)

        }
    }
    override fun onResume() {
        super.onResume()
        userViewModel.registerResponseLiveData.observe(this, Observer { RegisterResponse->
            Toast.makeText(baseContext,RegisterResponse.message,Toast.LENGTH_LONG).show()
            startActivity(Intent(this,LoginActivity::class.java))
        })
        userViewModel.registererrorLiveData.observe(this, Observer { error->
            Toast.makeText(baseContext,error,Toast.LENGTH_LONG).show()
        })
    }
}