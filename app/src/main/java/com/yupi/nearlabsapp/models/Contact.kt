package com.yupi.nearlabsapp.models

import com.yupi.nearlabsapp.util.JsonConvertible

data class Contact(
    val contactName: String?,
    val contactId: String?,
    val contactAvatar: Int?,
    var isChecked: Boolean = false
): JsonConvertible
