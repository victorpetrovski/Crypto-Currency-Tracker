package com.victorpetrovski.cryptotracker.data.network.`interface`

import com.victorpetrovski.cryptotracker.data.model.Currency
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Victor on 11/20/17.
 */

const val API_BASE_URL = " https://api.coinmarketcap.com/"
const val version = "v1/"

interface CurrencyListInterface {

    @GET(version + "ticker")

    fun getCurrencyList(@Query("limit") page: Int = 25): Call<List<Currency>>
}