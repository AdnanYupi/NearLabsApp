package com.yupi.nearlabsapp.bindings

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.yupi.nearlabsapp.R

@BindingAdapter("setTxt")
fun TextView.setTxt(isPhone: Boolean) {
    this.text = if (isPhone) this.context.getString(R.string.send_to_a_different_phone_number)
    else this.context.getString(R.string.send_to_a_different_email_address)
}

@BindingAdapter("screenTitle")
fun TextView.changeScreenTitle(title: String?) {
    this.text = title
}