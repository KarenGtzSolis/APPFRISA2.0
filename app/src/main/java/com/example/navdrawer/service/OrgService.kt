package com.example.navdrawer.service

import com.example.navdrawer.model.OrgLogin
import com.example.navdrawer.model.OrgLoginResponse
import com.example.navdrawer.model.OrgRegister
import com.example.navdrawer.model.OrgRegisterResponse
import com.example.navdrawer.model.OrganizationResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface OrgService {

    companion object {
        val instance: OrgService =
            Retrofit.Builder().baseUrl("https://androidapi-8n8l-dev.fl0.io/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(OrgService::class.java)
    }

    @POST("organization/register") // Incluye la ruta específica del endpoint aquí
    suspend fun insertOrg(@Body org: OrgRegister): OrgRegisterResponse

    @POST("organization/login")
    suspend fun loginOrg(@Body user: OrgLogin): OrgLoginResponse

    @GET("organizations/all")
    suspend fun getAllOrgs(): OrganizationResponse
}
