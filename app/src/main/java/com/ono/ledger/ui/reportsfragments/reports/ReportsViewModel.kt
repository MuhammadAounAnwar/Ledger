package com.ono.ledger.ui.reportsfragments.reports

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ono.ledger.repo.Repository

class ReportsViewModel : ViewModel {
    private var reportsHashMap = MutableLiveData<HashMap<String, List<String>>>()

    constructor() {
        setReportsHashMap(Repository.getReportsOptions())
    }

    fun getReportsHashMap(): LiveData<HashMap<String, List<String>>> {
        return reportsHashMap
    }

    private fun setReportsHashMap(reportsHashMap: HashMap<String, List<String>>) {
        this.reportsHashMap.value = reportsHashMap
    }

}