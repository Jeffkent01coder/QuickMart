package com.example.quickmart.homeFragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quickmart.R
import com.example.quickmart.adapters.CartAdapter
import com.example.quickmart.databinding.FragmentCartBinding
import com.example.quickmart.model.ProductData
import com.example.quickmart.subscreen.Checkouts


class CartFragment : Fragment(), CartAdapter.OnCartClickListener {
    private var _binding: FragmentCartBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: CartAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var cartArrayList: ArrayList<ProductData>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCartBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.cartRecyclerView)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = CartAdapter(cartArrayList, this)
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()

        binding.btnCheckOut.setOnClickListener {
            val intent = Intent(requireActivity(), Checkouts::class.java)
            startActivity(intent)
        }

    }

    private fun dataInitialize() {
        cartArrayList = arrayListOf(
            ProductData("", R.drawable.bana, "Banana", "2 kg", "", "ksh 300"),
            ProductData("", R.drawable.apple, "Banana", "2 kg", "", "ksh 300"),
            ProductData("", R.drawable.fruit, "Banana", "2 kg", "", "ksh 300"),
            ProductData("", R.drawable.bana, "Banana", "2 kg", "", "ksh 300"),
            ProductData("", R.drawable.apple, "Banana", "2 kg", "", "ksh 300"),
            ProductData("", R.drawable.bana, "Banana", "2 kg", "", "ksh 300"),
            ProductData("", R.drawable.pasta, "Banana", "2 kg", "", "ksh 300"),
            ProductData("", R.drawable.bana, "Banana", "2 kg", "", "ksh 300"),
            ProductData("", R.drawable.juice, "Banana", "2 kg", "", "ksh 300"),
            ProductData("", R.drawable.bana, "Banana", "2 kg", "", "ksh 300"),
            ProductData("", R.drawable.fruit, "Banana", "2 kg", "", "ksh 300"),
            ProductData("", R.drawable.bana, "Banana", "2 kg", "", "ksh 300"),
            ProductData("", R.drawable.bana, "Banana", "2 kg", "", "ksh 300"),
            ProductData("", R.drawable.bana, "Banana", "2 kg", "", "ksh 300"),
            ProductData("", R.drawable.bana, "Banana", "2 kg", "", "ksh 300"),
            ProductData("", R.drawable.bana, "Banana", "2 kg", "", "ksh 300"),
            ProductData("", R.drawable.bana, "Banana", "2 kg", "", "ksh 300"),

            )
    }

    override fun onAddClick(product: ProductData, position: Int) {
        Toast.makeText(requireActivity(), "added", Toast.LENGTH_SHORT).show()
    }

    override fun onSubtractClick(product: ProductData, position: Int) {
        Toast.makeText(requireActivity(), "removed", Toast.LENGTH_SHORT).show()
    }

    override fun onDeleteClick(product: ProductData, position: Int) {
        Toast.makeText(requireActivity(), "Deleted", Toast.LENGTH_SHORT).show()
    }

}