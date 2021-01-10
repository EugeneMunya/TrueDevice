package com.example.truedevice.ui.auth

import android.os.Bundle
import android.util.Log
import android.util.Log.DEBUG
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.core.graphics.alpha
import androidx.fragment.app.Fragment
import com.example.truedevice.R
import com.example.truedevice.databinding.FragmentRegistrationBinding
import com.hbb20.CountryCodePicker
import java.util.logging.Logger


class RegistrationFragment : Fragment() {
    var ccp: CountryCodePicker? = null
   var editTextCarrierNumber: EditText? = null
    lateinit var binding:FragmentRegistrationBinding
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        ccp = binding.ccp.findViewById(R.id.ccp) as CountryCodePicker
        editTextCarrierNumber= binding.editTextCarrierNumber.findViewById(R.id.editText_carrierNumber) as EditText
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.signupBtn.setOnClickListener {
            ccp?.registerCarrierNumberEditText(editTextCarrierNumber)
            if (ccp?.isValidFullNumber() == true){
                Toast.makeText(requireContext(), ccp?.fullNumberWithPlus.toString(), Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(requireContext(), "Your number is not valid", Toast.LENGTH_SHORT).show()
            }

        }

    }


}