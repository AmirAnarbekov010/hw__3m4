package com.example.hw6_geeks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs

class ItemDetailFragment : Fragment(R.layout.fragment_item_detail) {

    private val args: ItemDetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val itemName = args.itemName
        view.findViewById<TextView>(R.id.itemNameTextView).text = itemName
    }
}
