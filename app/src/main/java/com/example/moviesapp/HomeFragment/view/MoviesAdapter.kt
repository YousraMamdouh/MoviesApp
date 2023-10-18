package com.example.moviesapp.HomeFragment.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesapp.R
import com.example.moviesapp.model.Movie

class MoviesAdapter(
    private var context: Context, private var array: ArrayList<Movie>, private val clickListener: OnMovieClickListener
) : androidx.recyclerview.widget.ListAdapter<Movie,MoviesAdapter.ViewHolder>(MyDiffUtil()) {

    var myContext:Context
    init {
        myContext=context
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //    val context:FragmentA
        context=parent.context
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return ViewHolder(view)
    }


//    override fun getItemCount(): Int = products.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentMovie:Movie = getItem(position)
        val posterUrl = "https://image.tmdb.org/t/p/w500${currentMovie.poster_path}"
        Glide.with(context).load(posterUrl).placeholder(R.drawable.placeholder).into(holder.movieImage)

        holder.movieTitle.text = currentMovie.title
        holder.movieReleaseData.text = currentMovie.release_date

        holder.card.setOnClickListener {
            clickListener.showMovieDetails(currentMovie)
        }




    }

  class ViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
        val movieTitle: TextView = itemView.findViewById(R.id.movieTitle)
        val movieReleaseData: TextView = itemView.findViewById(R.id.movieReleaseData)
        val movieImage: ImageView =itemView.findViewById(R.id.movieImage)
         val card: CardView = itemView.findViewById(R.id.cardView)



    }



}

class MyDiffUtil : DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem
    }

}