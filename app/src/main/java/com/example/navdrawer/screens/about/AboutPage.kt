package com.example.navdrawer.screens.about


import android.content.Intent
import android.provider.ContactsContract.CommonDataKinds.Organization
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White

import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.navdrawer.R
import com.example.navdrawer.UserViewModel.OrganizationViewModel
import com.example.navdrawer.model.OrganizationResponse
import com.example.navdrawer.service.OrgService
import com.example.navdrawer.ui.theme.RojoFrisa


@Composable
fun AboutPage(orgname: String = "", navController: NavHostController) {





    /*
    Column {
        Text(text = "Aquí se muestra la info de una organización")
    }

    Box(contentAlignment= Alignment.Center,
        modifier= Modifier.fillMaxSize()){
        Text(text=" $orgname", style = TextStyle(color = Black))
    }



     */

    Column(
        modifier = Modifier.fillMaxSize(),


    ) {
        val orgViewModel = OrganizationViewModel(OrgService.instance)

        val Organizations = remember {
            mutableStateOf(OrganizationResponse())
        }

        // Obtén los detalles de la organización con el nombre especificado
        val organization = Organizations.value.find { it.name == orgname }

        organization?.let {
        //IMAGEN DE LA ORGANIZACIÓN
            AsyncImage(
                model = organization.image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(400.dp)
                    .height(200.dp)
                )

            Spacer(modifier = Modifier.height(10.dp))

            Row() {
                var mensaje by remember { mutableStateOf("Visita la organización www.org.com") }

                val intent = remember { Intent(Intent.ACTION_SEND).apply {
                    putExtra(Intent.EXTRA_TEXT, mensaje)
                    type = "text/plain"
                } }

                val shareLauncher: ActivityResultLauncher<Intent> = rememberLauncherForActivityResult(
                    contract = ActivityResultContracts.StartActivityForResult()
                ) { _ ->
                    // Handle the result if needed
                }

                // NOMBRE DE LA ORGANIZACIÓN
                Text(
                    text = organization.name, modifier = Modifier
                        .padding(start = 20.dp),
                    style = TextStyle(
                        color = Black,
                        textAlign = TextAlign.Left,
                        fontWeight = FontWeight.Bold,
                        fontSize = 27.sp,
                    )
                )



                //ICONO DE FAVORTIOS






                // BOTON DE SHARE
                Image(
                    painter = painterResource(id = R.drawable.compartir),
                    contentDescription = "Share",
                    modifier = Modifier
                        .width(45.dp)
                        .height(45.dp)
                        .padding(start = 50.dp)
                        .clickable {
                            shareLauncher.launch(Intent.createChooser(intent, "Share to"))
                        }
                    ,colorFilter = ColorFilter.tint(RojoFrisa)
                )




            }

            Spacer(modifier = Modifier.height(10.dp))

            // DESCRIPCIÓN
            Text(
                text = "Descripción",
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.ExtraBold),
                color = Color.Black,
                modifier = Modifier
                    .padding(start = 20.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            // DESCRIPCIÓN DE LA ORGANIZACIÓN
            Text(text = organization.description, modifier = Modifier
                .padding(start = 20.dp),
                style = TextStyle(
                color = Black,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            ))

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Contacto",
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.ExtraBold),
                color = Color.Black,
                modifier = Modifier
                    .padding(start = 20.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(text = organization.email, modifier = Modifier
                .padding(start = 20.dp),
                style = TextStyle(
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                ))

            Text(text = organization.linkWeb, modifier = Modifier
                .padding(start = 20.dp),
                style = TextStyle(
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                ))

            Spacer(modifier = Modifier.height(10.dp))

            Text(text = organization.street, modifier = Modifier
                .padding(start = 20.dp),
                style = TextStyle(
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                ))


            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Redes Sociales",
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.ExtraBold),
                color = Color.Black,
                modifier = Modifier
                    .padding(start = 20.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            //BOTONES DE REDES SOCIALES

            Row(
                modifier = Modifier
                    .padding(start = 17.dp),

            ){
                Image(
                    painter = painterResource(id = R.drawable.instagram),
                    contentDescription = "Insta",
                    modifier = Modifier
                        .width(45.dp)
                        .height(45.dp)
                        .padding(5.dp)
                        .clickable {
                            navController.navigate(organization.linkInstagram)
                        }
                    ,colorFilter = ColorFilter.tint(RojoFrisa)
                )

                Image(
                    painter = painterResource(id = R.drawable.facebook),
                    contentDescription = "Face",
                    modifier = Modifier
                        .width(45.dp)
                        .height(45.dp)
                        .padding(5.dp)
                        .clickable {
                            navController.navigate(organization.linkFacebook)
                        }
                    ,colorFilter = ColorFilter.tint(RojoFrisa)
                )


                Image(
                    painter = painterResource(id = R.drawable.twitter),
                    contentDescription = "Twitter",
                    modifier = Modifier
                        .width(45.dp)
                        .height(45.dp)
                        .padding(5.dp)
                        .clickable {
                            navController.navigate(organization.linkTwitter)
                        }
                    ,colorFilter = ColorFilter.tint(RojoFrisa)
                )

                Image(
                    painter = painterResource(id = R.drawable.otro),
                    contentDescription = "Más",
                    modifier = Modifier
                        .width(45.dp)
                        .height(45.dp)
                        .padding(5.dp)
                        .clickable {
                            navController.navigate(organization.linkFacebook)
                        }
                    ,colorFilter = ColorFilter.tint(RojoFrisa)
                )


            }


            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Publicaciones",
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.ExtraBold),
                color = Color.Black,
                modifier = Modifier
                    .padding(start = 20.dp)
            )

            // AQUÍ VAN LAS PUBLICACIONES DE LA ORGANIZACIÓN
            Spacer(modifier = Modifier.height(10.dp))














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


@Composable
fun SocialMediaButton(icon: ImageVector, onClick: () -> Unit) {

    Button(
        onClick = onClick,
        modifier = Modifier.padding(horizontal = 1.dp)
    ) {

    }
}






