package com.example.quickmart.chechoutfragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.quickmart.R
import com.example.quickmart.confim.ConfirmCard
import com.example.quickmart.databinding.FragmentCardBinding


class CardFragment : Fragment() {

    private lateinit var binding: FragmentCardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnConfirm.setOnClickListener {
            val intent = Intent(requireActivity(), ConfirmCard::class.java)
            startActivity(intent)
        }
    }


}