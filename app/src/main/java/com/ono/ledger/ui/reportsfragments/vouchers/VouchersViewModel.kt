package com.ono.ledger.ui.reportsfragments.vouchers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ono.ledger.repo.Repository

class VouchersViewModel : ViewModel {
    private var vouchersList = MutableLiveData<List<String>>()

    constructor() {
        setVouchersOptionsList(Repository.getVouchersOptions())
    }

    fun getVouchersOptionsList(): LiveData<List<String>> {
        return vouchersList
    }

    fun setVouchersOptionsList(invoiceList: List<String>) {
        vouchersList.value = invoiceList
    }
}