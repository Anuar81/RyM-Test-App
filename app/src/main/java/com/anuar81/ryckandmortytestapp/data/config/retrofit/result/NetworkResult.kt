package com.anuar81.ryckandmortytestapp.data.config.retrofit.result

sealed class NetworkResult<out T> {
    data class OnSuccess<out T>(val value : T) : NetworkResult<T>()
    data class OnFailure(val exception: Exception) : NetworkResult<Nothing>()
}
