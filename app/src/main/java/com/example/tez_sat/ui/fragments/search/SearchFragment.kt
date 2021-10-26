package com.example.tez_sat.ui.fragments.search

import android.app.AlertDialog
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tez_sat.core.ui.BaseFragment
import com.example.tez_sat.databinding.FragmentSearchBinding
import com.example.tez_sat.model.RickiModel
import com.example.tez_sat.ui.fragments.character.CharacterAdapter
import com.example.youtubeapi.core.network.Status
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : BaseFragment<FragmentSearchBinding>(FragmentSearchBinding::inflate) {

    private val viewModel: SearchViewModel by viewModel()
    private val myAdapter: CharacterAdapter = CharacterAdapter(this::clickListener)
    private var sortedList: List<RickiModel.Result> = arrayListOf()

    private var live = ""
    private var gender = ""

    override fun setupLiveData() {

        binding.btnShowResult.setOnClickListener {

            viewModel.getFilterCharacter(binding.etName.text.toString(), live, gender)
                .observe(viewLifecycleOwner, { response ->

                    when (response.status) {
                        Status.SUCCESS -> {
                            binding.containerDialog.visibility = View.GONE
                            binding.progressBar.visibility = View.GONE
                            binding.recyclerview.visibility = View.VISIBLE
                            sortedList = response.data?.results?.sortedByDescending { it.created }!!
                            myAdapter.addItems(sortedList)
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
    }

    override fun setupUI() {

        binding.recyclerview.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = myAdapter
        }

        binding.dialogBtnStatus.setOnClickListener {
            showStatusDialog()
        }
        binding.dialogBtnGender.setOnClickListener {
            showGenderDialog()
        }
    }

    private fun showStatusDialog() {

        val items = arrayOf("alive", "dead", "unknown")
        val selectedItem = -1
        val builder = AlertDialog.Builder(requireContext())

        builder.setTitle("Filter for the status")
        builder.setSingleChoiceItems(items, selectedItem) { _, i ->
            if (i == 0) {
                live = items[0]
            }
            if (i == 1) {
                live = items[1]
            }
            if (i == 2) {
                live = items[2]
            }

        }
        builder.setPositiveButton("DONE") { _, _ ->
            Toast.makeText(requireContext(), live, Toast.LENGTH_SHORT).show()
        }

        builder.show()
    }

    private fun showGenderDialog() {

        val items = arrayOf("male", "female", "genderless")
        val selectedItem = -1
        val builder = AlertDialog.Builder(requireContext())

        builder.setTitle("Filter for the gender!")
        builder.setSingleChoiceItems(items, selectedItem) { _, i ->
            if (i == 0) {
                gender = items[0]
            }
            if (i == 1) {
                gender = items[1]
            }
            if (i == 2) {
                gender = items[2]
            }
        }
        builder.setPositiveButton("DONE") { _, _ ->
            Toast.makeText(requireContext(), gender, Toast.LENGTH_SHORT).show()
        }

        builder.show()
    }

    private fun clickListener(item: RickiModel.Result) {

    }
}