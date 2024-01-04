package com.example.myapplication.presentation.message.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.adapter.HistoryTransactionAdapter
import com.example.myapplication.databinding.FragmentHistoryTransactionBinding
import com.example.myapplication.model.HistoryTransactionModel

class HistoryTransactionFragment : Fragment() {


    private var _binding: FragmentHistoryTransactionBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHistoryTransactionBinding.inflate(inflater, container, false)

        setupViewHistoryTransaction()

        return binding.root
    }

    private fun setupViewHistoryTransaction() {
        binding.rvTransaction.adapter = HistoryTransactionAdapter(
            data = populateDataHistoryTransaction(),
            onClickHistoryTransaction = {
                navigateToDetailHistory()
            }
        )
    }

    private fun navigateToDetailHistory() {
        val intent = Intent(context, DetailTransactionActivity::class.java)
        startActivity(intent)
    }

    private fun populateDataHistoryTransaction(): List<HistoryTransactionModel> {
        return listOf(
            HistoryTransactionModel(
                date = "24 Januari 2024",
                titleTransaction = "debit",
                subtitleTransaction = "Transfer Mandiri - Tiara",
                balanceTransaction = "Rp200.000",
                iconTransaction = R.drawable.ic_entire_transaction,
                statusTransaction = 1
            ),
            HistoryTransactionModel(
                date = "27 Januari 2024",
                titleTransaction = "credit",
                subtitleTransaction = "Transfer BCA - Rens",
                balanceTransaction = "Rp100.000",
                iconTransaction = R.drawable.ic_out_transaction,
                statusTransaction = 2
            )
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}