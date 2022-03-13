package com.ono.ledger

import android.annotation.SuppressLint
import android.app.Activity
import android.app.DatePickerDialog
import android.widget.EditText
import java.util.*

object UtilityClass {

    @SuppressLint("SetTextI18n")
    fun openCalenderDialog(activity: Activity, editText: EditText) {
        val cal: Calendar = Calendar.getInstance()
        val year = cal.get(Calendar.YEAR)
        val month = cal.get(Calendar.MONTH)
        val day = cal.get(Calendar.DAY_OF_MONTH)

        val dpd = DatePickerDialog(activity, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            // Display Selected date in textbox
            editText.setText("$dayOfMonth/$monthOfYear/$year")
        }, year, month, day)
        dpd.show()
    }

}