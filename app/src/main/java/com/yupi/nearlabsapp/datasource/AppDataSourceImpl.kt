package com.yupi.nearlabsapp.datasource

import com.yupi.nearlabsapp.models.Contact

class AppDataSourceImpl : AppDataSource {

    override suspend fun getContacts(): Array<Contact> {
        val contacts = mutableListOf<Contact>()
        var contact = Contact("Darlene Robertson", "@darlene", null)
        contacts.add(contact)
        contact = Contact("Darlene Robertson", "@darlene", null)
        contacts.add(contact)
        contact = Contact("Jacob Jones", "@jacob", null)
        contacts.add(contact)
        contact = Contact("Jenny Wilson", "@jenny", null)
        contacts.add(contact)
        contact = Contact("Ronald Richards", "@ronald", null)
        contacts.add(contact)
        contact = Contact("Cameron Williams", "@cameron", null)
        contacts.add(contact)
        contact = Contact("Darrel Steward", "@darrel", null)
        contacts.add(contact)
        contact = Contact("Wade Warren", "@wade", null)
        contacts.add(contact)

        return contacts.toTypedArray()
    }
}