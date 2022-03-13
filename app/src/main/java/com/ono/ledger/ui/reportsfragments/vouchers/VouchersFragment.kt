package com.ono.ledger.ui.reportsfragments.vouchers

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.lifecycle.Observer
import com.ono.ledger.R
import com.ono.ledger.ui.reportsfragments.reports.ReportsFragment

class VouchersFragment : Fragment() {

    companion object {
        private var vouchersFragment: VouchersFragment? = null

        fun newInstance(): VouchersFragment {
            vouchersFragment ?: synchronized(this) {
                vouchersFragment = VouchersFragment()
            }
            return vouchersFragment!!
        }
    }

    private lateinit var viewModel: VouchersViewModel
    private lateinit var lv_vouchers: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[VouchersViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.vouchers_fragment, container, false)
        lv_vouchers = root.findViewById(R.id.lv_vouchers)
        viewModel.getVouchersOptionsList().observe(viewLifecycleOwner, Observer {
            initializeList(it)
        })
        return root
    }

    private fun initializeList(invoiceList: List<String>) {
        val arrayAdapter = ArrayAdapter(requireActivity(), android.R.layout.simple_list_item_1, invoiceList)
        lv_vouchers.adapter = arrayAdapter

        lv_vouchers.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, position, id ->
            val selectedItem = adapterView.getItemAtPosition(position) as String
            val itemIdAtPos = adapterView.getItemIdAtPosition(position)

        }
    }

}