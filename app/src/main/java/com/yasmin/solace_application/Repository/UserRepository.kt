package com.yasmin.solace_application.Repository

import com.yasmin.solace_application.api.ApiClient
import com.yasmin.solace_application.api.ApiInterface
import com.yasmin.solace_application.models.LoginRequest
import com.yasmin.solace_application.models.RegisterRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepository {
    private val apiClient = ApiClient.buildApiClient(ApiInterface::class.java)

    suspend fun login(loginRequest: LoginRequest)
            = withContext(Dispatchers.IO){
        val response = apiClient.loginUser(loginRequest)
        return@withContext response
    }

    suspend fun register(registerRequest: RegisterRequest)
            = withContext(Dispatchers.IO) {
        val response = apiClient.registerUser(registerRequest)
        return@withContext response
    }
}