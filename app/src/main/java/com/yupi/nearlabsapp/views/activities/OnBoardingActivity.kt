package com.yupi.nearlabsapp.views.activities

import android.view.LayoutInflater
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import com.yupi.nearlabsapp.R
import com.yupi.nearlabsapp.base.BaseActivity
import com.yupi.nearlabsapp.bindings.changeScreenTitle
import com.yupi.nearlabsapp.databinding.ActivityOnboardingBinding
import com.yupi.nearlabsapp.enums.OnBoardingEnum
import com.yupi.nearlabsapp.extensions.navigateAnimated
import com.yupi.nearlabsapp.viewmodels.OnBoardingViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_onboarding.view.*

@AndroidEntryPoint
class OnBoardingActivity : BaseActivity<ActivityOnboardingBinding, OnBoardingViewModel>() {

    override val viewModel: OnBoardingViewModel
            by viewModels()

    override val bindingInflater: (LayoutInflater) -> ActivityOnboardingBinding
        get() = ActivityOnboardingBinding::inflate

    override fun inflated() {
        initViews()

        viewModel.goNextScreen.observe(this, Observer {
            if (it == null)
                return@Observer
            when(it) {
                OnBoardingEnum.VERIFICATION -> {
                    findNavController(R.id.onboarding_host_fragment_container)
                        .navigate(R.id.verificationFragment)
                    changeScreenTitle(getString(R.string.verification))
                    binding?.screensProgressBar?.progress = 30
                }

                OnBoardingEnum.CREATE_ACCOUNT -> {
                    findNavController(R.id.onboarding_host_fragment_container)
                        .navigateAnimated(R.id.action_verificationFragment_to_createAccountFragment)
                    changeScreenTitle(getString(R.string.create_near_account))
                    binding?.screensProgressBar?.progress = 60
                }

                OnBoardingEnum.GIFT_NFT -> {
                    findNavController(R.id.onboarding_host_fragment_container)
                        .navigateAnimated(R.id.action_createAccountFragment_to_giftNftFragment)
                    changeScreenTitle(getString(R.string.gift_nft))
                    binding?.screensProgressBar?.visibility = View.INVISIBLE
                }
            }
        })
    }

    private fun initViews() {
        viewModel.initFirstScreen()

        binding?.closeBtn?.setOnClickListener {
            finish()
        }
    }

    private fun changeScreenTitle(title: String) {
        viewModel.screenTitle = title
        binding?.root?.screenTitle?.changeScreenTitle(viewModel.screenTitle)
    }

}