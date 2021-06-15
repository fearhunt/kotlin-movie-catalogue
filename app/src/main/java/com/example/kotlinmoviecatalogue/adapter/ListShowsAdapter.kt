package com.example.kotlinmoviecatalogue.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinmoviecatalogue.R
import com.example.kotlinmoviecatalogue.ShowsDetailActivity
import com.example.kotlinmoviecatalogue.databinding.ItemRowShowsBinding
import com.example.kotlinmoviecatalogue.entity.ShowsEntity

class ListShowsAdapter(private val showsType: String?) : RecyclerView.Adapter<ListShowsAdapter.ListViewHolder>() {
    private var mData = ArrayList<ShowsEntity>()

    fun setData(shows: List<ShowsEntity>) {
        mData.clear()
        mData.addAll(shows)
        notifyDataSetChanged()
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemRowShowsBinding.bind(itemView)

        fun bind(shows: ShowsEntity) {
            val context = itemView.context
            val img = context.resources.getIdentifier(shows.poster, "drawable", context.packageName)

            with(binding) {
                imgPoster.setImageResource(img)
                tvShowsTitle.text = shows.title
                tvShowsReleaseYear.text = shows.release_year
                tvShowsOverview.text = shows.overview
                card.setOnClickListener {
                    val intent = Intent(context, ShowsDetailActivity::class.java)
                    intent.putExtra(ShowsDetailActivity.EXTRA_SHOWS_TITLE, shows.title)
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
}
