package com.example.myapplication.presentation.message

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.adapter.MessageTabAdapter
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.databinding.FragmentMessageBinding
import com.example.myapplication.presentation.message.view.HistoryTransactionFragment
import com.example.myapplication.presentation.message.view.NotificationFragment
import com.google.android.material.tabs.TabLayoutMediator

class MessageFragment : Fragment() {

    private var _binding: FragmentMessageBinding? = null
    private val binding get() = _binding!!
    private var _testBool = false

    private var adapterMessage : MessageTabAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMessageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
