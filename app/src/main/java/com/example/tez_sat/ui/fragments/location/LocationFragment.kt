package com.example.tez_sat.ui.fragments.location

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tez_sat.core.ui.BaseFragment
import com.example.tez_sat.databinding.FragmentLocationBinding
import com.example.youtubeapi.core.network.Status
import org.koin.androidx.viewmodel.ext.android.viewModel

class LocationFragment : BaseFragment<FragmentLocationBinding>(FragmentLocationBinding::inflate) {

    private val viewModel: LocationViewModel by viewModel()
    private val myAdapter: LocationAdapter = LocationAdapter()

    override fun setupLiveData() {

        viewModel.getAllLocations().observe(viewLifecycleOwner, { response->

            when(response.status){
                Status.SUCCESS ->{
                    binding.progressBar.visibility = View.GONE
                    response.data?.let { it1 -> myAdapter.addItems(it1.results) }
                }
                Status.ERROR->{
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(requireContext(),"Error! ${response.message}", Toast.LENGTH_SHORT).show()
                }
                Status.LOADING->{
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

}