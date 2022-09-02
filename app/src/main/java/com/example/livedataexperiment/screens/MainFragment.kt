package com.example.livedataexperiment.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.livedataexperiment.R
import com.example.livedataexperiment.databinding.FragmentAdditionalBinding
import com.example.livedataexperiment.databinding.FragmentMainBinding
import com.example.livedataexperiment.viewmodel.NoteViewModel


class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private lateinit var adapter: AdapterNote
    private lateinit var recycler: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val mViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)

        adapter = AdapterNote()
        recycler = binding.recyclerView
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(requireContext())
        mViewModel.mLiveData.observe(viewLifecycleOwner, { list ->
            adapter.setList(list)
        })


        return binding.root
    }


}