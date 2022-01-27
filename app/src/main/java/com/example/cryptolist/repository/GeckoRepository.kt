package com.example.cryptolist.repository

import com.example.cryptolist.data.models.CoinsResponse

interface GeckoRepository {

    suspend fun getCoinsByMarketCap(
        page: Int,
        vs_currency: String,
        per_page: Int,
        price_change_percentage: String
                                    ) : CoinsResponse


    suspend fun searchCoin(
        searchQuery: String,
        vs_currency: String,
        per_page: Int,
        price_change_percentage: String
    ): CoinsResponse
}