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
    val logInResponseLiveData = MutableLiveData<LoginResponse>()
    val errorLiveData = MutableLiveData<String?>()
    val registerResponseLiveData = MutableLiveData<RegisterResponse>()
    val registererrorLiveData = MutableLiveData<String?>()

    fun loginUser(loginRequest: LoginRequest) {
        viewModelScope.launch {
            val response = userRepository.loginUser(loginRequest)
            if (response.isSuccessful) {
                logInResponseLiveData.postValue(response.body())
            } else {
                val error =response. errorBody()?.string()
                errorLiveData.postValue(error)
            }
        }
    }
    fun registerUser(registerRequest: RegisterRequest) {
        viewModelScope.launch {
            val response = userRepository.registerUser(registerRequest)
            if (response.isSuccessful) {
                registerResponseLiveData.postValue(response.body())
            }
                else{
                    val error =response.errorBody()?.string()
                registererrorLiveData.postValue(error)

                }
        }
    }
}