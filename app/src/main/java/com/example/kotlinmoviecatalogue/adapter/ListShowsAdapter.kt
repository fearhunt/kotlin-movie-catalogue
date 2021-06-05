package com.example.kotlinmoviecatalogue.adapter

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinmoviecatalogue.R
import com.example.kotlinmoviecatalogue.ShowsDetailActivity
import com.example.kotlinmoviecatalogue.databinding.ItemRowShowsBinding
import com.example.kotlinmoviecatalogue.entity.ShowsEntity

class ListShowsAdapter : RecyclerView.Adapter<ListShowsAdapter.ListViewHolder>() {
    private var mData = ArrayList<ShowsEntity>()

    fun setData(shows: ArrayList<ShowsEntity>) {
        mData = shows
        notifyDataSetChanged()
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemRowShowsBinding.bind(itemView)

        fun bind(shows: ShowsEntity) {
            val context = itemView.context
            val img = context.resources.getIdentifier(shows.poster, "drawable", context.packageName)

            binding.imgPoster.setImageResource(img)
            binding.tvShowsTitle.text = shows.title
            binding.tvShowsReleaseYear.text = shows.release_year
            binding.tvShowsOverview.text = shows.overview
            binding.card.setOnClickListener {
                val intent = Intent(context, ShowsDetailActivity::class.java)
                context.startActivity(intent)
            }
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
