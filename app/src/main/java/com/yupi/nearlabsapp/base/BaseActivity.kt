package com.yupi.nearlabsapp.base

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.yupi.nearlabsapp.R
import com.yupi.nearlabsapp.viewmodels.BaseViewModel
import java.lang.Exception

abstract class BaseActivity<VB : ViewBinding, VM : BaseViewModel> : AppCompatActivity() {

    abstract val viewModel: VM
    private var _binding: VB? = null
    val binding get() = _binding

    abstract val bindingInflater: (LayoutInflater) -> VB
    abstract fun inflated()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = bindingInflater.invoke(layoutInflater)
        setContentView(_binding?.root)
        setTransparentStatusBar()
        inflated()
    }

    private fun setTransparentStatusBar() {
        try {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
            window.statusBarColor = Color.TRANSPARENT
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    protected fun startActivityAnimated(activity: Class<*>) {
        val intent = Intent(this, activity)
        startActivity(intent)
        //overridePendingTransition(R.anim.slide_in_top, R.anim.slide_from_top)
    }

    fun startClearActivity(activity: Class<*>) {
        val intent = Intent(this, activity)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
        //overridePendingTransition(R.anim.slide_in_top, R.anim.slide_from_top)
    }
}