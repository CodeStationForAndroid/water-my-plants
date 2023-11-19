package com.abaferastech.watermyplants.data.remote

import java.lang.Exception

sealed class ApiResponse<out T> {
    data object Loading: ApiResponse<Nothing>()
    data class Error(val exception: Exception): ApiResponse<Nothing>()
    data class Success<out T>(val data: T): ApiResponse<T>()

}