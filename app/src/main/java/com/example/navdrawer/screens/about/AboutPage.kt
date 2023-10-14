package com.example.navdrawer.screens.about

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.navdrawer.UserViewModel.OrganizationViewModel
import com.example.navdrawer.model.OrganizationResponse

import com.example.navdrawer.screens.home.OrgRow
import com.example.navdrawer.service.OrgService


@Composable
fun AboutPage(orgname: String = "", navController: NavHostController) {
    Column {
        Text(text = "Aquí se muestra la info de una organización")
    }

    Box(contentAlignment= Alignment.Center,
        modifier= Modifier.fillMaxSize()){
        Text(text="Nombre Organización: $orgname", style = TextStyle(color = White))
    }



    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        val orgViewModel = OrganizationViewModel(OrgService.instance)

        val Organizations = remember {
            mutableStateOf(OrganizationResponse())
        }

        // Obtén los detalles de la organización con el nombre especificado
        val organization = Organizations.value.find { it.name == orgname }

        organization?.let {
            // Organizacion encontrada con el nombre especificado
            Text(text = organization.name, style = TextStyle(
                color = Black,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            ))
            Text(text = organization.description, style = TextStyle(
                color = Black,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            ))
            Text(text = organization.schedule, style = TextStyle(
                color = Black,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            ))
            
            AsyncImage(
                model = organization.image,
                contentDescription = null,
            )

        }

        LaunchedEffect(key1 = orgViewModel.getOrgResult) {
            orgViewModel.getUserFavoriteOrganization()
            orgViewModel.getOrgResult.collect { result ->
                if (result != null) {
                    val organizationsResponse = OrganizationResponse()
                    organizationsResponse.addAll(result)
                    Organizations.value = organizationsResponse
                }
            }
        }
    }

}









