package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.databinding.ItemHistoryTransactionBinding
import com.example.myapplication.model.HistoryTransactionModel
import com.example.myapplication.model.StatusTransaction

class HistoryTransactionAdapter(
    private var data: List<HistoryTransactionModel>,
    private val onClickHistoryTransaction: (HistoryTransactionModel) -> Unit
) : RecyclerView.Adapter<HistoryTransactionAdapter.TransactionHistoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionHistoryViewHolder {
        return TransactionHistoryViewHolder(
            ItemHistoryTransactionBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    fun filterTransactionData(updatedData: List<HistoryTransactionModel>) {
        this.data = updatedData
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: TransactionHistoryViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size

    inner class TransactionHistoryViewHolder(val binding: ItemHistoryTransactionBinding) :
        RecyclerView.ViewHolder(binding.root) {

            fun bind(data: HistoryTransactionModel) {
                binding.tvDate.text = data.date
                binding.tvTitleNotif.text = data.titleTransaction
                binding.tvSubtitleNotif.text = data.subtitleTransaction
                binding.tvBalance.text = data.balanceTransaction
                binding.ivLogoTransaction.setImageResource(data.iconTransaction)

                when (data.statusTransaction) {
                    StatusTransaction.Berhasil.value -> {
                        binding.statusTransaction.text = "Berhasil"
                        binding.statusTransaction.setTextColor(binding.root.context.getColor(R.color.green))
                    }
                    StatusTransaction.Gagal.value -> {
                        binding.statusTransaction.text = "Gagal"
                        binding.statusTransaction.setTextColor(binding.root.context.getColor(R.color.red))
                    }
                    StatusTransaction.Pending.value -> {
                        binding.statusTransaction.text = "Pending"
                        binding.statusTransaction.setTextColor(binding.root.context.getColor(R.color.blue))
                    }
                }

                binding.constraintItemTransaction.setOnClickListener {
                    onClickHistoryTransaction.invoke(data)
                }
            }
    }
}