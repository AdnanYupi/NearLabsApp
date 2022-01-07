package com.yupi.nearlabsapp.base

import androidx.viewbinding.ViewBinding
import com.yupi.nearlabsapp.viewmodels.BaseViewModel

abstract class OnBoardingBaseFragment<VB: ViewBinding, VM: BaseViewModel>: BaseFragment<VB>() {
    abstract val viewModel: VM
}