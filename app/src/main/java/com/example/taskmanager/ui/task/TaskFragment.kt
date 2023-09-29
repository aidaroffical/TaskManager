package com.example.taskmanager.ui.task

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.taskmanager.App
import com.example.taskmanager.databinding.FragmentTaskBinding
import com.example.taskmanager.ui.model.Task

class TaskFragment : Fragment() {

    private lateinit var binding: FragmentTaskBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSave.setOnClickListener {
            if (binding.etTittle.text.toString().isNotEmpty()) {
                findNavController().navigateUp()
            } else {
                Toast.makeText(context, "ERROR", Toast.LENGTH_SHORT).show()
                binding.etTittle.error = "ERROR"
                return@setOnClickListener
            }
            val data = Task(
                tittle = binding.etTittle.text.toString(),
                desc = binding.etDesc.text.toString()
            )
            App.db.taskDao().insert(data)
            findNavController().navigateUp()
        }
    }

    companion object {
        const val RESULT_KEY = "result.key"
        const val TASK_KEY = "task.key"
    }
}
