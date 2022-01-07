package com.yupi.nearlabsapp.datasource

import com.yupi.nearlabsapp.models.Contact

interface AppDataSource {
    suspend fun getContacts(): Array<Contact>
}