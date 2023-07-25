package com.example.movie.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.movie.adapters.SelectListener
import com.example.movie.databinding.FragmentActorDetailBinding
import com.example.movie.core.extensions.loadFromUrl
import com.example.movie.core.functions.getGender
import com.example.movie.adapters.MixAdapter
import com.example.movie.data.entitiy.MixModel
import com.example.movie.core.util.Constants


class ActorDetailFragment : Fragment(), SelectListener {
    private val args: ActorDetailFragmentArgs by navArgs()
    lateinit var binding: FragmentActorDetailBinding
    private var mixModelList= ArrayList<MixModel>()
    private lateinit var navController: NavController
    private lateinit var movieListViewModel: MovieListViewModel
    private lateinit var recyclerView: RecyclerView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navController = Navigation.findNavController(view)
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentActorDetailBinding.inflate(layoutInflater, container, false)
        recyclerView = this.binding.knownForRecyclerView
        recyclerView.layoutManager = LinearLayoutManager(activity)
        movieListViewModel = ViewModelProvider(this)[MovieListViewModel::class.java]
        with(binding) {
            imageView.loadFromUrl(Constants.IMAGE_URL + args.actorModel.profile_path)
            biographyText.text = args.actorModel.biography
            birthPlaceText.text = args.actorModel.place_of_birth
            birthdayText.text = args.actorModel.birthday
            knownForDepartmentText.text = args.actorModel.known_for_department
            nameText.text = args.actorModel.name
            genderText.text = args.actorModel.gender?.let { getGender(it) }
            facebookImage.setOnClickListener {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse(Constants.FACEBOOK + args.actorModel.external_ids?.facebook_id)
                    )
                )
            }
            twitterImage.setOnClickListener {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse(Constants.TWITTER + args.actorModel.external_ids?.twitter_id)
                    )
                )
            }
            instagramImage.setOnClickListener {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse(Constants.INSTAGRAM + args.actorModel.external_ids?.instagram_id)
                    )
                )
            }
        }
        args.actorModel.combined_credits?.cast?.let { mixModelList.addAll(it) }
        args.actorModel.combined_credits?.crew?.let { mixModelList.addAll(it) }
        val adapter = MixAdapter(mixModelList, this)
        recyclerView.adapter = adapter
    return binding.root
}

override fun onItemClicked(mixModel: MixModel) {
    if (mixModel.media_type == "tv") {
        movieListViewModel.getTvShow(mixModel.id)
        movieListViewModel.mTvShow.observe(this) {
            val action =
                ActorDetailFragmentDirections.actionActorDetailFragmentToTvShowDetailFragment(it)
            navController.navigate(action)
        }
    } else {
        movieListViewModel.getMovie(mixModel.id)
        movieListViewModel.mMovies.observe(this) {
            val action =
                ActorDetailFragmentDirections.actionActorDetailFragmentToDetailFragment(it)
            navController.navigate(action)
        }
    }
}
}