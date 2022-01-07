package com.yupi.nearlabsapp.views.fragments.onboarding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.yupi.nearlabsapp.base.OnBoardingBaseFragment
import com.yupi.nearlabsapp.databinding.FragmentCreateAccountBinding
import com.yupi.nearlabsapp.viewmodels.OnBoardingViewModel

class CreateAccountFragment: OnBoardingBaseFragment<FragmentCreateAccountBinding, OnBoardingViewModel>() {

    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentCreateAccountBinding
        get() = FragmentCreateAccountBinding::inflate

    override fun inflated() {
        binding?.createAccountBtn?.setOnClickListener {
            viewModel.nextScreen()
        }
    }

    override val viewModel: OnBoardingViewModel
        by activityViewModels()
}