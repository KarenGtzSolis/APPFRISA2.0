package com.example.navdrawer.service



import OrgRegister
import com.example.navdrawer.model.OrganizationResponse


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface OrgService {

    //@POST("organizations/add") // Incluye la ruta específica del endpoint aquí
    //suspend fun addOrg(@Header("Authorization") token: String, @Body org: OrgRegister): OrgRegisterResponse


    //@GET("organizations/all")
    //suspend fun getAllOrgs(): List<OrgRegister>


    //@GET("organizations/all")
    //suspend fun getAllOrgs(): List<OrgRegister>



    companion object {

        val instance: OrgService = Retrofit.Builder().baseUrl("https://androidapi-8n8l-dev.fl0.io/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(OrgService::class.java)
    }


    @GET("organizations/all")
    suspend fun getAllOrgs(): OrganizationResponse
}