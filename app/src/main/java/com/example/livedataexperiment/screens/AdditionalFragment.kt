package com.example.livedataexperiment.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.livedataexperiment.R
import com.example.livedataexperiment.databinding.FragmentAdditionalBinding
import com.example.livedataexperiment.models.Note
import com.example.livedataexperiment.viewmodel.NoteViewModel


class AdditionalFragment : Fragment() {

    private lateinit var binding: FragmentAdditionalBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val mViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)
        binding = FragmentAdditionalBinding.inflate(layoutInflater, container, false)

        binding.save.setOnClickListener {
            val title = binding.noteTitle.text.toString()
            val description = binding.description.text.toString()

            if (title.isNotEmpty() && description.isNotEmpty()){
                val noteToAdd = Note(0, title, description)
                mViewModel.addNote(noteToAdd)
                Toast.makeText(requireContext(), "Added", Toast.LENGTH_LONG).show()

            } else {
                Toast.makeText(requireContext(), "Fill all fields", Toast.LENGTH_LONG).show()
            }
        }

        return binding.root
    }
}