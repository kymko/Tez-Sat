package com.example.tez_sat.ui.fragments.character.detail

import android.util.Log
import com.bumptech.glide.Glide
import com.example.tez_sat.core.ui.BaseFragment
import com.example.tez_sat.databinding.FragmentDetailCharacterBinding
import com.example.tez_sat.ui.activities.main.MainActivity.Companion.KEY
import org.koin.android.ext.android.bind
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.time.LocalDate

class DetailCharacterFragment :
    BaseFragment<FragmentDetailCharacterBinding>(FragmentDetailCharacterBinding::inflate) {

    private val viewModel: DetailCharacterViewModel by viewModel()

    override fun setupLiveData() {

        val id = arguments?.getInt(KEY)

        if (id != null) {
            viewModel.getCharacterById(id).observe(viewLifecycleOwner, {
                Log.d("tag", "from ${it.data.toString()}")
                Glide.with(requireActivity()).load(it.data?.image).centerCrop()
                    .into(binding.ivAvatar)
                binding.tvName.text = it.data?.name
                binding.tvAlive.text = it.data?.status
                binding.tvHuman.text = it.data?.species
                binding.tvFirstSeen.text = it.data?.gender
                binding.tvLocation.text = it.data?.location?.name
                binding.tvFirstSeen.text = it.data?.origin?.name
                binding.tvCreated.text = it.data?.created

            })
        }

    }

    override fun setupUI() {

    }

}