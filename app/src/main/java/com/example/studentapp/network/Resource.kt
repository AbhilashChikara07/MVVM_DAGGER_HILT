package com.example.studentapp.network

class Resource<T>(val status: Status, val data: T?, val errorMsg: String?) {
    companion object {
        fun <T> onSuccess(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> onError(errorMsg: String, data: T?): Resource<T> {
            return Resource(Status.ERROR, data, errorMsg)
        }

        fun <T> onLoading(data: T?): Resource<T> {
            return Resource(Status.LOADING, data, null)
        }
    }
}