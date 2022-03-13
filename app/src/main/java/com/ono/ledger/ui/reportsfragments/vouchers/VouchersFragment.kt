package com.ono.ledger.ui.reportsfragments.vouchers

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ono.ledger.R
import com.ono.ledger.UtilityClass
import com.ono.ledger.enums.DialogType

class VouchersFragment private constructor() : Fragment() {

    private lateinit var fragmentContext: Context
    private lateinit var activity: Activity

    private constructor(context: Context) : this() {
        this.fragmentContext = context
    }

    private constructor(context: Context, activity: Activity) : this() {
        this.fragmentContext = context
        this.activity = activity
    }

    companion object {
        private var vouchersFragment: VouchersFragment? = null

        fun newInstance(context: Context): VouchersFragment {
            vouchersFragment ?: synchronized(this) {
                vouchersFragment = VouchersFragment(context)
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

            UtilityClass.openCustomDialogBox(fragmentContext, requireActivity(), DialogType.VOUCHER_PRINTING)

        }
    }

}