package com.example.myapplication.presentation.message.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.adapter.HistoryTransactionAdapter
import com.example.myapplication.base.BaseFragment
import com.example.myapplication.databinding.FragmentHistoryTransactionBinding
import com.example.myapplication.model.HistoryTransactionModel
import com.example.myapplication.utils.ConfirmationDialogUtil

class HistoryTransactionFragment : BaseFragment<FragmentHistoryTransactionBinding>() {

    private var _historyAdapter: HistoryTransactionAdapter? = null
    private var _historyTransactionData: List<HistoryTransactionModel>? = null

    override fun inflateBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentHistoryTransactionBinding {
        return FragmentHistoryTransactionBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
        setupViewHistoryTransaction()

        val items = arrayOf("Semua", "Debit", "Credit")
        binding.spFilterTransaction.adapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, items)

        binding.spFilterTransaction.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                val spinnerValue = p0?.getItemAtPosition(position).toString()
                binding.tvFilterName.text = spinnerValue

                if (spinnerValue == "Semua") {
                    _historyAdapter?.filterTransactionData(populateDataHistoryTransaction())
                } else {
                    populateDataHistoryTransaction().filter { it.titleTransaction == spinnerValue.lowercase() }.also { historyData ->
                        _historyAdapter?.filterTransactionData(historyData)
                    }
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) = Unit
        }
    }

    private fun setupViewHistoryTransaction() {
        _historyTransactionData = populateDataHistoryTransaction()
        _historyAdapter = HistoryTransactionAdapter(
            data = populateDataHistoryTransaction(),
            onClickHistoryTransaction = {
                showDialog(it)
            }
        )
        binding.rvTransaction.adapter = _historyAdapter
    }

    private fun showDialog(data: HistoryTransactionModel) {
        ConfirmationDialogUtil(requireContext()).showConfirmationDialog(
            title = data.titleTransaction,
            icon = null,
            onConfirm = {
                DetailTransactionActivity.navigateToDetailTransaction(
                    activity = requireActivity(),
                    data = data
                )
            },
            onCancel = {

            }

        )
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
            ),
            HistoryTransactionModel(
                date = "24 Januari 2024",
                titleTransaction = "debit",
                subtitleTransaction = "Transfer Mandiri - Tiara",
                balanceTransaction = "Rp200.000",
                iconTransaction = R.drawable.ic_entire_transaction,
                statusTransaction = 1
            ),
            HistoryTransactionModel(
                date = "24 Januari 2024",
                titleTransaction = "debit",
                subtitleTransaction = "Transfer Mandiri - Tiara",
                balanceTransaction = "Rp200.000",
                iconTransaction = R.drawable.ic_entire_transaction,
                statusTransaction = 1
            ),
            HistoryTransactionModel(
                date = "24 Januari 2024",
                titleTransaction = "debit",
                subtitleTransaction = "Transfer Mandiri - Tiara",
                balanceTransaction = "Rp200.000",
                iconTransaction = R.drawable.ic_entire_transaction,
                statusTransaction = 1
            ),
            HistoryTransactionModel(
                date = "24 Januari 2024",
                titleTransaction = "credit",
                subtitleTransaction = "Transfer Mandiri - Tiara",
                balanceTransaction = "Rp200.000",
                iconTransaction = R.drawable.ic_entire_transaction,
                statusTransaction = 1
            ),
        )
    }


}