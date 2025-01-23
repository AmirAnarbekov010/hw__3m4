package com.example.hw6_geeks

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ItemListFragment : Fragment(R.layout.fragment_item_list) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val itemList = listOf(
            Item("Item 1"),
            Item("Item 2"),
            Item("Item 3"),
            Item("Item 4"),
            Item("Item 5")
        )

        val adapter = ItemAdapter(itemList)
        recyclerView.adapter = adapter

        adapter.setOnItemClickListener { item ->
            val action = ItemListFragmentDirections
                .actionItemListFragmentToItemDetailFragment(item.name)
            findNavController().navigate(action)
        }
    }
}
