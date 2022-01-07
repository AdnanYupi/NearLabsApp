package com.yupi.nearlabsapp.views.fragments.onboarding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.yupi.nearlabsapp.base.OnBoardingBaseFragment
import com.yupi.nearlabsapp.databinding.FragmentVerificationBinding
import com.yupi.nearlabsapp.viewmodels.OnBoardingViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VerificationFragment: OnBoardingBaseFragment<FragmentVerificationBinding, OnBoardingViewModel>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentVerificationBinding
        get() = FragmentVerificationBinding::inflate

    override fun inflated() {
        binding?.button?.setOnClickListener {
            viewModel.nextScreen()
        }
    }

    override val viewModel: OnBoardingViewModel
        by activityViewModels()


}