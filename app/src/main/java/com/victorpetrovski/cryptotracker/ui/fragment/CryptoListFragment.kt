package com.victorpetrovski.cryptotracker.ui.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.victorpetrovski.cryptotracker.R
import com.victorpetrovski.cryptotracker.data.model.Currency
import com.victorpetrovski.cryptotracker.viewmodel.CurrencyListViewModel

class CryptoListFragment : Fragment() {

    lateinit var viewModel: CurrencyListViewModel

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_crypto_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(CurrencyListViewModel::class.java)
        viewModel.getMyCurrencyData().observe(this, Observer<List<Currency>> { resources ->


        } )

    }


}// Required empty public constructor
