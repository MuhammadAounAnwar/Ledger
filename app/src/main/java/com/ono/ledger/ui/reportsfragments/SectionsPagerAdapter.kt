package com.ono.ledger.ui.reportsfragments

import android.app.Activity
import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.ono.ledger.R
import com.ono.ledger.ui.reportsfragments.invoice.InvoiceTransactionFragment
import com.ono.ledger.ui.reportsfragments.reports.ReportsFragment
import com.ono.ledger.ui.reportsfragments.vouchers.VouchersFragment


private val TAB_TITLES = arrayOf(
    R.string.tab_text_1,
    R.string.tab_text_2,
    R.string.tab_text_3
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, activity: Activity, fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private lateinit var activity: Activity
    override fun getItem(position: Int): Fragment {

        var fragment: Fragment? = null

        when (position) {
            0 -> {
                fragment = InvoiceTransactionFragment.newInstance()
            }
            1 -> {
                fragment = VouchersFragment.newInstance(context = context)
            }
            2 -> {
                fragment = ReportsFragment.newInstance()
            }
        }

        return fragment!!
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        // Show 3 total pages.
        return 3
    }
}