package com.ono.ledger.ui.reportsfragments.invoice

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.ono.ledger.repo.Repository

class InvoiceTransactionViewModel : ViewModel {

    private var invoiceOptionList = MutableLiveData<List<String>>()

    constructor() {
        setInvoiceOptionsList(Repository.getInvoicesOptions())
    }

    fun getInvoiceOptionsList(): LiveData<List<String>> {
        return invoiceOptionList
    }

    fun setInvoiceOptionsList(invoiceList: List<String>) {
        invoiceOptionList.value = invoiceList
    }

}