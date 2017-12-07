package com.victorpetrovski.cryptotracker.data.model

/**
 * Created by Victor on 12/7/17.
 */

data class Currency(
        val id: String,
        val name: String,
        val symbol: String,
        val rank: String,
        val price_usd: String,
        val price_btc: String,
        val market_cap_usd: String,
        val available_supply: String,
        val total_supply: String,
        val max_supply: String,
        val percent_change_1h: String,
        val percent_change_24h: String,
        val percent_change_7d: String,
        val last_updated: String,
        val price_czk: String
)