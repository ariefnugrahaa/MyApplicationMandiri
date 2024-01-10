package com.example.myapplication.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.adapter.EwalletAdapter
import com.example.myapplication.adapter.MenuHomeAdapter
import com.example.myapplication.adapter.SavingDepositAdapter
import com.example.myapplication.base.BaseFragment
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.model.EwalletModel
import com.example.myapplication.model.MenuModel
import com.example.myapplication.model.SavingDepositModel
import com.example.myapplication.presentation.home.viewmodel.HomeViewModel
import com.example.myapplication.presentation.viewmodel.NotificationViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val viewModel: HomeViewModel by viewModels()

    private var ewalletAdapter = EwalletAdapter()
    private var dummyEwalletList: MutableList<EwalletModel>? = mutableListOf()
    private lateinit var savingDepositAdapter: SavingDepositAdapter
    private lateinit var menuAdapter: MenuHomeAdapter

    override fun inflateBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
        setUpViewEWallet()
        setUpViewSavingDeposit()
        viewModel.getMenuHome()
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.homeMenu.observe(viewLifecycleOwner) {
            setupViewMenu(it)
        }
    }

    private fun setupViewMenu(data: List<MenuModel>) {
        menuAdapter = MenuHomeAdapter(data)
        binding.componentMenuHome.gridHome.adapter = menuAdapter
        binding.componentMenuHome.gridHome.layoutManager = GridLayoutManager(
            context,
            2,
            RecyclerView.HORIZONTAL,
            false
        )
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

}
