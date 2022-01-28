package com.example.cryptolist.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.cryptolist.repository.GeckoRepository
import com.example.cryptolist.utils.Resource
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class GeckoViewModel (private val repository: GeckoRepository): ViewModel() {


    fun fetchCoins() = liveData(Dispatchers.IO) {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(repository.getCoinsByMarketCap(1,"usd",20,"1h,7d,30d" )))
        }catch (e: Exception){
            emit(Resource.Failure(e))
        }

    }





}

class GeckoViewModelFactory(private val repo: GeckoRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(GeckoRepository::class.java).newInstance(repo)
    }
}