package com.example.quickmart.homeFragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quickmart.R
import com.example.quickmart.adapters.DetergentAdapter
import com.example.quickmart.adapters.ElectronicAdapter
import com.example.quickmart.adapters.PromotionAdapter
import com.example.quickmart.adapters.SnackAdapter
import com.example.quickmart.databinding.FragmentHomeBinding
import com.example.quickmart.model.ProductData
import com.example.quickmart.screens.QRCode
import com.example.quickmart.subscreen.ProductDetails

class HomeFragment : Fragment(),
    PromotionAdapter.OnPromoClickListener,
    ElectronicAdapter.OnElectronicClickListener,
    DetergentAdapter.OnDetergentClickListener,
    SnackAdapter.OnSnackClickListener {
    private lateinit var binding: FragmentHomeBinding

    //adapter
    private lateinit var adapter1: PromotionAdapter
    private lateinit var adapter2: ElectronicAdapter
    private lateinit var adapter3: DetergentAdapter
    private lateinit var adapter4: SnackAdapter

    //models
    private lateinit var promoArrayList: ArrayList<ProductData>
    private lateinit var electronicArrayList: ArrayList<ProductData>
    private lateinit var detergentArrayList: ArrayList<ProductData>
    private lateinit var snackArrayList: ArrayList<ProductData>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.scanner.setOnClickListener {
            val intent = Intent(requireActivity(), QRCode::class.java)
            startActivity(intent)
        }

        dataIntialize()
        val layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val recycler1 = binding.promotionRecycler
        recycler1.layoutManager = layoutManager
        recycler1.setHasFixedSize(true)
        adapter1 = PromotionAdapter(promoArrayList, this)
        recycler1.adapter = adapter1
        adapter1.notifyDataSetChanged()

        dataIntialize2()
        val layoutManager2 = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val recycler2 = binding.electronicRecycler
        recycler2.layoutManager = layoutManager2
        recycler2.setHasFixedSize(true)
        adapter2 = ElectronicAdapter(electronicArrayList, this)
        recycler2.adapter = adapter2
        adapter2.notifyDataSetChanged()

        dataIntialize3()
        val layoutManager3 = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val recycler3 = binding.detergentRecycler
        recycler3.layoutManager = layoutManager3
        recycler3.setHasFixedSize(true)
        adapter3 = DetergentAdapter(detergentArrayList, this)
        recycler3.adapter = adapter3
        adapter3.notifyDataSetChanged()

        dataIntialize4()
        val layoutManager4 = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val recycler4 = binding.snackRecycler
        recycler4.layoutManager = layoutManager4
        recycler4.setHasFixedSize(true)
        adapter4 = SnackAdapter(snackArrayList, this)
        recycler4.adapter = adapter4
        adapter4.notifyDataSetChanged()

    }

    private fun dataIntialize() {
        promoArrayList = arrayListOf(
            ProductData("", R.drawable.fruit, "Fruit", "", "", "", "", "", "", "Up to 30% off"),
            ProductData("", R.drawable.fruit, "Fruit", "", "", "", "", "", "", "Up to 30% off"),
            ProductData("", R.drawable.fruit, "Fruit", "", "", "", "", "", "", "Up to 30% off"),
            ProductData("", R.drawable.fruit, "Fruit", "", "", "", "", "", "", "Up to 30% off"),
            ProductData("", R.drawable.fruit, "Fruit", "", "", "", "", "", "", "Up to 30% off"),
            ProductData("", R.drawable.fruit, "Fruit", "", "", "", "", "", "", "Up to 30% off"),
            ProductData("", R.drawable.fruit, "Fruit", "", "", "", "", "", "", "Up to 30% off"),
            ProductData("", R.drawable.fruit, "Fruit", "", "", "", "", "", "", "Up to 30% off"),
        )
    }

    private fun dataIntialize2() {
        electronicArrayList = arrayListOf(
            ProductData("", R.drawable.microwave, "microwave", "1", "", "$4.6", "", "", "", ""),
            ProductData("", R.drawable.microwave, "microwave", "1", "", "$4.6", "", "", "", ""),
            ProductData("", R.drawable.microwave, "microwave", "1", "", "$4.6", "", "", "", ""),
            ProductData("", R.drawable.microwave, "microwave", "1", "", "$4.6", "", "", "", ""),
            ProductData("", R.drawable.microwave, "microwave", "1", "", "$4.6", "", "", "", ""),
            ProductData("", R.drawable.microwave, "microwave", "1", "", "$4.6", "", "", "", ""),
            ProductData("", R.drawable.microwave, "microwave", "1", "", "$4.6", "", "", "", ""),
            ProductData("", R.drawable.microwave, "microwave", "1", "", "$4.6", "", "", "", ""),
        )
    }


    private fun dataIntialize3() {
        detergentArrayList = arrayListOf(
            ProductData(
                "",
                R.drawable.detergents,
                "detergents",
                "1 Liter",
                "",
                "$4.6",
                "",
                "",
                "",
                ""
            ),
            ProductData(
                "",
                R.drawable.detergents,
                "detergents",
                "1 Liter",
                "",
                "$4.6",
                "",
                "",
                "",
                ""
            ),
            ProductData(
                "",
                R.drawable.detergents,
                "detergents",
                "1 Liter",
                "",
                "$4.6",
                "",
                "",
                "",
                ""
            ),
            ProductData(
                "",
                R.drawable.detergents,
                "detergents",
                "1 Liter",
                "",
                "$4.6",
                "",
                "",
                "",
                ""
            ),
            ProductData(
                "",
                R.drawable.detergents,
                "detergents",
                "1 Liter",
                "",
                "$4.6",
                "",
                "",
                "",
                ""
            ),
            ProductData(
                "",
                R.drawable.detergents,
                "detergents",
                "1 Liter",
                "",
                "$4.6",
                "",
                "",
                "",
                ""
            ),
            ProductData(
                "",
                R.drawable.detergents,
                "detergents",
                "1 Liter",
                "",
                "$4.6",
                "",
                "",
                "",
                ""
            ),
            ProductData(
                "",
                R.drawable.detergents,
                "detergents",
                "1 Liter",
                "",
                "$4.6",
                "",
                "",
                "",
                ""
            ),
        )
    }

    private fun dataIntialize4() {
        snackArrayList = arrayListOf(
            ProductData("", R.drawable.snack, "snack", "1", "", "$4.6", "", "", "", ""),
            ProductData("", R.drawable.snack, "snack", "1", "", "$4.6", "", "", "", ""),
            ProductData("", R.drawable.snack, "snack", "1", "", "$4.6", "", "", "", ""),
            ProductData("", R.drawable.snack, "snack", "1", "", "$4.6", "", "", "", ""),
            ProductData("", R.drawable.snack, "snack", "1", "", "$4.6", "", "", "", ""),
            ProductData("", R.drawable.snack, "snack", "1", "", "$4.6", "", "", "", ""),
            ProductData("", R.drawable.snack, "snack", "1", "", "$4.6", "", "", "", ""),
            ProductData("", R.drawable.snack, "snack", "1", "", "$4.6", "", "", "", ""),
        )
    }

    override fun onPromoClick(product: ProductData, position: Int) {
        val intent = Intent(requireActivity(), ProductDetails::class.java)
        intent.putExtra("image", product.productImage.toString())
        intent.putExtra("name", product.productTitle)
        intent.putExtra("quantity", product.productQuantity)
        intent.putExtra("price", product.productPrice)
        startActivity(intent)
    }

    override fun onElectronicClick(product: ProductData, position: Int) {
        val intent = Intent(requireActivity(), ProductDetails::class.java)
        intent.putExtra("image", product.productImage.toString())
        intent.putExtra("name", product.productTitle)
        intent.putExtra("quantity", product.productQuantity)
        intent.putExtra("price", product.productPrice)
        startActivity(intent)
    }

    override fun onAddClick(product: ProductData, position: Int) {
        Toast.makeText(requireActivity(),"added to cart", Toast.LENGTH_SHORT).show()
    }

    override fun onDetergentClick(product: ProductData, position: Int) {
        val intent = Intent(requireActivity(), ProductDetails::class.java)
        intent.putExtra("image", product.productImage.toString())
        intent.putExtra("name", product.productTitle)
        intent.putExtra("quantity", product.productQuantity)
        intent.putExtra("price", product.productPrice)
        startActivity(intent)
    }

    override fun onSnackClick(product: ProductData, position: Int) {
        val intent = Intent(requireActivity(), ProductDetails::class.java)
        intent.putExtra("image", product.productImage.toString())
        intent.putExtra("name", product.productTitle)
        intent.putExtra("quantity", product.productQuantity)
        intent.putExtra("price", product.productPrice)
        startActivity(intent)
    }

    override fun onAddToCartClick(product: ProductData, position: Int) {
        Toast.makeText(requireActivity(),"added", Toast.LENGTH_SHORT).show()
    }

}