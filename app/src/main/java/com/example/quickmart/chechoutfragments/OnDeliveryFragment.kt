package com.example.quickmart.chechoutfragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.quickmart.R
import com.example.quickmart.confim.ConfirmDelivery
import com.example.quickmart.databinding.FragmentOnDeliveryBinding

class OnDeliveryFragment : Fragment() {

    private lateinit var binding: FragmentOnDeliveryBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnDeliveryBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnConfirm.setOnClickListener {
            val intent = Intent(requireActivity(), ConfirmDelivery::class.java)
            startActivity(intent)
        }
    }
}