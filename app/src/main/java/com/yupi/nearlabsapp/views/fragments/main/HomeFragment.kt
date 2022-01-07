package com.yupi.nearlabsapp.views.fragments.main

import android.view.LayoutInflater
import android.view.ViewGroup
import com.yupi.nearlabsapp.base.MainBaseFragment
import com.yupi.nearlabsapp.databinding.FragmentHomeBinding

class HomeFragment: MainBaseFragment<FragmentHomeBinding>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate

    override fun inflated() {
    }
}