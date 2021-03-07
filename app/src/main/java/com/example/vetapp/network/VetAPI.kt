package com.example.vetapp.network

import com.example.vetapp.Models.UserRegister
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface VetAPI {
    @FormUrlEncoded
    @POST("kayitol.php")
    fun getRegister(@Field("kadi") kadi:String,
                    @Field("mailAdres") mailAdres: String,
                    @Field("parola") parola:String):Single<UserRegister>

    companion object{
        const val BASE_URL = "https://www.gamzesirakaya.com/veterinerservis/"
        fun getService(): VetAPI {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(VetAPI::class.java)
        }
    }

}