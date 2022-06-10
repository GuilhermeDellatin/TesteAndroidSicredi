package com.gfdellatin.testeandroidsicredi.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.gfdellatin.testeandroidsicredi.R
import com.gfdellatin.testeandroidsicredi.core.formatCurrency
import com.gfdellatin.testeandroidsicredi.core.toFormatDate
import com.gfdellatin.testeandroidsicredi.core.toFormatHour
import com.gfdellatin.testeandroidsicredi.databinding.FragmentEventDetailBinding
import com.gfdellatin.testeandroidsicredi.domain.model.Event

class EventDetailFragment: Fragment() {

    private lateinit var eventSelected: Event

    private val binding : FragmentEventDetailBinding by lazy {
        FragmentEventDetailBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let { bundle ->
            eventSelected = EventDetailFragmentArgs.fromBundle(bundle).event
        }

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
        initBinds()
    }

    private fun initBinds() {
        with(binding) {
            Glide.with(root)
                .load(eventSelected.image)
                .error(R.drawable.ic_img_placeholder)
                .into(imgEventDetail)
            eventTitleDetail.text = eventSelected.title
            dayTv.text = eventSelected.date.toFormatDate()
            hourTv.text = eventSelected.date.toFormatHour()
            chipPrice.text = eventSelected.price.formatCurrency()
            descriptionTv.text = eventSelected.description
        }
    }

}