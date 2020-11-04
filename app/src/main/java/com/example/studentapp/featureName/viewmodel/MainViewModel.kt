package com.example.studentapp.featureName.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.studentapp.featureName.data.User
import com.example.studentapp.featureName.repos.MainRepository
import com.example.studentapp.network.Resource
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(private val mainRepository: MainRepository) :
    ViewModel() {

    private val _userList = MutableLiveData<Resource<ArrayList<User>>>()
    val users: LiveData<Resource<ArrayList<User>>>
        get() = _userList

    init {
        fetchData()
    }

    private fun fetchData() {
        GlobalScope.launch {
            _userList.postValue(Resource.onLoading(null))
            mainRepository.getUsers().let {
                if (it.isSuccessful) {
                    _userList.postValue(Resource.onSuccess(it.body()))
                } else _userList.postValue(Resource.onError(it.errorBody().toString(), null))
            }
        }
    }
}