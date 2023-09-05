package com.vsple.hiltapp.network

sealed class Resources<out T> {
    data class Success<T>(val data: T) : Resources<T>()
    data class Error(val statusCode: Int, val errorMessage: String) : Resources<Nothing>()
    object Loading : Resources<Nothing>()
}