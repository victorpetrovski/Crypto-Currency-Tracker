package com.victorpetrovski.cryptotracker.data.network.base

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.victorpetrovski.cryptotracker.data.network.response.ResponseData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Victor on 11/20/17.
 */
abstract class NetworkTask<T> : Callback<T> {

    lateinit var mResponse: (ResponseData<T>) -> Unit

    override fun onResponse(call: Call<T>?, response: Response<T>) {
        if (response.body() != null) {
            mResponse.invoke(ResponseData(true, "", response.body()!!))
        } else {
            val type = object : TypeToken<ResponseData<T>>() {}.type
            /**
             *
             * Parse the Error.
             * In case the server response something we don't know how to parse show the user default message.
             *
             * */
            var errorResponse: ResponseData<T> = try {
                Gson().fromJson(response.errorBody()?.string(), type)
            } catch (e: Exception) {
                ResponseData(false, "Server error", null)
            }
            mResponse.invoke(errorResponse)
        }

    }

    override fun onFailure(call: Call<T>?, t: Throwable?) {
        mResponse.invoke(ResponseData(false, "Server error", null))
    }

    fun execute(response: (ResponseData<T>) -> Unit) {
        mResponse = response
        execute()
    }

    fun execute() {
        getCall().enqueue(this)
    }

    abstract fun getCall(): Call<T>
}