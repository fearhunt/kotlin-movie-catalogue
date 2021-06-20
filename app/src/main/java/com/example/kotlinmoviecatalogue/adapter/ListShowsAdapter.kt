package com.example.kotlinmoviecatalogue.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlinmoviecatalogue.R
import com.example.kotlinmoviecatalogue.ShowsDetailActivity
import com.example.kotlinmoviecatalogue.data.source.local.entity.ShowsEntity
import com.example.kotlinmoviecatalogue.databinding.ItemRowShowsBinding
import java.util.*

class ListShowsAdapter(private val showsType: String?) : RecyclerView.Adapter<ListShowsAdapter.ListViewHolder>() {
    private var mData = ArrayList<ShowsEntity>()

    fun setData(shows: List<ShowsEntity>?) {
        mData.clear()
        shows?.let { mData.addAll(it) }
        notifyDataSetChanged()
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemRowShowsBinding.bind(itemView)

        fun bind(shows: ShowsEntity) {
            val context = itemView.context

            Glide.with(context)
                .load(BASE_POSTER_URL + shows.posterPath)
                .into(binding.imgPoster)

            with(binding) {
                tvShowsTitle.text = shows.title ?: shows.name
                tvShowsOverview.text = shows.overview
                card.setOnClickListener {
                    val intent = Intent(context, ShowsDetailActivity::class.java)
                    intent.putExtra(ShowsDetailActivity.EXTRA_SHOWS_ID, shows.id)
                    intent.putExtra(ShowsDetailActivity.EXTRA_SHOWS_TYPE, showsType)
                    context.startActivity(intent)
                }
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

    companion object {
        const val BASE_POSTER_URL = "https://image.tmdb.org/t/p/w200/"
    }
}
