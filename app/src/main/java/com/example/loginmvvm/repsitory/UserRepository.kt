package com.example.loginmvvm.repsitory

import com.example.loginmvvm.api.methods.UserApi
import com.example.loginmvvm.api.request.LoginRequest
import com.example.loginmvvm.api.response.LoginResponse
import retrofit2.Response

class UserRepository {

    suspend fun loginUser(loginRequest: LoginRequest): Response<LoginResponse>? {
        return  UserApi.getApi()?.loginUser(loginRequest = loginRequest)
    }
}