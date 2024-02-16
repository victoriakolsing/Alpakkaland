package no.uio.ifi.in2000.victoryk.oblig2.ui.home

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
import androidx.compose.runtime.LaunchedEffect
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
import coil.compose.AsyncImage

@Composable
fun PartyScreen(
    partyViewModel: PartyViewModel = PartyViewModel(),
    partyId: String
) {
    val partyUiState by partyViewModel.uiState.collectAsState()
    val partyInfo = partyUiState.party

    LaunchedEffect(Unit) {
        partyViewModel.getPartyInfo(partyId)
    }



    Row(modifier = Modifier, verticalAlignment = Alignment.CenterVertically) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // 1. Partinavn
            Text(
                text = partyViewModel.name,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp,
                textAlign = TextAlign.Center
            )

            // 2. Bilde
            AsyncImage(
                model = partyViewModel.img,
                contentDescription = null,
                modifier = Modifier
                    .height(150.dp)
                    .width(150.dp)
            )    // contentdescription som beskrivelse eller null?

            // 3. Leder
            Text(text = partyViewModel.leader)

            // 4. farge
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(8.dp)
                    .clip(RectangleShape)
                    .background(color = Color(partyViewModel.color.toInt()))
            )
            // 5. Beskrivelse
            Text(text = partyViewModel.description)
        }
    }
}
