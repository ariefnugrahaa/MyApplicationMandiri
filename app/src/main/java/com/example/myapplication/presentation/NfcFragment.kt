package com.example.myapplication.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.myapplication.base.BaseFragment
import com.example.myapplication.databinding.FragmentMessageBinding

class NfcFragment : BaseFragment<FragmentMessageBinding>() {

    override fun inflateBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentMessageBinding {
        return FragmentMessageBinding.inflate(inflater, container, false)
    }

    override fun setupView() {

    }


}