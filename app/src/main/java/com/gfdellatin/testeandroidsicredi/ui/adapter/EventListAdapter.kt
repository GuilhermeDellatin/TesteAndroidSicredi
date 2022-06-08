package com.gfdellatin.testeandroidsicredi.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gfdellatin.testeandroidsicredi.R
import com.gfdellatin.testeandroidsicredi.core.formatCurrency
import com.gfdellatin.testeandroidsicredi.core.toFormatDate
import com.gfdellatin.testeandroidsicredi.core.toFormatHour
import com.gfdellatin.testeandroidsicredi.databinding.EventItemBinding
import com.gfdellatin.testeandroidsicredi.domain.model.Event
import java.util.*

class EventListAdapter : ListAdapter<Event, EventListAdapter.EventListViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Event>() {
            override fun areItemsTheSame(oldItem: Event, newItem: Event): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Event, newItem: Event): Boolean {
                return oldItem == newItem
            }
        }
    }

    class EventListViewHolder(
        private val itemBinding: EventItemBinding
    ) : RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(event: Event) {
            itemBinding.run {
                Glide.with(itemView)
                    .load(event.image)
                    .error(R.drawable.ic_img_placeholder)
                    .into(imgEvent)
                eventTitleTv.text = event.title
                eventDateTv.text = event.date.toFormatDate()
                eventHourTv.text = event.date.toFormatHour()
                chipStar.text = event.price.formatCurrency(Locale.getDefault())
            }
        }

        companion object {
            fun create(parent: ViewGroup) : EventListViewHolder {
                val itemBinding = EventItemBinding
                    .inflate(LayoutInflater.from(parent.context), parent, false)
                return EventListViewHolder(itemBinding)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventListViewHolder {
        return EventListViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: EventListViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}