package com.example.randomcatfacts.adapter

import android.graphics.Color
import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.randomcatfacts.databinding.CatFactItemBinding

class FavoriteFactAdapter(
    private val imagesList: List<String>,
    private val factsList: List<String>,
    private val listener: OnItemClickListener
): RecyclerView.Adapter<FavoriteFactAdapter.ItemViewHolder>() {

    private var buttonStates = BooleanArray(imagesList.size) { true }

    inner class ItemViewHolder(private val binding: CatFactItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(imageUrl: String, fact: String) {
            Glide.with(binding.root)
                .load(imageUrl)
                .into(binding.photo)

            binding.textFact.text = fact

            if (buttonStates[adapterPosition]) {
                binding.like.setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN)
            } else {
                binding.like.clearColorFilter()
            }

            binding.like.setOnClickListener {
                val currentState = buttonStates[adapterPosition]
                if (currentState) {
                    binding.like.clearColorFilter()
                } else {
                    binding.like.setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN)
                }
                buttonStates[adapterPosition] = !currentState

                listener.onButtonClick(imageUrl, fact, currentState)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = CatFactItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(imagesList[position], factsList[position])
    }

    override fun getItemCount(): Int {return imagesList.size}
}