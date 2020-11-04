package com.example.studentapp.featureName

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.example.studentapp.R
import com.example.studentapp.featureName.data.User
import com.example.studentapp.featureName.viewmodel.MainViewModel
import com.example.studentapp.network.Status
import dagger.hilt.android.AndroidEntryPoint
import java.util.Observer

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupObserver()
    }


    private fun setupObserver() {
        mainViewModel.users.observe(this, androidx.lifecycle.Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    val userList: ArrayList<User> = it.data as ArrayList<User>
                }
                Status.ERROR -> {
                    val errorMsg = it.errorMsg as String
                }
                Status.LOADING -> {

                }
            }
        })
    }

}