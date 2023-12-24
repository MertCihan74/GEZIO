package com.gezioteam.gezio

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.Toast

class HomeFragment : Fragment() {

    private var isFavorite = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val favs = view.findViewById<CheckBox>(R.id.imageView15)
        favs.setOnClickListener {
            isFavorite = !isFavorite

            val toastMessage = if (isFavorite) {
                "Added to your favorite places"
            } else {
                "Removed from favorite places"
            }

            Toast.makeText(requireContext(), toastMessage, Toast.LENGTH_SHORT).show()
        }
        val favs1 = view.findViewById<CheckBox>(R.id.imageView6)
        favs1.setOnClickListener {
            isFavorite = !isFavorite

            val toastMessage = if (isFavorite) {
                "Added to your favorite places"
            } else {
                "Removed from favorite places"
            }

            Toast.makeText(requireContext(), toastMessage, Toast.LENGTH_SHORT).show()
        }
        val favs2 = view.findViewById<CheckBox>(R.id.imageView23)
        favs2.setOnClickListener {
            isFavorite = !isFavorite

            val toastMessage = if (isFavorite) {
                "Added to your favorite places"
            } else {
                "Removed from favorite places"
            }

            Toast.makeText(requireContext(), toastMessage, Toast.LENGTH_SHORT).show()
        }
        return view
    }
}
