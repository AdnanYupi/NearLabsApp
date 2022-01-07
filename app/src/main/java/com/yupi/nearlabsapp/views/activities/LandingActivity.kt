package com.yupi.nearlabsapp.views.activities

import android.view.LayoutInflater
import androidx.activity.viewModels
import com.yupi.nearlabsapp.base.BaseActivity
import com.yupi.nearlabsapp.databinding.ActivityLandingBinding
import com.yupi.nearlabsapp.viewmodels.OnBoardingViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LandingActivity: BaseActivity<ActivityLandingBinding, OnBoardingViewModel>() {

    override val viewModel: OnBoardingViewModel
        by viewModels()

    override val bindingInflater: (LayoutInflater) -> ActivityLandingBinding
        get() = ActivityLandingBinding::inflate

    override fun inflated() {
        binding?.getStartedBtn?.setOnClickListener {
            startActivityAnimated(OnBoardingActivity::class.java)
        }
    }
}