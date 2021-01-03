package com.example.truedevice.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.truedevice.R

class RegisterDeviseDialog :DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dialog?.setCanceledOnTouchOutside(false)
        return inflater.inflate(R.layout.register_device_dialog,container,false)
    }
}