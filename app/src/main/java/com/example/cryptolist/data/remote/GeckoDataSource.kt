package com.example.cryptolist.data.remote

import com.example.cryptolist.data.models.CoinsResponse
import com.example.cryptolist.repository.GeckoApi

class GeckoDataSource(private val geckoService: GeckoApi) {

    suspend fun getCoinsList(
        page: Int,
        vs_currency: String,
        per_page: Int,
        price_change_percentage: String
    ): CoinsResponse = geckoService.getCoinsList(page, vs_currency, per_page, price_change_percentage)


    suspend fun searchCoins(
        searchQuery: String,
        vs_currency: String,
        per_page: Int,
        price_change_percentage: String
    ): CoinsResponse = geckoService.searchCoin(searchQuery, vs_currency, per_page, price_change_percentage)

}

