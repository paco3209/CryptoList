package com.example.cryptolist.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cryptolist.data.models.CoinsItem
import com.example.cryptolist.databinding.ItemCoinBinding

class Adapter(

    private val context: Context,
    private val itemClickListener: OnCoinClickListener
): RecyclerView.Adapter<BaseViewHolder<*>>() {


    private var coinsList = listOf<CoinsItem>()

    fun setCoinsList(coinsList: List<CoinsItem>){
        this.coinsList = coinsList
        notifyDataSetChanged()
    }

    interface OnCoinClickListener{
        fun onCoinClick(coin: CoinsItem, position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val itemBinding = ItemCoinBinding.inflate(LayoutInflater.from(context),parent,false)
        val holder = CoinViewHolder(itemBinding)


        itemBinding.root.setOnClickListener {
            val position = holder.adapterPosition.takeIf {
                it != DiffUtil.DiffResult.NO_POSITION
            } ?:return@setOnClickListener

            itemClickListener.onCoinClick(coinsList[position],position)
        }
        return holder


    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when(holder){
            is CoinViewHolder -> holder.bind(coinsList[position])
        }
    }

    override fun getItemCount(): Int {
        return coinsList.size
    }

    private inner class CoinViewHolder(
        val binding: ItemCoinBinding
    ): BaseViewHolder<CoinsItem>(binding.root){
        override fun bind(item: CoinsItem) = with(binding) {
            Glide.with(context)
                .load(item.image)
                .centerCrop()
                .into(ivCoinImage)
            tvValue.text = item.name
            tvSymbol.text = item.symbol
            tvCoin.text = item.name
            tvPercentaje.text = item.price_change_percentage_24h.toString()
            tvVariation.text = item.price_change_24h.toString()

        }

    }


}