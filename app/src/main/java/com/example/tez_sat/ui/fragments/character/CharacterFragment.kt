package com.example.tez_sat.ui.fragments.character

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tez_sat.R
import com.example.tez_sat.core.ui.BaseFragment
import com.example.tez_sat.databinding.FragmentCharacterBinding
import com.example.tez_sat.model.RickiModel
import com.example.tez_sat.ui.activities.main.MainActivity.Companion.KEY
import com.example.youtubeapi.core.network.Status
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterFragment :
    BaseFragment<FragmentCharacterBinding>(FragmentCharacterBinding::inflate) {

    private val viewModel: CharacterViewModel by viewModel()
    private var myAdapter: CharacterAdapter = CharacterAdapter(this::clickListener)

    override fun setupLiveData() {
        viewModel.getAllCharacters().observe(viewLifecycleOwner, { response ->

            when (response.status) {
                Status.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    response.data?.results?.let { myAdapter.addItems(it) }
                }
                Status.ERROR -> {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(
                        requireContext(),
                        "Error! ${response.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                Status.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                }
            }
        })
    }

    override fun setupUI() {
        binding.recyclerview.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = myAdapter
        }
    }

    private fun clickListener(item: RickiModel.Result) {
        val bundle = Bundle()
        bundle.putInt(KEY, item.id)
        findNavController().navigate(R.id.detailCharacterFragment, bundle)
    }
}