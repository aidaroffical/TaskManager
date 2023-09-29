package com.example.taskmanager.ui.home.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.taskmanager.databinding.ItemTaskBinding
import com.example.taskmanager.ui.model.Task

class TaskAdapter(private val onLongClick: (Task) -> Unit) : Adapter<TaskAdapter.TaskViewHolder>() {
    private val data = arrayListOf<Task>()
    private var color = true

    fun addTask(tasks: List<Task>) {
        data.clear()
        data.addAll(tasks)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(
            ItemTaskBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.count()
    }

    inner class TaskViewHolder(private val binding: ItemTaskBinding) : ViewHolder(binding.root) {


        fun bind(task: Task) {
            with(binding) {
                tvTittle.text = task.tittle
                tvDesc.text = task.desc
                itemView.setOnLongClickListener {
                    onLongClick(task)
                    false
                }
            }
            if (color) {
                itemView.setBackgroundColor(Color.BLACK)
                binding.tvDesc.setTextColor(Color.WHITE)
                binding.tvTittle.setTextColor(Color.WHITE)
                color = false
            } else {
                itemView.setBackgroundColor(Color.WHITE)
                binding.tvDesc.setTextColor(Color.BLACK)
                binding.tvTittle.setTextColor(Color.BLACK)
                color = true
            }
        }
    }
}
