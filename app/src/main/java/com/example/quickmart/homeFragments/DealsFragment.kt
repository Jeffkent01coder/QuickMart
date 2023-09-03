package com.example.quickmart.homeFragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickmart.R
import com.example.quickmart.adapters.AlcoholAdapter
import com.example.quickmart.adapters.TopDealsAdapter
import com.example.quickmart.databinding.FragmentDealsBinding
import com.example.quickmart.model.ProductData
import com.example.quickmart.subscreen.ProductDetails


class DealsFragment : Fragment(),
    TopDealsAdapter.OnDealClickListener,
    AlcoholAdapter.OnAlcoholClickListener {
    private lateinit var binding: FragmentDealsBinding

    //adapter
    private lateinit var adapter1: TopDealsAdapter
    private lateinit var adapter2: AlcoholAdapter

    //models
    private lateinit var dealArrayList: ArrayList<ProductData>
    private lateinit var alcoholArrayList: ArrayList<ProductData>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDealsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataIntialize()
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val recycler1 = binding.topDealsRecycler
        recycler1.layoutManager = layoutManager
        recycler1.setHasFixedSize(true)
        adapter1 = TopDealsAdapter(dealArrayList, this)
        recycler1.adapter = adapter1
        adapter1.notifyDataSetChanged()

    }

    private fun dataIntialize() {
        dealArrayList = arrayListOf(
            ProductData("", R.drawable.fruit, "Fruit", "1", "", "$4.6", "", "", "", ""),
            ProductData("", R.drawable.fruit, "Fruit", "1", "", "$4.6", "", "", "", ""),
            ProductData("", R.drawable.fruit, "Fruit", "1", "", "$4.6", "", "", "", ""),
            ProductData("", R.drawable.fruit, "Fruit", "1", "", "$4.6", "", "", "", ""),
            ProductData("", R.drawable.fruit, "Fruit", "1", "", "$4.6", "", "", "", ""),
            ProductData("", R.drawable.fruit, "Fruit", "1", "", "$4.6", "", "", "", ""),
            ProductData("", R.drawable.fruit, "Fruit", "1", "", "$4.6", "", "", "", ""),
            ProductData("", R.drawable.fruit, "Fruit", "1", "", "$4.6", "", "", "", ""),
        )
    }



    override fun onDealClick(product: ProductData, position: Int) {
        val intent = Intent(requireActivity(), ProductDetails::class.java)
        intent.putExtra("image", product.productImage.toString())
        intent.putExtra("name", product.productTitle)
        intent.putExtra("quantity", product.productQuantity)
        intent.putExtra("price", product.productPrice)
        startActivity(intent)
    }

    override fun onAlcoholClick(product: ProductData, position: Int) {
        val intent = Intent(requireActivity(), ProductDetails::class.java)
        intent.putExtra("image", product.productImage.toString())
        intent.putExtra("name", product.productTitle)
        intent.putExtra("quantity", product.productQuantity)
        intent.putExtra("price", product.productPrice)
        startActivity(intent)
    }

}