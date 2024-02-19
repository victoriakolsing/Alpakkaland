package no.uio.ifi.in2000.victoryk.oblig2.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
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
import coil.compose.rememberAsyncImagePainter
import no.uio.ifi.in2000.victoryk.oblig2.SuperLightPink

@Composable
fun AlpacaCard(
    id: String,
    name: String,
    img: String,
    leader: String,
    color: String,
    onNavigateToParty: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(all = 8.dp)
            .fillMaxSize(),
        colors = CardDefaults.cardColors(SuperLightPink),
        onClick = { onNavigateToParty(id) }
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
fun HomeScreen(
    viewModel: HomeViewModel = HomeViewModel(),
    onNavigateToParty: (String) -> Unit
) {
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
                onNavigateToParty = onNavigateToParty
            )
        }
    }
}

@Composable
fun getColor(color: String): Color {
    return Color(android.graphics.Color.parseColor(color))
}