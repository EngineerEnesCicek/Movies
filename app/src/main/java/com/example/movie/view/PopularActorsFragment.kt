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
import com.example.movie.adapters.ActorAdapter
import com.example.movie.adapters.SelectActorListener
import com.example.movie.data.entitiy.ActorModel
import com.example.movie.databinding.FragmentPopularActorsBinding

class PopularActorsFragment : Fragment(), SelectActorListener {
    private lateinit var navController: NavController
    private lateinit var movieListViewModel: MovieListViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var binding: FragmentPopularActorsBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navController = Navigation.findNavController(view)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPopularActorsBinding.inflate(layoutInflater, container, false)
        recyclerView = binding.popularActorsRecyclerView
        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        movieListViewModel = ViewModelProvider(this)[MovieListViewModel::class.java]
        movieListViewModel.getPopularActors(1)
        movieListViewModel.mPopularActors.observe(viewLifecycleOwner) {
            val adapter = ActorAdapter(it, this)
            recyclerView.adapter = adapter
        }
        return binding.root
    }

    override fun onActorClicked(actorModel: ActorModel) {
        actorModel.id?.let { movieListViewModel.getPerson(it) }
        movieListViewModel.mPerson.observe(this){
            val action = MainFragmentDirections.actionMainFragmentToActorDetailFragment(it)
            navController.navigate(action)
        }


    }
}