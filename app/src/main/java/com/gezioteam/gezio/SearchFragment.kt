package com.gezioteam.gezio

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager


class SearchFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var searchView: SearchView
    private var mList = ArrayList<SearchData>()
    private lateinit var adapter: SearchAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_search, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        searchView = view.findViewById(R.id.searchView)

        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = GridLayoutManager(requireContext(),2)
        addDataToList()
        adapter = SearchAdapter(mList)
        recyclerView.adapter = adapter

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterList(newText)
                return true
            }

        })
        return view
    }

    private fun filterList(query: String?) {

        if (query != null) {
            val filteredList = ArrayList<SearchData>()
            for (i in mList) {
                if (i.title.lowercase(Locale.ROOT).contains(query)) {
                    filteredList.add(i)
                }
            }

            if (filteredList.isEmpty()) {
                Toast.makeText(requireContext(), "No Data found", Toast.LENGTH_SHORT).show()
            } else {
                adapter.setFilteredList(filteredList)
            }
        }
    }

    private fun addDataToList() {
        mList.add(SearchData("Ankara", R.drawable.ankara_srch))
        mList.add(SearchData("İstanbul", R.drawable.istanbul_srch))
        mList.add(SearchData("İzmir", R.drawable.izmir_srch))
        mList.add(SearchData("Eskişehir", R.drawable.eskisehir_srch))
        mList.add(SearchData("Antalya", R.drawable.antalya_srch))
        mList.add(SearchData("Muğla", R.drawable.mugla_srch))

    }

}