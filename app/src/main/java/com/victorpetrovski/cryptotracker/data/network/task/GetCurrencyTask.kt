package com.victorpetrovski.cryptotracker.data.network.task

import com.victorpetrovski.cryptotracker.data.model.Currency
import com.victorpetrovski.cryptotracker.data.network.`interface`.CurrencyListInterface
import com.victorpetrovski.cryptotracker.data.network.base.NetworkManager
import com.victorpetrovski.cryptotracker.data.network.base.NetworkTask
import retrofit2.Call

/**
 * Created by Victor on 12/7/17.
 */

class GetCurrencyTask : NetworkTask<List<Currency>>() {
    override fun getCall(): Call<List<Currency>> = NetworkManager(CurrencyListInterface::class.java).create().getCurrencyList()
}
