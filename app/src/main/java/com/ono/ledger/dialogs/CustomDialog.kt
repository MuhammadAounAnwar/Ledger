package com.ono.ledger.dialogs

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.ono.ledger.R
import com.ono.ledger.UtilityClass
import com.ono.ledger.enums.DialogType
import com.ono.ledger.interfaces.IDialogClickListeners

class CustomDialog(context: Context) : Dialog(context), View.OnClickListener {

    private lateinit var dialogType: DialogType
    private lateinit var activity: Activity

    private lateinit var et_alr_customer_code: EditText
    private lateinit var et_alr_from: EditText
    private lateinit var et_alr_to: EditText

    private lateinit var img_alr_from_cal: ImageView
    private lateinit var img_alr_to_cal: ImageView

    private lateinit var btn_view: Button
    private lateinit var btn_close: Button

    private lateinit var iDialogClickListeners: IDialogClickListeners

    constructor(context: Context, activity: Activity, dialogType: DialogType, iDialogClickListeners: IDialogClickListeners) : this(context) {
        this.activity = activity
        this.dialogType = dialogType
        this.iDialogClickListeners = iDialogClickListeners
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        requestWindowFeature(Window.FEATURE_NO_TITLE)

        when (dialogType) {
            DialogType.ACCOUNT_LEDGER_REPORT -> setContentView(R.layout.account_ledger_report)
            DialogType.CASH_BOOK -> setContentView(R.layout.cash_book)
            DialogType.VOUCHER_PRINTING -> setContentView(R.layout.voucher_printing)
            DialogType.SUPPLY_LEDGER -> setContentView(R.layout.supply_ledger)
            DialogType.RETURN_LEDGER -> setContentView(R.layout.return_ledger)
            DialogType.NET_SALE_INVOICE_VENDOR_WISE -> setContentView(R.layout.net_sale_invoice_vendor_wise)
            DialogType.NET_SALE_R_INVOICE_VENDOR_WISE -> setContentView(R.layout.net_sale_r_invoice_vendor_wise)
            DialogType.STOCK_N_SALES_REPORT -> setContentView(R.layout.stock_and_sales_report)
            DialogType.BTR -> setContentView(R.layout.b_t_r)
            DialogType.TRANSACTION_SUMMARY -> setContentView(R.layout.transactin_summary)
        }

        initComponents(dialogType = dialogType)
        initListeners(dialogType = dialogType)

    }

    private fun initComponents(dialogType: DialogType) {
        when (dialogType) {
            DialogType.ACCOUNT_LEDGER_REPORT -> {
                et_alr_customer_code = findViewById(R.id.et_alr_customer_code)
                et_alr_from = findViewById(R.id.et_alr_from)
                et_alr_to = findViewById(R.id.et_alr_to)
                img_alr_from_cal = findViewById(R.id.img_alr_from_cal)
                img_alr_to_cal = findViewById(R.id.img_alr_to_cal)
            }
            DialogType.CASH_BOOK -> {
                et_alr_from = findViewById(R.id.et_alr_from)
                et_alr_to = findViewById(R.id.et_alr_to)
                img_alr_from_cal = findViewById(R.id.img_alr_from_cal)
                img_alr_to_cal = findViewById(R.id.img_alr_to_cal)
            }
            DialogType.VOUCHER_PRINTING -> {//radio group and buttons are missing
                et_alr_from = findViewById(R.id.et_alr_from)
                et_alr_to = findViewById(R.id.et_alr_to)
                img_alr_from_cal = findViewById(R.id.img_alr_from_cal)
                img_alr_to_cal = findViewById(R.id.img_alr_to_cal)
            }
            DialogType.SUPPLY_LEDGER -> {}//custom fields
            DialogType.RETURN_LEDGER -> {
                et_alr_from = findViewById(R.id.et_alr_from)
                et_alr_to = findViewById(R.id.et_alr_to)
                img_alr_from_cal = findViewById(R.id.img_alr_from_cal)
                img_alr_to_cal = findViewById(R.id.img_alr_to_cal)
            }
            DialogType.NET_SALE_INVOICE_VENDOR_WISE -> {//spinners and hint
                et_alr_customer_code = findViewById(R.id.et_alr_customer_code)
                et_alr_from = findViewById(R.id.et_alr_from)
                et_alr_to = findViewById(R.id.et_alr_to)
                img_alr_from_cal = findViewById(R.id.img_alr_from_cal)
                img_alr_to_cal = findViewById(R.id.img_alr_to_cal)
            }
            DialogType.NET_SALE_R_INVOICE_VENDOR_WISE -> {//spinners and hint
                et_alr_customer_code = findViewById(R.id.et_alr_customer_code)
                et_alr_from = findViewById(R.id.et_alr_from)
                et_alr_to = findViewById(R.id.et_alr_to)
                img_alr_from_cal = findViewById(R.id.img_alr_from_cal)
                img_alr_to_cal = findViewById(R.id.img_alr_to_cal)
            }
            DialogType.STOCK_N_SALES_REPORT -> {//spinners and hint
                et_alr_customer_code = findViewById(R.id.et_alr_customer_code)
                et_alr_from = findViewById(R.id.et_alr_from)
                et_alr_to = findViewById(R.id.et_alr_to)
                img_alr_from_cal = findViewById(R.id.img_alr_from_cal)
                img_alr_to_cal = findViewById(R.id.img_alr_to_cal)
            }
            DialogType.BTR -> {//spinner
                et_alr_customer_code = findViewById(R.id.et_alr_customer_code)
                et_alr_from = findViewById(R.id.et_alr_from)
                et_alr_to = findViewById(R.id.et_alr_to)
                img_alr_from_cal = findViewById(R.id.img_alr_from_cal)
                img_alr_to_cal = findViewById(R.id.img_alr_to_cal)
            }
            DialogType.TRANSACTION_SUMMARY -> {
                et_alr_customer_code = findViewById(R.id.et_alr_customer_code)
                et_alr_from = findViewById(R.id.et_alr_from)
                et_alr_to = findViewById(R.id.et_alr_to)
                img_alr_from_cal = findViewById(R.id.img_alr_from_cal)
                img_alr_to_cal = findViewById(R.id.img_alr_to_cal)
            }
        }

        btn_view = findViewById(R.id.btn_view)
        btn_close = findViewById(R.id.btn_close)
    }

    private fun initListeners(dialogType: DialogType) {
        if (dialogType != DialogType.SUPPLY_LEDGER) {
            img_alr_from_cal.setOnClickListener(this)
            img_alr_to_cal.setOnClickListener(this)
        }

        btn_view.setOnClickListener(this)
        btn_close.setOnClickListener(this)
    }


    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.img_alr_from_cal -> UtilityClass.openCalenderDialog(activity, et_alr_from)
            R.id.img_alr_to_cal -> UtilityClass.openCalenderDialog(activity, et_alr_to)
            R.id.btn_view -> iDialogClickListeners.viewButtonClicked()
            R.id.btn_close -> iDialogClickListeners.closeButtonClicked()
        }
    }
}