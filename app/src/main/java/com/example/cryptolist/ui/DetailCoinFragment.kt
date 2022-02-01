package com.example.cryptolist.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.cryptolist.R
import com.example.cryptolist.data.models.CoinsItem
import com.example.cryptolist.data.remote.GeckoDataSource
import com.example.cryptolist.databinding.FragmentDetailCoinBinding
import com.example.cryptolist.presentation.GeckoViewModel
import com.example.cryptolist.presentation.GeckoViewModelFactory
import com.example.cryptolist.repository.GeckoRepositoryImpl
import com.example.cryptolist.repository.RetrofitGeckoInstance


class DetailCoinFragment : Fragment(R.layout.fragment_detail_coin) {


    private lateinit var binding: FragmentDetailCoinBinding

    val args: DetailCoinFragmentArgs by navArgs()

    private lateinit var coin: CoinsItem

    private val viewModel by viewModels<GeckoViewModel>{
        GeckoViewModelFactory(
            GeckoRepositoryImpl(
                GeckoDataSource(RetrofitGeckoInstance.api)
            )
        )
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentDetailCoinBinding.bind(view)

        val coinInfo = args.coin

        // falta detallar textview y info

    }
}