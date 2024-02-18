package no.uio.ifi.in2000.victoryk.oblig2.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import no.uio.ifi.in2000.victoryk.oblig2.SuperLightPink

// Viser kortene i en LazyColumn eller LazyVerticalGrid.
// Denne skal kun observere UI-staten som ligger i HomeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlpacaCard(
    id: String,
    name: String,
    img: String,
    leader: String,
    color: String,
    navController: NavController
) {
    Card(
        modifier = Modifier
            .clickable {
                navController.navigate("PartyScreen/$id")
            }
            .padding(all = 8.dp)
            .fillMaxSize(),
        colors = CardDefaults.cardColors(SuperLightPink)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 16.dp)
        ) {
            Text(text = name, fontWeight = FontWeight.Bold)
            Image(
                painter = rememberAsyncImagePainter(img),
                contentDescription = null,
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
                    .border(8.dp, color = getColor(color), CircleShape)
            )
            Text(text = "Leder: $leader")
        }
    }
}

@Composable
fun HomeScreen(viewModel: HomeViewModel, navController: NavController) {
    val partyInfoList by viewModel.partyList.collectAsState()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(partyInfoList) {partyInfo ->
            AlpacaCard(
                id = partyInfo.id,
                name = partyInfo.name,
                img = partyInfo.img,
                leader = partyInfo.leader,
                color = partyInfo.color,
                navController = navController)
        }
    }
}

@Composable
fun getColor(color: String): Color {
    return Color(android.graphics.Color.parseColor(color))
}