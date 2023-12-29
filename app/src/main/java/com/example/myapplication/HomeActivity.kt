package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.adapter.EwalletAdapter
import com.example.myapplication.adapter.SavingDepositAdapter
import com.example.myapplication.databinding.ActivityHomeBinding
import com.example.myapplication.model.EwalletModel
import com.example.myapplication.model.SavingDepositModel

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    private var ewalletAdapter = EwalletAdapter()

    private var dummyEwalletList: MutableList<EwalletModel>? = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpViewEWallet()
        setUpViewSavingDeposit()
    }

    private fun setUpViewEWallet() {
        dummyEwalletList = createDummyEwalletList()

        binding.componentHomeEwallet.rvEwallet.adapter = ewalletAdapter
        ewalletAdapter.setDataEwallet(dummyEwalletList ?: mutableListOf())
        ewalletAdapter.setOnClickEwallet { Ewallet ->

            Toast.makeText(this, "Berhasil menghubungkan ${Ewallet.name}", Toast.LENGTH_SHORT).show()

            dummyEwalletList?.forEach {
                if (it.name == Ewallet.name) it.isConnected = true
            }

            ewalletAdapter.setDataEwallet(dummyEwalletList?.toMutableList() ?: mutableListOf())
        }
    }

    private fun createDummyEwalletList(): MutableList<EwalletModel> {
        return mutableListOf(
            EwalletModel(name = "Gojek", image = R.drawable.ic_arrow_bacl, balance = 100000.0, isConnected = false),
            EwalletModel(name = "Dana", image = R.drawable.ic_launcher_background, balance = 300000.0, isConnected = false),
            EwalletModel(name = "ShoppePay", image = R.drawable.ic_home_run, balance = 314000.0, isConnected = false),
            EwalletModel(name = "Ovo", image = R.drawable.ic_upload, balance = 500000.0, isConnected = false),
        )
    }

    private fun setUpViewSavingDeposit() {
        binding.componentHomeSavingDeposit.rvSavingDeposit.adapter = SavingDepositAdapter(populateSavingDepositData())
    }

    private fun populateSavingDepositData() : MutableList<SavingDepositModel> {
        return mutableListOf(
            SavingDepositModel(
                savingName = "Tabungan Umroh",
                accountNumber = "4730415473",
                imageCard = R.drawable.ic_card
            ),
            SavingDepositModel(
                savingName = "Tabungan Nikah",
                accountNumber = "4730415473",
                imageCard = R.drawable.ic_card
            ),
            SavingDepositModel(
                savingName = "Tabungan Sunat",
                accountNumber = "4730415473",
                imageCard = R.drawable.ic_card
            ),
            SavingDepositModel(
                savingName = "Tabungan Main",
                accountNumber = "4730415473",
                imageCard = R.drawable.ic_card
            ),
            SavingDepositModel(
                savingName = "Tabungan Mobil",
                accountNumber = "4730415473",
                imageCard = R.drawable.ic_card
            )
        )
    }
}




