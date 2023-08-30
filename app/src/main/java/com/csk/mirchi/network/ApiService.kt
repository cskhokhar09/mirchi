package com.csk.mirchi.network

import com.csk.mirchi.App
import com.csk.mirchi.R
import com.csk.mirchi.data.Grocery
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {

    @GET("groceries")
    suspend fun getGroceryData(): List<Grocery>

    companion object{
        private var apiService: ApiService? = null
        fun getApiService(): ApiService {
            if(apiService==null){
                return Retrofit.Builder()
                      .baseUrl(App().getContext().resources.getString(R.string.baseUrl))
                      .addConverterFactory(GsonConverterFactory.create())
                      .build()
                      .create(ApiService::class.java)
            }
            return apiService!!
        }

    }
}