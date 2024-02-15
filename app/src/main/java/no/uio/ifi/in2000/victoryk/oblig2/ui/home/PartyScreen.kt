package no.uio.ifi.in2000.victoryk.oblig2.ui.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import no.uio.ifi.in2000.victoryk.oblig2.model.alpacas.PartyInfo

@Composable
fun PartyScreen(
    partyInfo: PartyInfo,
    navController: NavHostController,
    partyId: String = navController.,
    partyViewModel: PartyViewModel = PartyViewModel()
) {
    val partyUiState by partyViewModel.uiState.collectAsState()

    Row(modifier = Modifier, verticalAlignment = Alignment.CenterVertically) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // 1. Partinavn
            Text(
                text = partyInfo.name,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp,
                textAlign = TextAlign.Center
            )

            // 2. Bilde
            AsyncImage(
                model = partyInfo.img,
                contentDescription = null,
                modifier = Modifier.height(150.dp).width(150.dp)
            )    // contentdescription som beskrivelse eller null?

            // 3. Leder
            Text(text = partyInfo.leader)

            // 4. farge
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
                    .clip(RectangleShape)
                    .background(colorSpacer(partyInfo))
            )
            // 5. Beskrivelse
            Text(text = partyInfo.description)
        }
    }
}

@Composable
fun colorSpacer(partyInfo: PartyInfo): Color {
    try {
        return Color(partyInfo.color.toInt())
    } catch (exception: IllegalArgumentException) {
        Log.e("ERROR", "Could not convert party color to int. Returning default color: White")
    }
    return Color.White
}

