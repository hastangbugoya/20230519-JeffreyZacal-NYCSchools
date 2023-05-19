package com.example.a20230519_jeffreyzacal_nycschools.network

import com.example.a20230519_jeffreyzacal_nycschools.data.NYSchools
import com.example.a20230519_jeffreyzacal_nycschools.data.SATScores
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
/*
 * Retrofit class for API calls
 */
private const val BASE_URL = "https://data.cityofnewyork.us/resource/"
class MyRetrofit {
    companion object {
        fun createRetofit(): Retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        fun getService() : NYSchoolService = createRetofit().create(NYSchoolService::class.java)
    }
}
interface NYSchoolService {
    @GET("s3k6-pzi2.json")
    suspend fun getSchools() : Response<NYSchools>

    @GET("f9bf-2cp4.json")
    suspend fun getSATScores(): Response<SATScores>
}