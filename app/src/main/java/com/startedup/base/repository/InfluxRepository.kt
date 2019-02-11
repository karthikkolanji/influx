package com.startedup.base.repository

import android.arch.lifecycle.LiveData
import android.support.annotation.NonNull
import android.support.annotation.Nullable
import android.util.Log
import com.startedup.base.api.ApiService
import com.startedup.base.api.Resource
import com.startedup.base.db.InfluxDao
import com.startedup.base.model.influx.Food
import javax.inject.Inject
import com.startedup.base.api.ApiResponse
import com.startedup.base.api.NetworkBoundResource
import com.startedup.base.utils.AppExecutors
import com.startedup.base.utils.RateLimiter
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit


class InfluxRepository @Inject constructor(private val apiService: ApiService,
                                           private val influxDao: InfluxDao,
                                           private val appExecutors: AppExecutors) {

    private val repoListRateLimit = RateLimiter<String>(10, TimeUnit.MINUTES)

    fun loadRepos(): LiveData<Resource<Food>> {
        return object : NetworkBoundResource<Food, Food>(appExecutors) {
            override fun saveCallResult(item: Food) {
                influxDao.insert(item)
            }

            override fun shouldFetch(data: Food?): Boolean {
                return data == null  || repoListRateLimit.shouldFetch(owner)
            }

            override fun loadFromDb() = influxDao.getAll()

            override fun createCall() = apiService.getFoods()

            override fun onFetchFailed() {
                repoListRateLimit.reset(owner)
            }
        }.asLiveData()
    }

}