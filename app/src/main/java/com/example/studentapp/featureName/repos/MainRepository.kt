package com.example.studentapp.featureName.repos

import com.example.studentapp.network.RetrofitApiService
import javax.inject.Inject

class MainRepository @Inject constructor(private val retrofitApiService: RetrofitApiService){
    suspend fun getUsers() =  retrofitApiService.getUsers()
}