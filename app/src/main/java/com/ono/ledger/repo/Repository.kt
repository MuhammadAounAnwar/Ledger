package com.ono.ledger.repo

object Repository {
    private val invoicesList = arrayListOf<String>(
        "Sale Invoice",
        "Sale Return Invoice",
        "Purchase Invoice",
        "Purchase Return Invoice",
        "Transfer In Invoice",
        "Transfer Out Invoice"
    )

    private val vouchersList = arrayListOf<String>("Cash Receipt Vouchers", "Cash Payment Vouchers")

    private val reportsParentList = arrayListOf<String>(
        "Account Ledger Reports",
        "Vouchers Reports Date wise",
        "Daily Report",
        "Custom Sales Report",
        "Sale Brick Reports",
        "Stock and Sales Report",
        "Custom Sales Report II",
        "Transaction Summary (Date Range Specific)",
        "Miscellaneous Report",
    )

    private val accountLedgerReportsOptions = arrayListOf<String>(
        "Account Ledger Book",
        "Cash Book"
    )
    private val vouchersReportsDateWiseOptions = arrayListOf<String>(
        "Receipt Vouchers",
        "Payment Vouchers"
    )

    private val dailyReportReportOptions = arrayListOf<String>(
        "Supply Ledger Date Wise or Invoice Wise",
        "Return Supply Ledger Date Wise or Invoice Wise"
    )
    private val customSalesReportOptions = arrayListOf<String>(
        "Net Sale Wise Vendor Wise",
        "Net Sale Return Vendor Party Wise"
    )
    private val saleBrickReportsOptions = arrayListOf<String>(
        "Sale Brick Report Party Month Wise",
        "Sale Brick Report Vendor Group Party Wise"
    )
    private val stockAndSalesReportOptions = arrayListOf<String>(
        "Stock and Sales Reports (DP)",
        "Stock and Sales Reports (TP)",
        "Stock and Sales Reports (TP) With Bonus",
        "Stock and Sales Reports (TP) With Return"
    )

    private val customSalesReportIIOptions = arrayListOf<String>(
        "Balance Transaction Report (BTR)"
    )

    private val transSummaryChildren = arrayListOf<String>(
        "Sale Invoice",
        "Sale Return Invoice",
        "Purchase Invoice",
        "Purchase Return Invoice",
        "Transfer In",
        "Transfer Out"
    )
    private val miscReportsChildren = arrayListOf<String>(
        "Product List Vendor Wise", "Customer List", "Vendor List", "Sale Reps. List", "Salesman List"
    )

    public fun getInvoicesOptions(): List<String> {
        return invoicesList
    }

    public fun getVouchersOptions(): List<String> {
        return vouchersList
    }

    public fun getReportsTitles(): List<String> {
        return reportsParentList
    }

    public fun getReportsOptionsList(): List<List<String>> {
        return arrayListOf()
    }

    public fun getReportsOptions(): HashMap<String, List<String>> {

        val hashMap = HashMap<String, List<String>>()
        hashMap[reportsParentList[0]] = accountLedgerReportsOptions
        hashMap[reportsParentList[1]] = vouchersReportsDateWiseOptions
        hashMap[reportsParentList[2]] = dailyReportReportOptions
        hashMap[reportsParentList[3]] = customSalesReportOptions
        hashMap[reportsParentList[4]] = saleBrickReportsOptions
        hashMap[reportsParentList[5]] = stockAndSalesReportOptions
        hashMap[reportsParentList[6]] = customSalesReportIIOptions
        hashMap[reportsParentList[7]] = transSummaryChildren
        hashMap[reportsParentList[8]] = miscReportsChildren

        return hashMap
    }
}