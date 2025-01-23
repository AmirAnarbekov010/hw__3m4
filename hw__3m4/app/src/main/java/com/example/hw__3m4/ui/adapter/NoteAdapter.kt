package com.example.hw__3m4.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hw__3m4.data.model.NoteModel
import com.example.hw__3m4.databinding.ItemNoteBinding

class NoteAdapter: ListAdapter<NoteModel, NoteAdapter.ViewHolder>(DiffCallback()) {
    inner class ViewHolder(private val binding: ItemNoteBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: NoteModel) {
            binding.title.text = item.title
            binding.tvDescription.text = item.description
            binding.tvDate.text = item.date
            binding.tvTime.text = item.time
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class DiffCallback: DiffUtil.ItemCallback<NoteModel>() {
        override fun areItemsTheSame(oldItem: NoteModel, newItem: NoteModel) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: NoteModel, newItem: NoteModel) = oldItem == newItem

    }
}