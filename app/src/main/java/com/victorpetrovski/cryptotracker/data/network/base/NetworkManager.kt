package com.victorpetrovski.cryptotracker.data.network.base

import com.victorpetrovski.cryptotracker.data.network.`interface`.API_BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*


/**
 * Created by Victor on 11/18/17.
 */
open class NetworkManager<out T>(private val service: Class<T>) {

    fun create(): T {
        return buildRetrofit().build().create(service)
    }

    fun buildRetrofit(): Retrofit.Builder {
        val httpClient = OkHttpClient.Builder()
        // add logging as last interceptor
        val logging = HttpLoggingInterceptor()
        // set your desired log level
        logging.level = HttpLoggingInterceptor.Level.BODY
        httpClient.addInterceptor(logging)

        for (header in getHeaders()) {
            //Add header values
            httpClient.addInterceptor { chain ->
                val original = chain.request()

                // Request customization: add request headers
                val requestBuilder = original.newBuilder()
                        .header(header.key, header.value)

                val request = requestBuilder.build()

                chain.proceed(request)
            }
        }

        val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(getBaseUrl())
                .client(httpClient.build())

        return retrofit
    }

    open fun getHeaders(): MutableMap<String, String> {
        return HashMap()
    }

    open fun getBaseUrl(): String {
        return API_BASE_URL
    }

}