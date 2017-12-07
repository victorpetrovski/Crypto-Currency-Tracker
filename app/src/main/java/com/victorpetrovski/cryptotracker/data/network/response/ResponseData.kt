package com.victorpetrovski.cryptotracker.data.network.response

/**
 * Created by Victor on 11/18/17.
 */
data class ResponseData<out T>(val success: Boolean, val message: String, val data: T?)