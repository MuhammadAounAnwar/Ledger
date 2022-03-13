package com.ono.ledger.ui.resetcred

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.ono.ledger.R
import com.ono.ledger.ui.ReportsActivity

class ResetCredentialsOptionsActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnResetEmail: Button
    private lateinit var btnResetPassword: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_credentials_options)


        initComponents()
        initListeners()
    }

    private fun initComponents() {
        btnResetEmail = findViewById(R.id.btn_forgot_email)
        btnResetPassword = findViewById(R.id.btn_forgot_password)
    }

    private fun initListeners() {
        btnResetEmail.setOnClickListener(this)
        btnResetPassword.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btn_forgot_email -> {
                changeActivity(false)
            }
            R.id.btn_forgot_password -> {
                changeActivity(true)
            }
        }
    }

    private fun changeActivity(isPasswordChanged: Boolean) {
        var bundle = Bundle()
        if (isPasswordChanged) bundle.putString("field", "password") else bundle.putString("field", "username")
        val intent = Intent(this, ResetCredentialsActivity::class.java)
        intent.putExtra("Name", bundle)
        startActivity(intent)
    }

}