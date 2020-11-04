package com.example.studentapp.featureName

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.studentapp.R
import com.example.studentapp.featureName.data.User
import com.example.studentapp.featureName.viewmodel.MainViewModel
import com.example.studentapp.network.Status
import dagger.hilt.android.AndroidEntryPoint
import java.text.MessageFormat.Field.ARGUMENT

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