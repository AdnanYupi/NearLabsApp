package com.yupi.nearlabsapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.yupi.nearlabsapp.datasource.AppDataSource
import com.yupi.nearlabsapp.enums.OnBoardingEnum
import com.yupi.nearlabsapp.models.Contact
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(private val appDataSource: AppDataSource) : BaseViewModel() {

    var userInput: String? = ""
    var isPhoneEntered: Boolean = true
    var screenTitle: String? = ""

    private val nextScreenMutableLiveData: MutableLiveData<OnBoardingEnum> = MutableLiveData()
    val goNextScreen: LiveData<OnBoardingEnum>
    get() = nextScreenMutableLiveData

    fun initFirstScreen() {
        nextScreenMutableLiveData.postValue(OnBoardingEnum.VERIFICATION)
    }

    fun nextScreen() {
        val screen = goNextScreen.value
        if (screen != null) {
            when(screen) {
                OnBoardingEnum.VERIFICATION -> {
                    nextScreenMutableLiveData.postValue(OnBoardingEnum.CREATE_ACCOUNT)
                }
                OnBoardingEnum.CREATE_ACCOUNT -> {
                    nextScreenMutableLiveData.postValue(OnBoardingEnum.GIFT_NFT)
                    fetchContacts()
                }
            }
        }
    }

    fun resendVerificationCode() {
    }

    private val _contactsData: MutableLiveData<Array<Contact>> = MutableLiveData()
    val contactsData: LiveData<Array<Contact>> get() = _contactsData

    //No need to expose this function
    private fun fetchContacts() {
        viewModelScope.launch(Dispatchers.IO) {
            val contactsResponse = appDataSource.getContacts()
            withContext(Dispatchers.Main) {
                _contactsData.postValue(contactsResponse)
            }
        }
    }
}