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
import com.example.movie.adapters.SelectListener
import com.example.movie.databinding.FragmentRecommendedBinding
import com.example.movie.adapters.MixAdapter
import com.example.movie.data.entitiy.MixModel

class RecommendationFragment : Fragment(), SelectListener {
    private lateinit var binding: FragmentRecommendedBinding
    private lateinit var navController: NavController
    private lateinit var movieListViewModel: MovieListViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var list: ArrayList<MixModel>
    var name = ""
    var title = ""
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navController = Navigation.findNavController(view)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRecommendedBinding.inflate(layoutInflater, container, false)
        recyclerView = this.binding.recommendationsRecyclerView
        movieListViewModel = ViewModelProvider(this)[MovieListViewModel::class.java]
        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        val id = arguments?.getInt("id")
        name = arguments?.getString("name").toString()
        title = arguments?.getString("title").toString()
        if (name != "emptyName" && id != null) {
            list= arguments?.getParcelableArrayList("list")!!
        }
        if (id != null && title != "emptyTitle") {
            list= arguments?.getParcelableArrayList("list")!!
        }
        val adapter = MixAdapter(list, this)
        recyclerView.adapter = adapter
        return binding.root
    }

    override fun onItemClicked(mixModel: MixModel) {
        if (name != "emptyName") {
            movieListViewModel.getTvShow(mixModel.id)
            movieListViewModel.mTvShow.observe(this) {
                val action = TvShowDetailFragmentDirections.actionTvShowDetailFragmentSelf(it)
                navController.navigate(action)
            }
        }
        if (title != "emptyTitle") {
            movieListViewModel.getMovie(mixModel.id)
            movieListViewModel.mMovies.observe(viewLifecycleOwner) {
                val action = MovieDetailFragmentDirections.actionDetailFragmentSelf(it)
                navController.navigate(action)
            }
        }
    }
}