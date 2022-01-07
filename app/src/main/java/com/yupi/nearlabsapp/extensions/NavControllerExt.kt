package com.yupi.nearlabsapp.extensions

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import com.yupi.nearlabsapp.R

fun NavController.navigateAnimated(resId: Int, args: Bundle? = null, navOptions: NavOptions? = null) {
    navigate(resId, args, navOptions ?: androidx.navigation.navOptions {
        anim {
            enter = R.anim.slide_in
        }
    })
}