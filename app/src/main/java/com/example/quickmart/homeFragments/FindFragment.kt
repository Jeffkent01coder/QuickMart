package com.example.quickmart.homeFragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quickmart.R
import com.example.quickmart.adapters.CategoryAdapter
import com.example.quickmart.databinding.FragmentFindBinding
import com.example.quickmart.model.ProductData

class FindFragment : Fragment(), CategoryAdapter.OnCategoryClickListener {
    private lateinit var binding: FragmentFindBinding

    private lateinit var adapter: CategoryAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var categoryArrayList: ArrayList<ProductData>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFindBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataInitialize()
        val layoutManager = GridLayoutManager(context, 2)
        recyclerView = view.findViewById(R.id.productsRecyclerView)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = CategoryAdapter(categoryArrayList, this)
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()


    }

    override fun onCategoryClick(category: ProductData, position: Int) {
        Toast.makeText(requireActivity(), "this", Toast.LENGTH_SHORT).show()
    }

    private fun dataInitialize() {
        categoryArrayList = arrayListOf(
            ProductData(
                "",
                null,
                "",
                "",
                "",
                "",
                "Snacks",
                "",
                "",
                "",
                R.drawable.snack
            ),
            ProductData(
                "",
                null,
                "",
                "",
                "",
                "",
                "Fruits",
                "",
                "",
                "",
                R.drawable.apple
            ),
            ProductData(
                "",
                null,
                "",
                "",
                "",
                "",
                "Fruits and Vegetables",
                "",
                "",
                "",
                R.drawable.bana
            ),
            ProductData(
                "",
                null,
                "",
                "",
                "",
                "",
                "Meat",
                "",
                "",
                "",
                R.drawable.fresh
            ),
            ProductData(
                "",
                null,
                "",
                "",
                "",
                "",
                "Oil and Fats",
                "",
                "",
                "",
                R.drawable.oil
            ),
            ProductData(
                "",
                null,
                "",
                "",
                "",
                "",
                "Electronics",
                "",
                "",
                "",
                R.drawable.microwave
            ),
            ProductData(
                "",
                null,
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "Grocery",
                R.drawable.onion
            ),
        )


    }


}