package com.example.myapplication.presentation.message.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityDetailTransactionBinding
import com.example.myapplication.model.HistoryTransactionModel
import com.example.myapplication.model.StatusTransaction

class DetailTransactionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailTransactionBinding

    private var data: HistoryTransactionModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTransactionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.componentToolbar.tvToolbarTitle.text = "Detail History"
        binding.componentToolbar.ivBack.setOnClickListener {
            onBackPressed()
        }

        data = intent?.getParcelableExtra(DATA_TRANSACTION)
        setupViewDetail(data)
    }

    private fun checkStatusTransaction() : String {
        val dataTrans = data?.statusTransaction
        var resultTransaction = ""
        when (dataTrans) {
            StatusTransaction.Berhasil.value -> resultTransaction = "Berhasil"
        }
        return resultTransaction
    }

    private fun setupViewDetail(data: HistoryTransactionModel?) {
        val textDetail = "transaksi saya ${data?.statusTransaction}"
        binding.tvDetailTransaction.text = textDetail
    }

    companion object {
        const val DATA_TRANSACTION = "dataTransaction"
        fun navigateToDetailTransaction(activity: Activity, data: HistoryTransactionModel) {
            val intent = Intent(activity, DetailTransactionActivity::class.java)
            intent.putExtra(DATA_TRANSACTION, data)
            activity.startActivity(intent)
        }
    }
}








