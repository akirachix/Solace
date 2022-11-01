package com.yasmin.solace_application.ui

import android.content.Intent
import android.content.SharedPreferences
import android.icu.util.MeasureUnit.EM
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
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
    lateinit var sharedPrefs: SharedPreferences
    val userViewModel:UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPrefs = getSharedPreferences("SOLACE_PREFS", MODE_PRIVATE)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignup.setOnClickListener {
            validateSignup()
        }
        binding.tvLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
    override fun onResume() {
        super.onResume()
        userViewModel.registerResponseLiveData.observe(this, Observer { registerResponse ->
            Toast.makeText(baseContext,registerResponse?.message,Toast.LENGTH_LONG).show()
            // intent to login
            startActivity(Intent(this@SignUpActivity,LoginActivity::class.java))
        })
        userViewModel.registerErrorLiveData.observe(this, Observer { error->
            Toast.makeText(baseContext,error,Toast.LENGTH_LONG).show()
        })
    }
    fun validateSignup() {
        var error = false
        var name = binding.etName.text.toString()
        var email = binding.etEmail.text.toString()
        var confirm = binding.etConfirm.text.toString()
        var password = binding.etPassword.text.toString()

        if (name.isBlank()) {
            binding.tilName.error = "Your full name is required"
            error = true
        }
        if (email.isBlank()) {
            binding.tilEmail.error = "Email is required"
            error = true
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.tilEmail.error = "Not valid email address"
            error = true
        }
        if (password.isBlank()) {
            binding.tilPassword.error = "Password is required"
            error = true
        }
        if (confirm.isBlank()) {
            binding.tilConfirm.error = "Confirmation is required"
            error = true
        }
        if (password!=confirm){
            binding.tilConfirm.error= "Password does not match"
        }
        if (!error) {
            var registerRequest= RegisterRequest(name, email,password)
            userViewModel.registerUser(registerRequest)
        }
    }

}