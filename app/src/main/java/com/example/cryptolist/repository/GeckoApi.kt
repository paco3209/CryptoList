package com.example.cryptolist.repository

import com.example.cryptolist.data.models.CoinsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GeckoApi {


    @GET("coins/markets")
    suspend fun getCoinsList(
        @Query("page")
        page: Int = 1,
        @Query("vs_currency")
        vs_currency: String = "usd",
        @Query("per_page")
        per_page: Int = 20,

        @Query("price_change_percentage")
        price_change_percentage: String = "1h,7d,30d"
    ) : CoinsResponse

    @GET("coins/markets")
    suspend fun searchCoin(
        @Query("ids")
        searchQuery: String,
        @Query("vs_currency")
        vs_currency: String = "usd",
        @Query("per_page")
        per_page: Int = 20,
        @Query("price_change_percentage")
        price_change_percentage: String = "1h,7d,30d"
    ) : CoinsResponse
}