package com.yupi.nearlabsapp.extensions

import android.widget.TextView

fun TextView.initials(name: String) {
    val split = name.split(" ")
    if (split.isNotEmpty()) {
        val firstL = split[0].first()
        val secondL = split[1].first()
        this
            .text = "$firstL$secondL"
    }
}