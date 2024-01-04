package com.example.myapplication.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.adapter.EwalletAdapter
import com.example.myapplication.adapter.MenuHomeAdapter
import com.example.myapplication.adapter.SavingDepositAdapter
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.model.EwalletModel
import com.example.myapplication.model.MenuModel
import com.example.myapplication.model.SavingDepositModel

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private var ewalletAdapter = EwalletAdapter()

    private var dummyEwalletList: MutableList<EwalletModel>? = mutableListOf()

    private lateinit var savingDepositAdapter: SavingDepositAdapter
    private lateinit var menuAdapter: MenuHomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupViewMenu()
        setUpViewEWallet()
        setUpViewSavingDeposit()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // To avoid memory leaks, nullify the binding object in onDestroyView
        _binding = null
    }

    private fun setUpViewEWallet() {
        dummyEwalletList = createDummyEwalletList()

        binding.componentHomeEwallet.rvEwallet.adapter = ewalletAdapter
        ewalletAdapter.setDataEwallet(dummyEwalletList ?: mutableListOf())
        ewalletAdapter.setOnClickEwallet { Ewallet ->

            Toast.makeText(context, "Berhasil menghubungkan ${Ewallet.name}", Toast.LENGTH_SHORT).show()

            dummyEwalletList?.forEach {
                if (it.name == Ewallet.name) it.isConnected = true
            }

            ewalletAdapter.setDataEwallet(dummyEwalletList?.toMutableList() ?: mutableListOf())
        }
    }

    // move to viewModel
    private fun createDummyEwalletList(): MutableList<EwalletModel> {
        return mutableListOf(
            EwalletModel(name = "Gojek", image = R.drawable.ic_arrow_bacl, balance = 100000.0, isConnected = false),
            EwalletModel(name = "Dana", image = R.drawable.ic_launcher_background, balance = 300000.0, isConnected = false),
            EwalletModel(name = "ShoppePay", image = R.drawable.ic_home_run, balance = 314000.0, isConnected = false),
            EwalletModel(name = "Ovo", image = R.drawable.ic_upload, balance = 500000.0, isConnected = false),
        )
    }

    private fun setUpViewSavingDeposit() {
        savingDepositAdapter = SavingDepositAdapter(populateSavingDepositData())
        binding.componentHomeSavingDeposit.rvSavingDeposit.adapter = savingDepositAdapter
        updateSizeSavingDeposit(populateSavingDepositData())
    }

    private fun updateSizeSavingDeposit(data: MutableList<SavingDepositModel>) {
        binding.componentHomeSavingDeposit.llShowMore.isVisible = data.size > 2
        binding.componentHomeSavingDeposit.llShowMore.setOnClickListener {
            savingDepositAdapter.updateQuantityDepositSize(data.size)
            binding.componentHomeSavingDeposit.llShowMore.visibility = View.GONE
            binding.componentHomeSavingDeposit.llShowLess.visibility = View.VISIBLE
        }

        binding.componentHomeSavingDeposit.llShowLess.setOnClickListener {
            savingDepositAdapter.updateQuantityDepositSize(2)
            binding.componentHomeSavingDeposit.llShowMore.visibility = View.VISIBLE
            binding.componentHomeSavingDeposit.llShowLess.visibility = View.GONE
        }
    }

    // move to viewModel

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

    // move to viewModel
    private fun populateDataMenuHome() : List<MenuModel> {
        return listOf(
            MenuModel(
                image = R.drawable.ic_upload,
                menuTitle = "Transfer"
            ),
            MenuModel(
                image = R.drawable.ic_upload,
                menuTitle = "Cek Saldo"
            ),
            MenuModel(
                image = R.drawable.ic_upload,
                menuTitle = "E-Wallet"
            ),
            MenuModel(
                image = R.drawable.ic_upload,
                menuTitle = "Donasi"
            ),
            MenuModel(
                image = R.drawable.ic_upload,
                menuTitle = "Zakat"
            ),
            MenuModel(
                image = R.drawable.ic_upload,
                menuTitle = "Cashless"
            ),
            MenuModel(
                image = R.drawable.ic_upload,
                menuTitle = "Tabungan Deposito"
            ),
            MenuModel(
                image = R.drawable.ic_upload,
                menuTitle = "Setting"
            ),
            MenuModel(
                image = R.drawable.ic_upload,
                menuTitle = "Zakat"
            ),
            MenuModel(
                image = R.drawable.ic_upload,
                menuTitle = "Cashless"
            ),
            MenuModel(
                image = R.drawable.ic_upload,
                menuTitle = "Tabungan Deposito"
            ),
            MenuModel(
                image = R.drawable.ic_upload,
                menuTitle = "Setting"
            ),
            MenuModel(
                image = R.drawable.ic_upload,
                menuTitle = "Zakat"
            ),
            MenuModel(
                image = R.drawable.ic_upload,
                menuTitle = "Cashless"
            ),
            MenuModel(
                image = R.drawable.ic_upload,
                menuTitle = "Tabungan Deposito"
            ),
            MenuModel(
                image = R.drawable.ic_upload,
                menuTitle = "Setting"
            ),
        )
    }

    private fun setupViewMenu() {
        menuAdapter = MenuHomeAdapter(populateDataMenuHome())
        binding.componentMenuHome.gridHome.adapter = menuAdapter
        binding.componentMenuHome.gridHome.layoutManager = GridLayoutManager(
            context,
            2,
            RecyclerView.HORIZONTAL,
            false
        )
    }
}
