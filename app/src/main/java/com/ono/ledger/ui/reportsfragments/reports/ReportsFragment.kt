package com.ono.ledger.ui.reportsfragments.reports

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListAdapter
import android.widget.ExpandableListView
import android.widget.ExpandableListView.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ono.ledger.CustomExpandableListAdapter
import com.ono.ledger.R


class ReportsFragment : Fragment() {

    companion object {
        @SuppressLint("StaticFieldLeak")
        private var reportsFragment: ReportsFragment? = null

        fun newInstance(): ReportsFragment {
            reportsFragment ?: synchronized(this) {
                reportsFragment = ReportsFragment()
            }
            return reportsFragment!!
        }
    }

    private lateinit var viewModel: ReportsViewModel

    var expandableListView: ExpandableListView? = null
    var expandableListAdapter: ExpandableListAdapter? = null
    var expandableListTitle: List<String>? = null
    var expandableListDetail: HashMap<String, List<String>>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[ReportsViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.reports_fragment, container, false)
        expandableListView = view.findViewById(R.id.expandableListView)

        viewModel.getReportsHashMap().observe(viewLifecycleOwner, Observer {
            setAdapter(it)
        })



        return view
    }

    private fun setAdapter(reportsHashMap: HashMap<String, List<String>>) {
        expandableListTitle = ArrayList(reportsHashMap.keys)
        expandableListAdapter = CustomExpandableListAdapter(requireActivity(), expandableListTitle, reportsHashMap)
        expandableListView!!.setAdapter(expandableListAdapter)


        expandableListView!!.setOnGroupExpandListener(OnGroupExpandListener { groupPosition ->
//            Toast.makeText(
//                activity, expandableListTitle!![groupPosition] + " List Expanded.",
//                Toast.LENGTH_SHORT
//            ).show()
        })

        expandableListView!!.setOnGroupCollapseListener(OnGroupCollapseListener { groupPosition ->
//            Toast.makeText(
//                activity, expandableListTitle!![groupPosition] + " List Collapsed.",
//                Toast.LENGTH_SHORT
//            ).show()
        })

        expandableListView!!.setOnChildClickListener(OnChildClickListener { parent, v, groupPosition, childPosition, id ->
//            Toast.makeText(
//                activity,
//                expandableListTitle!![groupPosition] + " -> "
//                        + expandableListDetail!![expandableListTitle!![groupPosition]]!![childPosition], Toast.LENGTH_SHORT
//            ).show()
            false
        })
    }


}