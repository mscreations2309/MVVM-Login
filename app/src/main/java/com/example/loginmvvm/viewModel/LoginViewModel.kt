package com.example.loginmvvm.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.loginmvvm.api.request.LoginRequest
import com.example.loginmvvm.api.response.BaseResponse
import com.example.loginmvvm.api.response.LoginResponse
import com.example.loginmvvm.repsitory.UserRepository
import kotlinx.coroutines.launch

class LoginViewModel(application: Application):AndroidViewModel(application) {
    val user = UserRepository()
    val loginResult:MutableLiveData<BaseResponse<LoginResponse>> = MutableLiveData()

    fun loginUser(email:String,password:String){
        loginResult.value=BaseResponse.Loading()
        viewModelScope.launch {
            val loginRequest=LoginRequest(
                password=password,
                email = email
            )
            val response=user.loginUser(loginRequest=loginRequest)
            if (response?.code()==200){
                loginResult.value=BaseResponse.Success(response.body())
            }else{
                loginResult.value=BaseResponse.Error(response?.message())
            }
        }
    }
}