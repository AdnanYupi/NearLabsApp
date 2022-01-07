package com.yupi.nearlabsapp.views.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import com.yupi.nearlabsapp.R
import com.yupi.nearlabsapp.base.BaseActivity
import com.yupi.nearlabsapp.databinding.ActivityMainBinding
import com.yupi.nearlabsapp.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override val viewModel: MainViewModel
       by viewModels()

    override val bindingInflater: (LayoutInflater) -> ActivityMainBinding
        get() = ActivityMainBinding::inflate

    override fun inflated() {
      initNavController()
    }

    private fun initNavController() {

    }
}