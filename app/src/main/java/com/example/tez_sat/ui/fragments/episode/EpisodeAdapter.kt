package com.example.tez_sat.ui.fragments.episode

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tez_sat.databinding.ListEpisodeBinding
import com.example.tez_sat.model.EpisodeModel

class EpisodeAdapter : RecyclerView.Adapter<EpisodeAdapter.ViewHolder>() {

    private lateinit var binding: ListEpisodeBinding
    private var list: ArrayList<EpisodeModel.Result> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ListEpisodeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun addItems(data: List<EpisodeModel.Result>) {
        list.addAll(data)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding: ListEpisodeBinding = ListEpisodeBinding.bind(itemView)

        fun onBind(episode: EpisodeModel.Result) {
            binding.tvNameEpisode.text = episode.name
            binding.tvDateEpisode.text = episode.air_date
            binding.tvEpisode.text = episode.episode
            binding.tvCreated.text = episode.created

        }
    }
}