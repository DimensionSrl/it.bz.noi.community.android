package it.bz.noi.community.ui.today

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import it.bz.noi.community.data.models.TimeFilter
import it.bz.noi.community.databinding.ViewHolderTimeFilterBinding

interface TimeFilterClickListener {
    fun onTimeFilterClick(position: Int)
}

class TimeFilterAdapter(
    private val timeFilters: List<TimeFilter>,
    private val listener: TimeFilterClickListener
) :
    RecyclerView.Adapter<TimeFilterAdapter.TimeFilterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimeFilterViewHolder {
        return TimeFilterViewHolder(ViewHolderTimeFilterBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: TimeFilterViewHolder, position: Int) {
        holder.bind(timeFilters[position])
    }

    override fun getItemCount() = timeFilters.size

    inner class TimeFilterViewHolder(private val binding: ViewHolderTimeFilterBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.timeFilter.setOnClickListener {
                listener.onTimeFilterClick(adapterPosition)
            }
        }

        fun bind(timeFilter: TimeFilter) {
			binding.timeFilter.text = timeFilter.filterName
			binding.timeFilter.isChecked = timeFilter.filterSelected
        }
    }
}
