package com.example.movie.view

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.movie.core.extensions.loadFromUrl
import com.example.movie.core.extensions.set
import com.example.movie.core.functions.getGenres
import com.example.movie.core.functions.setString
import com.example.movie.databinding.FragmentDetailBinding
import com.example.movie.data.entitiy.MixModel
import com.example.movie.core.util.Constants
import com.example.movie.core.list.detailTabLayoutList
import com.example.movie.core.list.frameLayoutForMovieDetail

class MovieDetailFragment : Fragment() {
    private val fragmentList= arrayListOf(CastFragment(),ReviewerFragment(),RecommendationFragment())
    private lateinit var binding: FragmentDetailBinding
    private val args: MovieDetailFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        val tabLayout = binding.tabs
        tabLayout.set(
            detailTabLayoutList,childFragmentManager,fragmentList,
            frameLayoutForMovieDetail
        )
        setMain()
        bundle()
        return (binding.root)
    }
    @SuppressLint("SetTextI18n")
    private fun setMain() {
        with(binding){
            budgetText.text = "$${args.movieModel.budget}"
            language.text = args.movieModel.original_language?.let { setString(it) }
            statusext.text = args.movieModel.status
            homePageText.text = args.movieModel.homepage
            revenueText.text = "$${args.movieModel.revenue}"
            titleText.text = args.movieModel.title
            genresText.text = args.movieModel.genres?.let { getGenres(it) }
            relaseDateText.text = args.movieModel.release_date
            runTimeText.text = "${args.movieModel.runtime}m"
            voteAverageText.text = args.movieModel.vote_average.toString()
            imageView3.loadFromUrl(Constants.IMAGE_URL+args.movieModel.backdrop_path)
            imageView2.loadFromUrl(Constants.IMAGE_URL+args.movieModel.poster_path)
            overviewText.text = args.movieModel.overview
            homePageText.setOnClickListener{
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(args.movieModel.homepage)))
            }
            facebookImage.setOnClickListener{
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(Constants.FACEBOOK+args.movieModel.external_ids.facebook_id)))
            }
            twitterImage.setOnClickListener{
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(Constants.TWITTER+args.movieModel.external_ids.twitter_id)))
            }
            instagramImage.setOnClickListener{
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(Constants.INSTAGRAM+args.movieModel.external_ids.instagram_id)))
            }
        }
    }
    private fun bundle(){
        val bundle = Bundle()
        val mixModelList:ArrayList<MixModel>? = args.movieModel.recommendations?.results
        bundle.putParcelableArrayList("list", mixModelList)
        args.movieModel.title?.let {
            bundle.putString("title",it)
        }
        args.movieModel.id?.let {
            bundle.putInt("id", it)
        }
        bundle.putString("name","emptyName")
        fragmentList[0].arguments = bundle
        fragmentList[1].arguments = bundle
        fragmentList[2].arguments = bundle
    }
}