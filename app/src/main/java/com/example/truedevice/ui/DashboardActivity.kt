package com.example.truedevice.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.truedevice.R
import com.example.truedevice.ui.dashboard.RegisterDeviseDialog

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
       val dialog = RegisterDeviseDialog(this)
       dialog.show(supportFragmentManager,"register dialog")

    }
}