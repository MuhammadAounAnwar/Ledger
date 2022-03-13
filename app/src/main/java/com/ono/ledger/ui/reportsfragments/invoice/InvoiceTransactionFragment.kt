package com.ono.ledger.ui.reportsfragments.invoice

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ono.ledger.R

class InvoiceTransactionFragment : Fragment() {

    private lateinit var invoiceTransactionViewModel: InvoiceTransactionViewModel
    private lateinit var lv_invoice: ListView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        invoiceTransactionViewModel = ViewModelProvider(this)[InvoiceTransactionViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_invoice, container, false)
        lv_invoice = root.findViewById(R.id.lv_invoice)
        invoiceTransactionViewModel.getInvoiceOptionsList().observe(viewLifecycleOwner, Observer {
            initializeList(it)
        })

        return root
    }

    private fun initializeList(invoiceList: List<String>) {
        val arrayAdapter = ArrayAdapter(requireActivity(), android.R.layout.simple_list_item_1, invoiceList)
        lv_invoice.adapter = arrayAdapter

        lv_invoice.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, position, id ->
            val selectedItem = adapterView.getItemAtPosition(position) as String
            val itemIdAtPos = adapterView.getItemIdAtPosition(position)

        }
    }


    companion object {
        @SuppressLint("StaticFieldLeak")
        private var invoiceTransactionFragment: InvoiceTransactionFragment? = null

        fun newInstance(): InvoiceTransactionFragment {
            invoiceTransactionFragment ?: synchronized(this) {
                invoiceTransactionFragment = InvoiceTransactionFragment()
            }
            return invoiceTransactionFragment!!
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}