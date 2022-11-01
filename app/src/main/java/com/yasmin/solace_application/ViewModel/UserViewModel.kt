package com.yasmin.solace_application.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yasmin.solace_application.Repository.UserRepository
import com.yasmin.solace_application.models.LoginRequest
import com.yasmin.solace_application.models.LoginResponse
import com.yasmin.solace_application.models.RegisterRequest
import com.yasmin.solace_application.models.RegisterResponse
import kotlinx.coroutines.launch

class UserViewModel:ViewModel() {
   val userRepository = UserRepository()
    val loginResponseLiveData = MutableLiveData<LoginResponse>()
    val loginErrorLiveData = MutableLiveData<String?>()

    val registerResponseLiveData = MutableLiveData<RegisterResponse>()
    val registerErrorLiveData = MutableLiveData<String?>()

    fun loginUser(loginRequest: LoginRequest) {
        viewModelScope.launch {
            val response = userRepository.login(loginRequest)
            if (response.isSuccessful) {
                loginResponseLiveData.postValue(response.body())
            } else {
                val error = response.errorBody()?.string()
                loginErrorLiveData.postValue(error)
            }
        }
    }

    fun registerUser(RegisterRequest: RegisterRequest) {
        viewModelScope.launch {
            val response = userRepository.register(RegisterRequest)
            if (response.isSuccessful) {
                registerResponseLiveData.postValue(response.body())
            } else {
                val error = response.errorBody()?.string()
                registerErrorLiveData.postValue(error)
            }
        }
    }
}
