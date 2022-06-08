package com.gfdellatin.testeandroidsicredi.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gfdellatin.testeandroidsicredi.databinding.FragmentEventListBinding
import com.gfdellatin.testeandroidsicredi.ui.adapter.EventListAdapter
import com.gfdellatin.testeandroidsicredi.ui.view_model.EventListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class EventListFragment : Fragment() {

    private val viewModel: EventListViewModel by viewModel()
    private val eventListAdapter = EventListAdapter()

    private val binding : FragmentEventListBinding by lazy {
        FragmentEventListBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView()
        setupObservers()
    }

    private fun setRecyclerView() {
        binding.recyclerViewEvents.adapter = eventListAdapter
    }

    private fun setupObservers() {

        viewModel.eventsLiveData.observe(viewLifecycleOwner) {
            when (it) {
                is EventListViewModel.State.Loading -> {
                    viewModel.showProgressBar()
                }
                is EventListViewModel.State.Error -> {
                    viewModel.hideProgressBar()
                }
                is EventListViewModel.State.Success -> {
                    viewModel.hideProgressBar()
                    eventListAdapter.submitList(it.list)
                }
            }
        }

    }
}