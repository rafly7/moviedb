package net.rafly.moviedb.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import net.rafly.moviedb.R
import net.rafly.moviedb.data.model.PopularModel
import net.rafly.moviedb.databinding.ItemMovieListPopularBinding

class PopularAdapter : RecyclerView.Adapter<PopularAdapter.PopularViewHolder>() {

    inner class PopularViewHolder(private var binding: ItemMovieListPopularBinding): RecyclerView.ViewHolder(binding.root) {
        fun bindModel(data: PopularModel) {
            binding.tvTitle.text = data.title
            binding.tvOverview.text = data.overview
        }
    }

    private val differCallback = object : DiffUtil.ItemCallback<PopularModel>() {
        override fun areItemsTheSame(oldItem: PopularModel, newItem: PopularModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: PopularModel, newItem: PopularModel): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMovieListPopularBinding.inflate(inflater, parent, false)
        return PopularViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        val popular = differ.currentList[position]
        holder.bindModel(popular)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}