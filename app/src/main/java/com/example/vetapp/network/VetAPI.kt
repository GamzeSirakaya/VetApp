package com.example.vetapp.network

import com.example.vetapp.model.*
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST


interface VetAPI {
    @FormUrlEncoded
    @POST("kayitol.php")
    fun getRegister(
        @Field("kadi") kadi: String,
        @Field("mailAdres") mailAdres: String,
        @Field("parola") parola: String
    ): Single<UserRegister>

    @FormUrlEncoded
    @POST("girisyap.php")
    fun getLogin(
        @Field("mail") mailAdres: String,
        @Field("password") password: String
    ): Single<UserLogin>

    @FormUrlEncoded
    @POST("petlerim.php")
    fun getPetList(
        @Field("musid") mus_id: String,
    ): Observable<List<PetList>>


    @GET("kampanya.php")
    fun getCampaignList(
    ): Observable<List<Campaign>>

    @FormUrlEncoded
    @POST("sorusor.php")
    fun getQuestion(@Field("mus_id") id: String, @Field("soru") soru: String): Observable<Question>

    @FormUrlEncoded
    @POST("cevap.php")
    fun getAnswer(@Field("mus_id") mus_id: String): Observable<List<Answer>>

    @FormUrlEncoded
    @POST("cevapsil.php")
    fun getRemoveAnswer(
        @Field("cevap") cevap: String,
        @Field("soru") soru: String
    ): Observable<AnswerRemove>
    @FormUrlEncoded
    @POST("asitakip.php")
    fun getAsiTakibi(@Field("mus_id") mus_id: String): Observable<List<Vaccine>>


    companion object {
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