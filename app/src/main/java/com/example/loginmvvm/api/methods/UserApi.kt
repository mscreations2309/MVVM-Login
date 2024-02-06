package com.example.loginmvvm.api.methods

import com.example.loginmvvm.api.ApiClient
import com.example.loginmvvm.api.request.LoginRequest
import com.example.loginmvvm.api.response.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {
    @POST("/api/authaccount/login")
    suspend fun loginUser(@Body loginRequest: LoginRequest): Response<LoginResponse>

    companion object {
        fun getApi(): UserApi? {
            return ApiClient.client?.create(UserApi::class.java)
        }
    }
}