package com.ono.ledger.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.ono.ledger.R
import com.ono.ledger.dialogs.CustomDialog
import com.ono.ledger.ui.ReportsActivity
import com.ono.ledger.ui.resetcred.ResetCredentialsOptionsActivity

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var et_username: EditText
    private lateinit var et_password: EditText
    private lateinit var btn_login: Button
    private lateinit var tv_forgot_credentials: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initComponents()
        initListeners()
    }

    private fun initComponents() {
        et_username = findViewById(R.id.et_username)
        et_password = findViewById(R.id.et_password)
        btn_login = findViewById(R.id.btn_login)
        tv_forgot_credentials = findViewById(R.id.tv_forgot_credentials)
    }

    private fun initListeners() {
        btn_login.setOnClickListener(this)
        tv_forgot_credentials.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btn_login -> {
//                changeActivity()
                openCustomDialogBox()
            }
            R.id.tv_forgot_credentials -> {
                val intent = Intent(this, ResetCredentialsOptionsActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun changeActivity() {
        val intent = Intent(this, ReportsActivity::class.java)
        startActivity(intent)
    }

    private fun openCustomDialogBox() {
        val customDialog = CustomDialog(this, this, 0)
//        customDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        customDialog.show()
        val window: Window = customDialog.window!!
        window.setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
    }


}