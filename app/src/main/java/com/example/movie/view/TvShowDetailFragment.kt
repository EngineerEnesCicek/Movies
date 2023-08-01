package com.example.movie.view

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.movie.core.extensions.callFragment
import com.example.movie.core.extensions.loadFromUrl
import com.example.movie.core.extensions.set
import com.example.movie.core.functions.getGenres
import com.example.movie.core.functions.getKeywords
import com.example.movie.databinding.FragmentTvShowDetailBinding
import com.example.movie.core.list.detailTabLayoutList
import com.example.movie.core.list.frameLayoutForTvShowDetail
import com.example.movie.data.entitiy.MixModel
import com.example.movie.core.util.Constants

class TvShowDetailFragment : Fragment() {
    private val fragmentList = arrayListOf(CastFragment(),ReviewerFragment(),RecommendationFragment())
    private val args: TvShowDetailFragmentArgs by navArgs()
    private lateinit var binding: FragmentTvShowDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTvShowDetailBinding.inflate(layoutInflater, container, false)
        with(binding) {
            keywordsText.text = args.tvShowModel.keywords?.results?.let { getKeywords(it) }
            language.text = args.tvShowModel.original_language
            statusext.text = args.tvShowModel.status
            homePageText.text = args.tvShowModel.homepage
            titleText.text = args.tvShowModel.name
            numberOfSeasons.text = args.tvShowModel.number_of_seasons.toString()
            numberOfEpisodes.text = args.tvShowModel.number_of_episodes.toString()
            genresText.text = args.tvShowModel.genres?.let { getGenres(it) }
            relaseDateText.text = args.tvShowModel.first_air_date
            voteAverageText.text = args.tvShowModel.vote_average.toString()
            imageView3.loadFromUrl(Constants.IMAGE_URL + args.tvShowModel.backdrop_path)
            imageView2.loadFromUrl(Constants.IMAGE_URL + args.tvShowModel.poster_path)
            overviewText.text = args.tvShowModel.overview
            facebookImage.setOnClickListener {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse(Constants.FACEBOOK + args.tvShowModel.external_ids?.facebook_id)
                    )
                )
            }
            twitterImage.setOnClickListener {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse(Constants.TWITTER + args.tvShowModel.external_ids?.twitter_id)
                    )
                )
            }
            instagramImage.setOnClickListener {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse(Constants.INSTAGRAM + args.tvShowModel.external_ids?.instagram_id)
                    )
                )
            }
        }
        callFragment(fragmentList[0], childFragmentManager, frameLayoutForTvShowDetail)
        bundle()
        tabLayout()
        return binding.root
    }
    private fun tabLayout() {
        val tabLayout = binding.tabs
        tabLayout.set(
            detailTabLayoutList,childFragmentManager,fragmentList,
            frameLayoutForTvShowDetail
        )
    }
    private fun bundle() {
        val bundle = Bundle()
        val mixModelList: ArrayList<MixModel>? = args.tvShowModel.recommendations?.results
        bundle.putParcelableArrayList("list", mixModelList)
        args.tvShowModel.name?.let {
            bundle.putString("name", it)
        }
        args.tvShowModel.id?.let {
            bundle.putInt("id", it)
        }
        bundle.putString("title", "emptyTitle")
        fragmentList[0].arguments = bundle
        fragmentList[1].arguments = bundle
        fragmentList[2].arguments = bundle
    }
}