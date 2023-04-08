package com.example.todolist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.databinding.ItemTodosBinding

class ToDosAdapter: RecyclerView.Adapter<ToDosAdapter.ToDosViewHolder>() {

    inner class ToDosViewHolder(val binding: ItemTodosBinding) : RecyclerView.ViewHolder(binding.root)

    private val diffCallback = object : DiffUtil.ItemCallback<ToDos>(){
        override fun areItemsTheSame(oldItem: ToDos, newItem: ToDos): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ToDos, newItem: ToDos): Boolean {
            return oldItem == newItem
        }
    }
    private val differ = AsyncListDiffer(this, diffCallback)
    var toDos: List<ToDos>
        get() = differ.currentList
        set(value) {differ.submitList(value)}

    override fun getItemCount() = todos.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDosViewHolder {
        return ToDosViewHolder(ItemTodosBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: ToDosViewHolder, position: Int) {
        holder.binding.apply {
            val toDo = toDos[position]
            tvTitle.text = toDo.title
            cbDone.isChecked = toDo.completed
        }
    }
}