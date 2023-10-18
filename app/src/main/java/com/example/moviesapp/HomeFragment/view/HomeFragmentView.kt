package com.example.moviesapp.HomeFragment.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.HomeFragment.viewModel.HomeViewModel
import com.example.moviesapp.HomeFragment.viewModel.HomeViewModelFactory
import com.example.moviesapp.R
import com.example.moviesapp.model.Movie
import com.example.moviesapp.model.Repository
import com.example.moviesapp.network.MoviesClient

/**
 * The `HomeFragmentView` class represents the main fragment of the application where a list of movies
 * is displayed and can be interacted with. It is responsible for initializing the UI components and
 * handling user interactions.
 */
class HomeFragmentView : Fragment(), OnMovieClickListener {

    lateinit var recyclerView: RecyclerView
    lateinit var factory: HomeViewModelFactory
    lateinit var viewModel: HomeViewModel
    lateinit var adapter: MoviesAdapter
    lateinit var layoutManager: LinearLayoutManager
    lateinit var searchView: SearchView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        return inflater.inflate(R.layout.fragment_home_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerView)
        searchView = view.findViewById(R.id.searchView)
        setUpRecyclerView()
        setUpViewModel()
        observeMovies()
        loadMoreMoviesOnScroll()

    }

    /**
     * Initializes the ViewModel and sets up the ViewModelFactory for the `HomeViewModel`.
     */
    private fun setUpViewModel() {
        factory = HomeViewModelFactory(
            Repository.getInstance(
                MoviesClient.getInstance()

            )
        )
        viewModel = ViewModelProvider(this, factory).get(HomeViewModel::class.java)
    }

    /**
     * Observes changes in the list of movies and updates the adapter when new data is available.
     */
    private fun observeMovies() {
        viewModel.movies.observe(viewLifecycleOwner) {
                movies,
            ->
            if (movies != null) {
                adapter.submitList(movies)
            }

        }
    }

    /**
     * Implements infinite scrolling for loading more movies when the user is close to the end of the list.
     */
    private fun loadMoreMoviesOnScroll() {
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                val visibleItemCount = layoutManager.childCount
                val totalItemCount = layoutManager.itemCount
                val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()
                if (visibleItemCount + firstVisibleItemPosition >= totalItemCount - 5) {
                    // User is close to the end, load more movies
                    viewModel.loadMoreMovies()
                }
            }
        })
    }

    /**
     * Sets up the RecyclerView and its adapter.
     */
    private fun setUpRecyclerView() {
        layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = RecyclerView.VERTICAL
        adapter = activity?.let { MoviesAdapter(it, ArrayList(), this) }!!
        recyclerView.adapter = adapter
        recyclerView.layoutManager = layoutManager
    }

    /**
     * Handles the event when a movie item is clicked. Navigates to the details screen for the selected movie.
     *
     * @param movie The selected movie.
     */
    override fun showMovieDetails(movie: Movie) {

        val action =
            HomeFragmentViewDirections.actionHomeFragmentViewToMovieDetailsFragmentView(movie)
        findNavController().navigate(action)
    }

}