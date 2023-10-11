package com.example.navdrawer.screens.detalles

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.navdrawer.AppViewModel
import com.example.navdrawer.R

@Composable
fun detalles(posttitulo: String = "sin nombre"){

    var isFavorito by remember { mutableStateOf(false) }

Column {
    Box() {

        Image(
            painter = painterResource(
                id = R.drawable.imagenorg
            ),
            contentDescription = "Imagen de la organización",
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth(),

            contentScale = ContentScale.Crop
        )


    }

        Text(
            text = " $posttitulo?",
            style = TextStyle(fontSize = 27.sp, fontWeight = FontWeight.ExtraBold),
            color = Color.Red,


            )



    Text(
        text = "Escrito por: ARENA",
        style = TextStyle(fontSize = 15.sp, fontWeight = FontWeight.ExtraBold),
        color = Color.Black,
        modifier = Modifier
            .padding(2.dp)
            .offset(x = (16.dp))


    )
/*
    IconToggleButton(

        checked = isFavorito,
        onCheckedChange = { isFavorito = it },
        modifier = Modifier
            .offset(x = 340.dp)
            .offset(y = -55.dp)



    ) {
        if (isFavorito) {
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = "Favorito",
                tint = Color.Red
            )
        } else {
            Icon(
                imageVector = Icons.Outlined.FavoriteBorder,
                contentDescription = "No Favorito",
                tint = Color.Gray
            )
        }
    }


 */







LazyColumn(
    modifier = Modifier
        .padding(1.dp)

) {

    item {
        Text(
            text = "El autismo es un espectro de trastornos neurológicos que afecta a millones de personas en todo el mundo. A pesar de ser relativamente común, existe una gran cantidad de mitos y estereotipos que rodean a esta condición. En ARENA, estamos comprometidos en desmitificar estas falsas creencias y promover la inclusión de las personas con autismo en nuestra sociedad.\n\nEl autismo no es una enfermedad, ni algo que deba \"curarse\". Es una variación natural de la neurodiversidad, y las personas en el espectro del autismo tienen una amplia gama de habilidades, intereses y desafíos. En lugar de enfocarnos en las limitaciones, debemos centrarnos en las fortalezas y capacidades únicas que cada individuo con autismo aporta.\n\nUno de los mitos más comunes sobre el autismo es que todas las personas en el espectro son iguales. Nada podría estar más lejos de la verdad. Cada persona con autismo es única, con sus propias necesidades y deseos. La inclusión significa adaptar nuestro entorno y nuestras actitudes para permitir que cada persona con autismo florezca en su propia forma.\n\nEn ARENA, trabajamos incansablemente para brindar apoyo, educación y recursos a las familias y comunidades que conviven con el autismo. Nuestra misión es promover la aceptación, la comprensión y la inclusión de las personas en el espectro del autismo en todas las áreas de la vida. Juntos, podemos construir un mundo más amable y comprensivo para todas las personas, independientemente de su neurodiversidad.\n\n¡Te invitamos a unirte a nosotros en este viaje de aprendizaje y aceptación! Juntos, podemos construir un futuro en el que cada individuo con autismo tenga la oportunidad de alcanzar su máximo potencial y vivir una vida plena y significativa.",
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                textAlign = TextAlign.Justify,

            ),
            color = Color.Black,
            modifier = Modifier
                .padding(14.dp)
        )

    }
}




}
















    }

