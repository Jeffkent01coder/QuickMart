package com.example.quickmart.chechoutfragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.quickmart.R
import com.example.quickmart.confim.ConfirmMpesa
import com.example.quickmart.databinding.FragmentMpesaBinding
import com.example.quickmart.screens.Home

class MpesaFragment : Fragment() {
    private lateinit var binding: FragmentMpesaBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMpesaBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnConfirm.setOnClickListener {
            val intent = Intent(requireActivity(), ConfirmMpesa::class.java)
            startActivity(intent)
        }

        binding.fail.setOnClickListener {
            val intent = Intent(requireActivity(), Home::class.java)
            startActivity(intent)
        }
    }

}