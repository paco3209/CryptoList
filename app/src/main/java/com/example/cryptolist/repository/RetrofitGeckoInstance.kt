package com.example.cryptolist.repository

import com.example.cryptolist.utils.Constants.Companion.BASE_URL_GECKO
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitGeckoInstance {

    companion object{

        private val retrofit by lazy {
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()

            Retrofit.Builder()
                .baseUrl(BASE_URL_GECKO)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }


        val api by lazy {
            retrofit.create(GeckoApi::class.java)
        }

    }

}