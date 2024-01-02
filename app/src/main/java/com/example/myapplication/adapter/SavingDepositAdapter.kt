package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemSavingDepositBinding
import com.example.myapplication.model.SavingDepositModel

class SavingDepositAdapter(
    private val savingDepositData: MutableList<SavingDepositModel>
) : RecyclerView.Adapter<SavingDepositAdapter.SavingDepositViewHolder>() {

    private var maximumItems = 2

    inner class SavingDepositViewHolder(private val itemBinding: ItemSavingDepositBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(data: SavingDepositModel) {
            itemBinding.tvSavingDepositName.text = data.savingName
            itemBinding.tvAccountNumber.text = data.accountNumber
            itemBinding.ivCardHolder.setImageResource(data.imageCard)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SavingDepositViewHolder {
        return SavingDepositViewHolder(
            ItemSavingDepositBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = if (savingDepositData.size >= 2) maximumItems else savingDepositData.size

    override fun onBindViewHolder(holder: SavingDepositViewHolder, position: Int) {
        holder.bind(savingDepositData[position])
    }

    fun updateQuantityDepositSize(sizeUpdated: Int) {
        maximumItems = sizeUpdated
        notifyDataSetChanged()
    }
}