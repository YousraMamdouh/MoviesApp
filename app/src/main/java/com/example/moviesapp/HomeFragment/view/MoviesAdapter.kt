package com.example.moviesapp.HomeFragment.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesapp.R
import com.example.moviesapp.model.Movie

/**
 * The `MoviesAdapter` class is a RecyclerView adapter responsible for binding movie data to the UI.
 *
 * @param context The context in which the adapter is used.
 * @param array A list of movie items to be displayed in the RecyclerView.
 * @param clickListener An instance of [OnMovieClickListener] for handling movie item clicks.
 */
class MoviesAdapter(
    private var context: Context,
    private var array: ArrayList<Movie>,
    private val clickListener: OnMovieClickListener,
) : androidx.recyclerview.widget.ListAdapter<Movie, MoviesAdapter.ViewHolder>(MyDiffUtil()) {

    var myContext: Context

    init {
        myContext = context
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //    val context:FragmentA
        context = parent.context
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item, parent, false)
        return ViewHolder(view)
    }

    /**
     * Binds the movie data to the UI elements of a ViewHolder.
     *
     * @param holder The ViewHolder to bind data to.
     * @param position The position of the movie item in the list.
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentMovie: Movie = getItem(position)
        val posterUrl = "https://image.tmdb.org/t/p/w500${currentMovie.posterPath}"
        Glide.with(context).load(posterUrl).placeholder(R.drawable.placeholder)
            .into(holder.movieImage)

        holder.movieTitle.text = currentMovie.title
        holder.movieReleaseData.text = currentMovie.releaseDate

        holder.card.setOnClickListener {
            clickListener.showMovieDetails(currentMovie)
        }

    }

    /**
     * The `ViewHolder` class represents a single item view within the RecyclerView.
     *
     * @param itemView The item view to be displayed.
     */
    class ViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
        val movieTitle: TextView = itemView.findViewById(R.id.movieTitle)
        val movieReleaseData: TextView = itemView.findViewById(R.id.movieReleaseData)
        val movieImage: ImageView = itemView.findViewById(R.id.movieImage)
        val card: CardView = itemView.findViewById(R.id.cardView)
    }
}

/**
 * The `MyDiffUtil` class is used for computing the difference between two lists of movies.
 */
class MyDiffUtil : DiffUtil.ItemCallback<Movie>() {
    override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem === newItem
    }

    override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
        return oldItem == newItem
    }

}