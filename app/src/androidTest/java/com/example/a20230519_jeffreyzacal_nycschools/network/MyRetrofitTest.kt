package com.example.a20230519_jeffreyzacal_nycschools.network

import com.example.a20230519_jeffreyzacal_nycschools.data.NYSchools
import com.example.a20230519_jeffreyzacal_nycschools.data.SATScores
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Test
import retrofit2.Response

class MyRetrofitTest{
    @Test
    fun testCreateRetrofit() {
        val retrofit = MyRetrofit.createRetofit()

        // Assert retrofit instance is not null
        assertEquals(true, retrofit != null)
    }

    @Test
    fun testGetService() {
        val service = MyRetrofit.getService()

        // Assert that service instance is not null
        assertEquals(true, service != null)
    }

    @Test
    fun testGetSchools() = runBlocking {
        val response: Response<NYSchools> = MyRetrofit.getService().getSchools()

        // Assert successful
        assertEquals(true, response.isSuccessful)

        // Assert response body is not null
        assertEquals(true, response.body() != null)
    }

    @Test
    fun testGetSATScores() = runBlocking {
        val response: Response<SATScores> = MyRetrofit.getService().getSATScores()

        // Assert response is successful
        assertEquals(true, response.isSuccessful)

        // Assert response body is not null
        assertEquals(true, response.body() != null)
    }
}