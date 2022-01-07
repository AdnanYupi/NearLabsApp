package com.yupi.nearlabsapp.views.fragments.main

import android.view.LayoutInflater
import android.view.ViewGroup
import com.yupi.nearlabsapp.base.MainBaseFragment
import com.yupi.nearlabsapp.databinding.FragmentHistoryBinding

class HistoryFragment: MainBaseFragment<FragmentHistoryBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHistoryBinding
        get() = FragmentHistoryBinding::inflate

    override fun inflated() {
    }
}