package com.example.tez_sat.ui.fragments.character

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tez_sat.databinding.ItemListBinding
import com.example.tez_sat.model.RickiModel

class CharacterAdapter(private val clickListener: (item: RickiModel.Result) -> Unit) :
    RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    private lateinit var binding: ItemListBinding
    private var list: ArrayList<RickiModel.Result> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun addItems(data: List<RickiModel.Result>) {
            list.addAll(data)
            notifyDataSetChanged()

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding: ItemListBinding = ItemListBinding.bind(itemView)

        fun onBind(rickiModel: RickiModel.Result) {

            Glide.with(itemView).load(rickiModel.image).centerCrop()
                .into(binding.ivAvatar)
            binding.tvName.text = rickiModel.name
            binding.tvAlive.text = rickiModel.status
            binding.tvLocation.text = rickiModel.location.name
            binding.tvHuman.text = rickiModel.species
            binding.tvFirstSeen.text = rickiModel.origin.name
            binding.tvCreated.text = rickiModel.created
            binding.tvGender.text = rickiModel.gender
            itemView.setOnClickListener {
                clickListener(rickiModel)
            }

        }
    }
}