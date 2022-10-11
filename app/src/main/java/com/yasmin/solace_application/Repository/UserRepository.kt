package com.yasmin.solace_application.Repository

import com.yasmin.solace_application.api.ApiClient
import com.yasmin.solace_application.api.ApiInterface
import com.yasmin.solace_application.models.LoginRequest
import com.yasmin.solace_application.models.LoginResponse
import com.yasmin.solace_application.models.RegisterRequest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserRepository {
    val apiClient = ApiClient.buildApiClient(ApiInterface::class.java)
    suspend fun loginUser(loginRequest: LoginRequest):Response<LoginResponse>
            = withContext(Dispatchers.IO) {
        var response = apiClient.loginUser(loginRequest)
        return@withContext response
    }
    suspend fun registerUser(registerRequest:RegisterRequest) = withContext(Dispatchers.IO) {
        var response = apiClient.registerUser(registerRequest)
        return@withContext response
    }
}