package no.uio.ifi.in2000.victoryk.oblig2.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

// Viser kortene i en LazyColumn eller LazyVerticalGrid.
// Denne skal kun observere UI-staten som ligger i HomeViewModel
@Composable
fun AlpacaCard(
    name: String,
    img: String,
    leader: String,
    color: Color,
    // NAVIGATION? ONCLICK? NOE FOR Å REGISTRERE KLIKK/ÅPNE EN PARTYSCREEN
) {
    Card(modifier = Modifier
        .padding(8.dp)
        .size(192.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = name)
            Image(
                painter = rememberAsyncImagePainter(img),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth()
            )
            Text(text = "Leder: $leader")
            Box(modifier = Modifier
                .background(color)
                .fillMaxWidth()
                .height(28.dp))
        }
    }
}


@Composable
fun HomeScreen(
    viewModel: HomeViewModel = HomeViewModel()
) {
    val homeUiState by viewModel.homeUiState.collectAsState()



}
