package com.ono.ledger.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.ono.ledger.R
import com.ono.ledger.ui.login.LoginActivity

class MainActivity : AppCompatActivity() {

    private lateinit var handler: Handler
    private lateinit var runnable: Runnable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        setContentView(R.layout.activity_main)


        handler = Handler(Looper.getMainLooper())
        runnable = Runnable {
            changeActivity()
        }

        handler.postDelayed(runnable, 3000)

    }

    private fun getDataFromRepository() {

    }

    private fun changeActivity() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}