package com.startedup.base.api

import android.arch.lifecycle.LiveData

import com.startedup.base.model.influx.Food
import com.startedup.base.model.movies.TopRatedMovieResponse

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("1bsedk")
    fun getFoods(): LiveData<ApiResponse<Food>>

    @GET("movie/top_rated")
    fun getTopRatedMovies(@Query("api_key") apiKey: String): Observable<TopRatedMovieResponse>
}
