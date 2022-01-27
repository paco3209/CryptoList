package com.example.cryptolist.repository

import com.example.cryptolist.data.models.CoinsResponse

class GeckoRepositoryImpl: GeckoRepository {
    override suspend fun getCoinsByMarketCap(
        page: Int,
        vs_currency: String,
        per_page: Int,
        price_change_percentage: String
    ): CoinsResponse {
        TODO("Not yet implemented")
    }

    override suspend fun searchCoin(
        searchQuery: String,
        vs_currency: String,
        per_page: Int,
        price_change_percentage: String
    ): CoinsResponse {
        TODO("Not yet implemented")
    }
}