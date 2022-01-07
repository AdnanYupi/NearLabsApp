package com.yupi.nearlabsapp.util

import com.google.gson.Gson
import java.io.Serializable

interface JsonConvertible : Serializable {
    fun toJson(): String = Gson().toJson(this)
}

inline fun <reified T : JsonConvertible> String.toObject(): T =
    Gson().fromJson(this, T::class.java)