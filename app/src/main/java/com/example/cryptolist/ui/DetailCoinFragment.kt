package com.example.cryptolist.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
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


        Glide.with(requireContext())
            .load(coinInfo?.image)
            .centerCrop()
            .into(binding.ivCoinImage)


        //falta ajustar valores de importe y porcentajes
        binding.txtCoinName.text = coinInfo?.name
        binding.txtSymbol.text = "( " + coinInfo?.symbol + " )"
        binding.txtCurrentPrice.text = "$ " + coinInfo?.current_price.toString()
        binding.txtPriceChange24.text = "$ " + coinInfo?.price_change_24h.toString()
        binding.txtMarketCap.text = "$ " + coinInfo?.market_cap.toString()
        binding.txtCirculating.text = coinInfo?.circulating_supply.toString()
        binding.txtHigh24.text = "$ " + coinInfo?.high_24h.toString()
        binding.txtLow24.text = "$ " + coinInfo?.low_24h.toString()







    }
}