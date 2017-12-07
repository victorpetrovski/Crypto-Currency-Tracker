package com.victorpetrovski.cryptotracker.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.victorpetrovski.cryptotracker.data.model.Currency
import com.victorpetrovski.cryptotracker.data.model.repository.CurrencyRepository


/**
 * Created by Victor on 12/7/17.
 */
class CurrencyListViewModel : ViewModel() {

    val mCurrencyRepository = CurrencyRepository()
    var currencyData: LiveData<List<Currency>>

    init {
        currencyData = mCurrencyRepository.getLatestCurrencyList()
    }

    fun getMyCurrencyData(): LiveData<List<Currency>> {
        return currencyData
    }

}

