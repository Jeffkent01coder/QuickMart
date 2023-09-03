package com.example.quickmart.homeFragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.quickmart.databinding.FragmentFindBinding
import com.example.quickmart.screens.QRCode
import com.example.quickmart.subscreen.CookingIngredients
import com.example.quickmart.subscreen.FreshFood
import com.example.quickmart.subscreen.FruitsVegetables

class FindFragment : Fragment() {
    private lateinit var binding: FragmentFindBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFindBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fruitAndVegetables.setOnClickListener {
            val intent = Intent(requireActivity(), FruitsVegetables::class.java)
            startActivity(intent)
        }
//        binding.freshFood.setOnClickListener {
//            val intent = Intent(requireActivity(), FrozenFood::class.java)
//            startActivity(intent)
//        }
        binding.freshFood.setOnClickListener {
            val intent = Intent(requireActivity(), FreshFood::class.java)
            startActivity(intent)
        }
        binding.cookingIngredients.setOnClickListener {
            val intent = Intent(requireActivity(), CookingIngredients::class.java)
            startActivity(intent)
        }
    }


}