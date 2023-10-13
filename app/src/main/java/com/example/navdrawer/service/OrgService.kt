package com.example.navdrawer.service


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

    companion object {
        // Especifica la URL base sin incluir la ruta específica del endpoint
        private const val BASE_URL = "https://androidapi-8n8l-dev.fl0.io/api/"

        fun create(): OrgService {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(OrgService::class.java)
        }
    }
}