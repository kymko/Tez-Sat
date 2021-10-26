package com.example.tez_sat.ui.fragments.episode

import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tez_sat.core.ui.BaseFragment
import com.example.tez_sat.databinding.FragmentEpisodeBinding
import com.example.youtubeapi.core.network.Status
import org.koin.androidx.viewmodel.ext.android.viewModel

class EpisodeFragment : BaseFragment<FragmentEpisodeBinding>(FragmentEpisodeBinding::inflate) {

    private val viewModel:EpisodeViewModel by viewModel()
    private val myAdapter:EpisodeAdapter = EpisodeAdapter()

    override fun setupLiveData() {

        viewModel.getAllEpisodes().observe(viewLifecycleOwner,{ episodes->

            when(episodes.status){
                Status.SUCCESS ->{
                    binding.progressBar.visibility = View.GONE
                    episodes.data?.results?.let { myAdapter.addItems(it) }
                }
                Status.ERROR->{
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(requireContext(),"Error! ${episodes.message}", Toast.LENGTH_SHORT).show()
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