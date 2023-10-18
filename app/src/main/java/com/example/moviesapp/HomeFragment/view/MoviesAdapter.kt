package com.example.moviesapp.HomeFragment.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviesapp.R
import com.example.moviesapp.model.Movie

class MoviesAdapter(
    private var context: Context, private var array: ArrayList<Movie>,
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

        Glide.with(context).load(currentMovie.poster_path).placeholder(R.drawable.placeholder).into(holder.movieImage)

        holder.movieTitle.text = currentMovie.title
        holder.movieReleaseData.text = currentMovie.release_date




    }

    class ViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
        val movieTitle = itemView.findViewById<TextView>(R.id.movieTitle)
        val movieReleaseData = itemView.findViewById<TextView>(R.id.movieReleaseData)
        val movieImage=itemView.findViewById<ImageView>(R.id.movieImage)



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