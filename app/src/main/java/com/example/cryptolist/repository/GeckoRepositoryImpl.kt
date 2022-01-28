package com.example.cryptolist.repository

import com.example.cryptolist.data.models.CoinsResponse
import com.example.cryptolist.data.remote.GeckoDataSource

class GeckoRepositoryImpl(
    private val dataSource: GeckoDataSource
): GeckoRepository {
    override suspend fun getCoinsByMarketCap(
        page: Int,
        vs_currency: String,
        per_page: Int,
        price_change_percentage: String
    ): CoinsResponse {
        return dataSource.getCoinsList(page, vs_currency, per_page, price_change_percentage)
    }

    override suspend fun searchCoin(
        searchQuery: String,
        vs_currency: String,
        per_page: Int,
        price_change_percentage: String
    ): CoinsResponse {
        return dataSource.searchCoins(searchQuery, vs_currency, per_page, price_change_percentage)
    }
}