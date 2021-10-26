package com.example.tez_sat.ui.fragments.location

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tez_sat.databinding.ListLocationBinding
import com.example.tez_sat.model.LocationModel

class LocationAdapter : RecyclerView.Adapter<LocationAdapter.ViewHolder>() {

    private lateinit var binding: ListLocationBinding
    private var list: ArrayList<LocationModel.Result> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ListLocationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun addItems(data: List<LocationModel.Result>) {
        list.addAll(data)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding: ListLocationBinding = ListLocationBinding.bind(itemView)

        fun onBind(location: LocationModel.Result) {
            binding.tvNameLocation.text = location.name
            binding.tvTypeLocation.text = location.type
            binding.tvDimensionLocation.text = location.dimension
            binding.tvCreatedLocation.text = location.created

        }
    }
}