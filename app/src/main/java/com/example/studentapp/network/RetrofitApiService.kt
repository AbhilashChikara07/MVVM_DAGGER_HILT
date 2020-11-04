package com.example.studentapp.network

import com.example.studentapp.featureName.data.User
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitApiService {

    @GET("users")
    suspend fun getUsers(): Response<ArrayList<User>>

}