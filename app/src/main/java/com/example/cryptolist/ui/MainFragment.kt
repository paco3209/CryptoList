package com.example.cryptolist.ui

import android.os.Binder
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.cryptolist.R
import com.example.cryptolist.data.models.CoinsItem
import com.example.cryptolist.data.remote.GeckoDataSource
import com.example.cryptolist.databinding.FragmentMainBinding
import com.example.cryptolist.presentation.GeckoViewModel
import com.example.cryptolist.presentation.GeckoViewModelFactory
import com.example.cryptolist.repository.GeckoRepositoryImpl
import com.example.cryptolist.repository.RetrofitGeckoInstance
import com.example.cryptolist.utils.Resource


class MainFragment : Fragment(R.layout.fragment_main), Adapter.OnCoinClickListener {


    private lateinit var coinsAdapter: Adapter
    private lateinit var binding: FragmentMainBinding
    private val viewModel by viewModels<GeckoViewModel>{
        GeckoViewModelFactory(
            GeckoRepositoryImpl(
                GeckoDataSource(RetrofitGeckoInstance.api)
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        coinsAdapter = Adapter(requireContext(),this)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentMainBinding.bind(view)

        val verticalDecorator = DividerItemDecoration(view.context, DividerItemDecoration.VERTICAL)
        val horizontalDecorator = DividerItemDecoration(view.context, DividerItemDecoration.HORIZONTAL)

        val drawable = ContextCompat.getDrawable(view.context, R.drawable.divider_shape)
        verticalDecorator.setDrawable(drawable!!)
        horizontalDecorator.setDrawable(drawable!!)


        binding.rvCoins.apply {
            addItemDecoration(verticalDecorator)
            addItemDecoration(horizontalDecorator)
            layoutManager = LinearLayoutManager(requireContext())
            adapter = coinsAdapter
        }

        viewModel.fetchCoins().observe(viewLifecycleOwner, Observer {
            when(it){
                is Resource.Loading ->{
                    binding.paginationProgressBar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    binding.paginationProgressBar.visibility = View.GONE
                    binding.rvCoins.visibility = View.VISIBLE
                    it.data?.let{
                        coins ->
                        coinsAdapter.setCoinsList(coins)
                    }
                }
                is Resource.Failure -> {
                    binding.paginationProgressBar.visibility = View.GONE
                    Log.d("error","${it.exception}")
                }

            }
        })



    }

    override fun onCoinClick(coin: CoinsItem, position: Int) {
        val bundle = Bundle()
        bundle.putParcelable("coin",coin)
        findNavController().navigate(R.id.action_mainFragment_to_detailCoinFragment,bundle)
    }


}