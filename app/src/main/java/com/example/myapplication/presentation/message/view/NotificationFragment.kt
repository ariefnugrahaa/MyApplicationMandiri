package com.example.myapplication.presentation.message.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.myapplication.adapter.NotificationAdapter
import com.example.myapplication.base.BaseFragment
import com.example.myapplication.databinding.FragmentHistoryTransactionBinding
import com.example.myapplication.databinding.FragmentNotificationBinding
import com.example.myapplication.databinding.FragmentPromoBinding
import com.example.myapplication.model.NotificationModel
import com.example.myapplication.presentation.viewmodel.NotificationViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NotificationFragment : BaseFragment<FragmentNotificationBinding>() {

    private val viewModel: NotificationViewModel by viewModels()

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentNotificationBinding {
        return FragmentNotificationBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
        viewModel.setNotificationData(populateDateNotification())
        binding.rvMessage.setOnClickListener { viewModel.updateCustomData() }
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.notificationData.observe(viewLifecycleOwner) {
            setNotificationData(it)
        }
    }

    private fun setNotificationData(data: List<NotificationModel>) {
        binding.rvMessage.adapter = NotificationAdapter(data)
    }

    private fun populateDateNotification(): List<NotificationModel> {
        return listOf(
            NotificationModel(
                date = "23 september 2023",
                title = "Selamat Anda mendaatkan Mobil",
                subtitle = "jsdkadshdhadlaskhdksladhlsahdlahdlaskdasd"
            ),
            NotificationModel(
                date = "23 september 2023",
                title = "Selamat Anda mendaatkan Mobil",
                subtitle = "jsdkadshdhadlaskhdksladhlsahdlahdlaskdasd"
            ),
            NotificationModel(
                date = "23 september 2023",
                title = "Selamat Anda mendaatkan Mobil",
                subtitle = "jsdkadshdhadlaskhdksladhlsahdlahdlaskdasd"
            ),
            NotificationModel(
                date = "23 september 2023",
                title = "Selamat Anda mendaatkan Mobil",
                subtitle = "jsdkadshdhadlaskhdksladhlsahdlahdlaskdasd"
            ),
            NotificationModel(
                date = "23 september 2023",
                title = "Selamat Anda mendaatkan Mobil",
                subtitle = "jsdkadshdhadlaskhdksladhlsahdlahdlaskdasd"
            ),
            NotificationModel(
                date = "23 september 2023",
                title = "Selamat Anda mendaatkan Mobil",
                subtitle = "jsdkadshdhadlaskhdksladhlsahdlahdlaskdasd"
            ),
            NotificationModel(
                date = "23 september 2023",
                title = "Selamat Anda mendaatkan Mobil",
                subtitle = "jsdkadshdhadlaskhdksladhlsahdlahdlaskdasd"
            ),
            NotificationModel(
                date = "23 september 2023",
                title = "Selamat Anda mendaatkan Mobil",
                subtitle = "jsdkadshdhadlaskhdksladhlsahdlahdlaskdasd"
            ),
        )
    }


}