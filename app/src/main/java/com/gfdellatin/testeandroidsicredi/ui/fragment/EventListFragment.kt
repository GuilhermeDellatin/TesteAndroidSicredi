package com.gfdellatin.testeandroidsicredi.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.gfdellatin.testeandroidsicredi.R
import com.gfdellatin.testeandroidsicredi.databinding.FragmentEventListBinding
import com.gfdellatin.testeandroidsicredi.domain.model.Event
import com.gfdellatin.testeandroidsicredi.ui.adapter.EventListAdapter
import com.gfdellatin.testeandroidsicredi.ui.view_model.EventListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class EventListFragment : Fragment() {

    private val viewModel: EventListViewModel by viewModel()
    private val eventListAdapter : EventListAdapter by lazy {
        EventListAdapter(
           onDetailsItemClick = { item: Event ->
               val bundle = bundleOf("event" to item)
               findNavController().navigate(R.id.toEventDetail, bundle)
           }
        )
    }

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
                    binding.progressBar.visibility = View.VISIBLE
                }
                is EventListViewModel.State.Error -> {
                    binding.progressBar.visibility = View.GONE
                }
                is EventListViewModel.State.Success -> {
                    binding.progressBar.visibility = View.GONE
                    eventListAdapter.submitList(it.list)
                }
            }
        }

    }
}