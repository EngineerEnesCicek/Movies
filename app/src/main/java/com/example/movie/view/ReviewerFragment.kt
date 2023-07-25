package com.example.movie.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movie.adapters.ReveiwerAdapter
import com.example.movie.databinding.FragmentReveiwerBinding

class ReviewerFragment : Fragment() {
    private lateinit var binding: FragmentReveiwerBinding
    private lateinit var navController: NavController
    private lateinit var movieListViewModel: MovieListViewModel
    private lateinit var recyclerView: RecyclerView
    var name=""
    var title=""
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navController = Navigation.findNavController(view)
        super.onViewCreated(view, savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding=FragmentReveiwerBinding.inflate(layoutInflater,container,false)
        recyclerView = this.binding.reveiwerRecyclerView
        movieListViewModel = ViewModelProvider(this)[MovieListViewModel::class.java]
        recyclerView.layoutManager = LinearLayoutManager(activity)
        val id= arguments?.getInt("id")
        name= arguments?.getString("name").toString()
        title= arguments?.getString("title").toString()
        if (name!="emptyName" && id!=null){
            movieListViewModel.getTvShow(id)
            movieListViewModel.mTvShow.observe(this){
                    tvShowModel->
                val adapter=tvShowModel.reviews?.results?.let { it->ReveiwerAdapter(it) }
                recyclerView.adapter=adapter
            }
        }
        if (id != null && title!="emptyTitle") {
            movieListViewModel.getMovie(id)
        }
        movieListViewModel.mMovies.observe(viewLifecycleOwner){movieModel->
            val adapter= movieModel.reviews?.results?.let { it -> ReveiwerAdapter(it) }
            recyclerView.adapter=adapter
        }
        return binding.root
    }

}