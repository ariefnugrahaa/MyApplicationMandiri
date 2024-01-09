package com.example.myapplication.presentation.message

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.myapplication.adapter.MessageTabAdapter
import com.example.myapplication.base.BaseFragment
import com.example.myapplication.databinding.FragmentMessageBinding
import com.example.myapplication.presentation.message.view.HistoryTransactionFragment
import com.example.myapplication.presentation.message.view.NotificationFragment
import com.google.android.material.tabs.TabLayoutMediator

class MessageFragment : BaseFragment<FragmentMessageBinding>() {

    private var adapterMessage : MessageTabAdapter? = null

    override fun inflateBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentMessageBinding {
        return FragmentMessageBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
        setupTabView()
    }

    private fun setupTabView() {
        val tabLayout = binding.tabMessage
        val viewPager = binding.vpMessage
        adapterMessage = MessageTabAdapter(this)
        adapterMessage?.addListFragment(NotificationFragment())
        adapterMessage?.addListFragment(HistoryTransactionFragment())
        viewPager.adapter = adapterMessage

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when(position) {
                0 -> {
                    tab.text = "Notification"
                }
                1 -> {
                    tab.text = "History"
                }
            }
        }.attach()
    }




}
