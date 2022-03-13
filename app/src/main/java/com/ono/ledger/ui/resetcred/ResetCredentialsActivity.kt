package com.ono.ledger.ui.resetcred

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.ono.ledger.R

class ResetCredentialsActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var etResetField: EditText
    private lateinit var btnResetField: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_credentials)

        initComponents()
        initListeners()
    }

    private fun initComponents() {
        btnResetField = findViewById(R.id.btn_reset_credential)
        etResetField = findViewById(R.id.et_reset_field)

        retrieveBundleData()
    }

    private fun initListeners() {
        btnResetField.setOnClickListener(this)
    }

    private fun retrieveBundleData() {
        val bundle = intent.extras
        bundle?.let {
            when (it.getString("field")) {
                "username" -> etResetField.hint = "UserName"
                "password" -> etResetField.hint = "Password"
            }
        }
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btn_reset_credential -> {

            }
        }
    }
}