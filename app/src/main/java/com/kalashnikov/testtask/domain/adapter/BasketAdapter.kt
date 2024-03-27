package com.kalashnikov.testtask.domain.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kalashnikov.testtask.databinding.ItemBasketBinding

class BasketAdapter(private val interfaceBasket: InterfaceBasket): RecyclerView.Adapter<BasketAdapter.BasketHolder>(){
    private val list = ArrayList<BasketData>()

    class BasketHolder(private val binding: ItemBasketBinding) : RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(data: BasketData, interfaceBasket: InterfaceBasket) = with(binding) {
            textName.text = data.name
            textPrice.text = "${data.price} ₽ "
            textWeight.text = "· ${data.weight}г"
            imageBasket.setImageResource(data.image)
            textCounter.text = data.quantity.toString()

            buttonMinus.setOnClickListener {
                interfaceBasket.onClickBasketMinus(adapterPosition)
            }
            buttonPlus.setOnClickListener {
                interfaceBasket.onClickBasketPlus(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasketHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBasketBinding.inflate(inflater, parent, false)
        return BasketHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: BasketHolder, position: Int) {
        holder.bind(list[position], interfaceBasket)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateAdapter(listItem: List<BasketData>) {
        list.clear()
        list.addAll(listItem)
        notifyDataSetChanged()
    }

    fun updatePosition(adapterPosition: Int, listItem: List<BasketData>) {
        list.removeAt(adapterPosition)
        list.add(adapterPosition, listItem[0])
        notifyItemChanged(adapterPosition)
    }

    fun deletePosition(adapterPosition: Int) {
        list.removeAt(adapterPosition)
        notifyItemRemoved(adapterPosition)
    }

    interface InterfaceBasket {
        fun onClickBasketMinus(adapterPosition: Int)
        fun onClickBasketPlus(adapterPosition: Int)
    }
}