package com.example.hw__3m4.ui.fragment.note

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.hw__3m4.App
import com.example.hw__3m4.R
import com.example.hw__3m4.data.model.NoteModel
import com.example.hw__3m4.databinding.FragmentDetailNoteBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class DetailNoteFragment : Fragment() {

    private val binding by lazy {
        FragmentDetailNoteBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpListeners()
        displayCurrentDateTime()
    }

    private fun setUpListeners() {
        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.tvReady.visibility =
                    if (binding.etTitle.text.isNotEmpty() || binding.etDescription.text.isNotEmpty()) {
                        View.VISIBLE
                    } else {
                        View.GONE
                    }
            }

            override fun afterTextChanged(p0: Editable?) {}
        }

        binding.etTitle.addTextChangedListener(textWatcher)
        binding.etDescription.addTextChangedListener(textWatcher)

        binding.tvReady.setOnClickListener {
            val etTitle = binding.etTitle.text.toString()
            val etDescription = binding.etDescription.text.toString()
            val tvDate = binding.tvDate.text.toString()
            val tvTime = binding.tvTime.text.toString()

            GlobalScope.launch {
                App.getInstance()?.noteDao()?.insertNote(
                    NoteModel(
                        title = etTitle,
                        description = etDescription,
                        time = tvTime,
                        date = tvDate
                    )
                )
            }

            findNavController().navigate(R.id.action_detailNoteFragment_to_noteFragment)
        }

        binding.tvReady.visibility = View.GONE
    }

    private fun displayCurrentDateTime() {
        val currentDateTime = LocalDateTime.now()
        val formatterDate = DateTimeFormatter.ofPattern("dd MMMM")
        val formatterTime = DateTimeFormatter.ofPattern("HH:mm")
        val formattedDate = currentDateTime.format(formatterDate)
        val formattedTime = currentDateTime.format(formatterTime)
        binding.tvDate.text = formattedDate
        binding.tvTime.text = formattedTime
    }
}