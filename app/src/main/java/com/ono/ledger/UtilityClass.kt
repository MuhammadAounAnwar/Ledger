package com.ono.ledger

import android.annotation.SuppressLint
import android.app.Activity
import android.app.DatePickerDialog
import android.content.Context
import android.view.Window
import android.widget.EditText
import android.widget.LinearLayout
import com.ono.ledger.dialogs.CustomDialog
import com.ono.ledger.enums.DialogType
import com.ono.ledger.interfaces.IDialogClickListeners
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

    private lateinit var customDialog: CustomDialog
    fun openCustomDialogBox(context: Context, activity: Activity, dialogType: DialogType) {
        customDialog = CustomDialog(context, activity, dialogType, iDialogClickListeners = iDialogClickListeners)
//        customDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        customDialog.show()
        val window: Window = customDialog.window!!
        window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
    }


    private val iDialogClickListeners = object : IDialogClickListeners {
        override fun closeButtonClicked() {
            customDialog.dismiss()
        }

        override fun viewButtonClicked() {

        }

    }

}