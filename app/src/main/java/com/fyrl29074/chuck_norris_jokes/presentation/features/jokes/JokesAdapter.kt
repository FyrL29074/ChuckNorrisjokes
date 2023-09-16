package com.fyrl29074.chuck_norris_jokes.presentation.features.jokes

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fyrl29074.chuck_norris_jokes.databinding.ItemJokeBinding
import com.fyrl29074.chuck_norris_jokes.presentation.model.JokeVO

class JokesAdapter(
    private val onClick: (String) -> Unit
) : RecyclerView.Adapter<JokesAdapter.JokesViewHolder>() {

    private var data: List<JokeVO> = emptyList()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: List<JokeVO>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokesViewHolder {
        val binding = ItemJokeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return JokesViewHolder(binding)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: JokesViewHolder, position: Int) {
        val item = data[position]

        with(holder.binding) {
            joke.text = item.text
            joke.setOnClickListener {
                onClick(item.text)
            }
        }
    }

    inner class JokesViewHolder(val binding: ItemJokeBinding) : RecyclerView.ViewHolder(binding.root)
}
