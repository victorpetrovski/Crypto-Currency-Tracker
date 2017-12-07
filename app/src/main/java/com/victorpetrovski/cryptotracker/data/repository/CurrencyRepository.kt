package com.victorpetrovski.cryptotracker.data.model.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.victorpetrovski.cryptotracker.data.model.Currency
import com.victorpetrovski.cryptotracker.data.network.task.GetCurrencyTask

/**
 * Created by Victor on 12/7/17.
 */
class CurrencyRepository {

    fun getLatestCurrencyList(): LiveData<List<Currency>> {
        val data: MutableLiveData<List<Currency>> = MutableLiveData()
        GetCurrencyTask().execute { responseData -> data.value = responseData.data }
        return data
    }
}