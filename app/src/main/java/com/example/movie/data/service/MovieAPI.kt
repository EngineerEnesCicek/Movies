package com.example.movie.data.service

import com.example.movie.data.entitiy.MovieModel
import com.example.movie.data.entitiy.ActorModel
import com.example.movie.data.entitiy.TVShowModel
import com.example.movie.data.entitiy.PopularMoviesResponse
import com.example.movie.data.entitiy.PopularPersonResponse
import com.example.movie.data.entitiy.PopularTvShowResponse
import com.example.movie.data.entitiy.MixSearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieAPI {
    @GET("/3/movie/{movie_id}?")
    suspend fun getMovie(
        @Path("movie_id") movie_id:Int,
        @Query("api_key") key:String,
        @Query("append_to_response") type:String
    ): Response<MovieModel>
    @GET("/3/tv/{tv_id}?")
    suspend fun getTvShow(
        @Path("tv_id") tv_id:Int,
        @Query("api_key") key:String,
        @Query("append_to_response") type:String
    ): Response<TVShowModel>
    @GET("/3/person/{person_id}?")
    suspend fun getPerson(
        @Path("person_id") person_id:Int,
        @Query("api_key") key:String,
        @Query("append_to_response") type:String
    ):Response<ActorModel>
    @GET("/3/trending/all/day")
    suspend fun getTrend(
        @Query("api_key") key:String,
    ):Response<MixSearchResponse>
    @GET("/3/search/multi")
    suspend fun getSearchAll(
        @Query("api_key") key:String,
        @Query("query") query:String,
        @Query("page") page:String
    ):Response<MixSearchResponse>
    @GET("/3/trending/all/week")
    suspend fun getTrendThisWeek(
        @Query("api_key") key:String,
    ):Response<MixSearchResponse>
    @GET("/3/movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") key:String,
        @Query("page") page:Int
    ):Response<PopularMoviesResponse>
    @GET("/3/tv/popular")
    suspend fun getPopularTvShow(
        @Query("api_key") key:String,
        @Query("page") page:Int
    ):Response<PopularTvShowResponse>
    @GET("/3/person/popular")
    suspend fun getPopularPerson(
        @Query("api_key") key:String,
        @Query("page") page:Int
    ):Response<PopularPersonResponse>

}