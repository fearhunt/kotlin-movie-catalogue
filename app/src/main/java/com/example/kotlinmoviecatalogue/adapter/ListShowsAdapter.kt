package com.example.kotlinmoviecatalogue.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinmoviecatalogue.R
import com.example.kotlinmoviecatalogue.databinding.ItemRowShowsBinding
import com.example.kotlinmoviecatalogue.entity.Shows

class ListShowsAdapter : RecyclerView.Adapter<ListShowsAdapter.ListViewHolder>() {
    private var mData = ArrayList<Shows>()

    fun setData(shows: ArrayList<Shows>) {
        mData = shows
        notifyDataSetChanged()
    }

    fun clearData() {
        mData.clear()
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemRowShowsBinding.bind(itemView)

        fun bind(shows: Shows) {
            val context = itemView.context
            val img = context.resources.getIdentifier(shows.poster, "drawable", context.packageName)

            binding.imgPoster.setImageResource(img)
            binding.tvShowsTitle.text = shows.title
            binding.tvShowsReleaseYear.text = shows.release_year
            binding.tvShowsOverview.text = shows.overview
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): ListViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_shows, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(mData[position])
    }

    override fun getItemCount(): Int {
        return mData.size
    }
}
