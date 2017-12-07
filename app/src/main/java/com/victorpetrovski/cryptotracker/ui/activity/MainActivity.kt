package com.victorpetrovski.cryptotracker.ui.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.victorpetrovski.cryptotracker.R
import com.victorpetrovski.cryptotracker.data.model.Currency
import com.victorpetrovski.cryptotracker.viewmodel.CurrencyListViewModel
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: CurrencyListViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(CurrencyListViewModel::class.java)
        viewModel.getMyCurrencyData().observe(this, Observer<List<Currency>> { resources ->
            toast("Retturned: " + resources?.size)
        })
    }
}
