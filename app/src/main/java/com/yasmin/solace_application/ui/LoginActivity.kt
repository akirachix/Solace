package com.yasmin.solace_application.ui
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.yasmin.solace_application.R
import com.yasmin.solace_application.ViewModel.UserViewModel
import com.yasmin.solace_application.databinding.ActivityLoginBinding
import com.yasmin.solace_application.models.LoginRequest
import com.yasmin.solace_application.models.LoginResponse
import com.yasmin.solace_application.utilities.Constant

class LoginActivity : AppCompatActivity() {
    lateinit var binding:ActivityLoginBinding
    lateinit var sharedPrefs : SharedPreferences
    val userViewModel:UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPrefs = getSharedPreferences("Solace_PREFS", MODE_PRIVATE)

        binding.btnLogin.setOnClickListener {
            validateLogin()
            val intent=Intent(this,HomeActivity::class.java)
            startActivity(intent)
        }
//        castView()



//        binding.btnLogin.setOnClickListener {
//            validateLogin()

        binding.tvsignup.setOnClickListener {
            val intent=Intent(this,HomeActivity::class.java)
            startActivity(intent)
        }
        castView()
    }
    override fun onResume(){
        super.onResume()
        userViewModel.logInResponseLiveData.observe(this, Observer{LogInResponse->
            saveLoginDetails(LogInResponse!!)
            Toast.makeText(baseContext,LogInResponse?.message, Toast.LENGTH_LONG).show()
//            startActivity(Intent(this,HomeActivity::class.java))
            startActivity(Intent(baseContext, HomeActivity::class.java))
            finish()
        })
        userViewModel.errorLiveData.observe(this, Observer {errorMessage->
            Toast.makeText(baseContext,errorMessage,Toast.LENGTH_LONG).show()
        })
    }
    fun castView() {
        binding.btnLogin.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        validateLogin()}
        binding.tvsignup.setOnClickListener { startActivity(Intent(this, LoginActivity::class.java))}
        binding.btnLogin.setOnClickListener { startActivity(Intent(this, HomeActivity::class.java))}

    }
    fun validateLogin(){
        var password = binding.etpassword.text.toString()
        var email=binding.etemail.text.toString()
        binding.tilEmail.error=null
        binding.tilpassword.error=null
        var error=false

        if (email.isBlank()){
            binding.tilEmail.error="Email is required"
            error=true
        }
//        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
//            binding.tilEmail.error="Not a valid email address"
//            error=true
//        }
        if (password.isBlank()){
            binding.tilpassword.error="Password is required"
            error=true
        }
        if (!error){
            val loginRequest =LoginRequest(email,password)
            binding.pbLogin.visibility= View.VISIBLE
            userViewModel.loginUser(loginRequest)
        }
    }
    fun saveLoginDetails(LoginResponse:LoginResponse){
        val editor = sharedPrefs.edit()
        val token = "Bearer ${LoginResponse.accessToken}"
        editor.putString(Constant.ACCESS_TOKEN,LoginResponse.accessToken)
        editor.putString(Constant.USER_Id,LoginResponse.userId)
        editor.putString(Constant.PROFILE_ID,LoginResponse.profileId)

        editor.putString("ACCESS_TOKEN",LoginResponse.accessToken)
        editor.putString("USER_ID",LoginResponse.accessToken)
        editor.putString("USER_ID",LoginResponse.userId)
        editor.putString("PROFILE_ID",LoginResponse.profileId)
        editor.apply()
    }
}


