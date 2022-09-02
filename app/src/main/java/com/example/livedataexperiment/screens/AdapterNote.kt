package com.example.livedataexperiment.screens

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.livedataexperiment.databinding.NoteItemBinding
import com.example.livedataexperiment.models.Note

class AdapterNote : RecyclerView.Adapter<AdapterNote.NoteViewHolder>() {


    inner class NoteViewHolder(val binding: NoteItemBinding) : RecyclerView.ViewHolder(binding.root)

    var listOfNotes = emptyList<Note>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(NoteItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote = listOfNotes[position]

        holder.binding.apply {
            textViewId.text = currentNote.id.toString()
            textViewTitle.text = currentNote.title
        }
    }

    override fun getItemCount() = listOfNotes.size


    fun setList(list: List<Note>){
        listOfNotes = list
        notifyDataSetChanged()
    }


}