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

class CustomDialog(context: Context) : Dialog(context), View.OnClickListener {

    private var dialogType: Int = 0
    private lateinit var activity: Activity

    private lateinit var et_alr_customer_code: EditText
    private lateinit var et_alr_from: EditText
    private lateinit var et_alr_to: EditText

    private lateinit var img_alr_from_cal: ImageView
    private lateinit var img_alr_to_cal: ImageView

    private lateinit var btn_view: Button
    private lateinit var btn_close: Button

    constructor(context: Context, activity: Activity, dialogType: Int) : this(context) {
        this.activity = activity
        this.dialogType = dialogType
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        requestWindowFeature(Window.FEATURE_NO_TITLE)

        if (dialogType == 0) {
            setContentView(R.layout.account_ledger_report)
        } else {
            setContentView(R.layout.cash_book)
        }

        initComponents()
        initListeners()

    }

    private fun initComponents() {
        et_alr_customer_code = findViewById(R.id.et_alr_customer_code)
        et_alr_from = findViewById(R.id.et_alr_from)
        et_alr_to = findViewById(R.id.et_alr_to)
        img_alr_from_cal = findViewById(R.id.img_alr_from_cal)
        img_alr_to_cal = findViewById(R.id.img_alr_to_cal)

        btn_view = findViewById(R.id.btn_view)
        btn_close = findViewById(R.id.btn_close)
    }

    private fun initListeners() {
        img_alr_from_cal.setOnClickListener(this)
        img_alr_to_cal.setOnClickListener(this)
        btn_view.setOnClickListener(this)
        btn_close.setOnClickListener(this)
    }


    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.img_alr_from_cal -> UtilityClass.openCalenderDialog(activity, et_alr_from)
            R.id.img_alr_to_cal -> UtilityClass.openCalenderDialog(activity, et_alr_to)
            R.id.btn_view -> UtilityClass.openCalenderDialog(activity, et_alr_to)
            R.id.btn_close -> UtilityClass.openCalenderDialog(activity, et_alr_to)
        }
    }
}