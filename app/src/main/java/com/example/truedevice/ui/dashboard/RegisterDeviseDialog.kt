package com.example.truedevice.ui.dashboard

import android.content.Context
import android.content.Context.TELEPHONY_SERVICE
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.telephony.TelephonyManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.DialogFragment
import com.example.truedevice.databinding.RegisterDeviceDialogBinding
import java.util.jar.Manifest


class RegisterDeviseDialog (mContext: Context) :DialogFragment() {
    private lateinit var binding: RegisterDeviceDialogBinding
    private val REQUEST_ID = 100
    val tm = mContext.getSystemService(TELEPHONY_SERVICE) as TelephonyManager
    private var permissions = arrayOf(android.Manifest.permission.READ_PHONE_STATE)
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        dialog?.setCanceledOnTouchOutside(false)
        binding = RegisterDeviceDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (ActivityCompat.checkSelfPermission(requireContext(), android.Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED) {
            if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M)
            {
            binding.imeiNumber.text = tm.imei
            binding.serialNumber.text = Build.getSerial()
            binding.phoneModel.text = Build.MODEL.toString()
            }else{
                binding.serialNumber.text = Build.SERIAL
            }
        } else {
            ActivityCompat.requestPermissions(requireActivity(), permissions, REQUEST_ID)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_ID && grantResults.isNotEmpty()){
            for (i in grantResults.indices){
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED){
                    if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.M) {
                        binding.imeiNumber.text = tm.imei
                        binding.serialNumber.text = Build.getSerial()
                        binding.phoneModel.text = Build.MODEL.toString()
                    }else{
                        binding.serialNumber.text = Build.SERIAL
                    }
                }
            }
        }

    }

}