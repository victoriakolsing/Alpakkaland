package no.uio.ifi.in2000.victoryk.oblig2.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

// Viser kortene i en LazyColumn eller LazyVerticalGrid.
// Denne skal kun observere UI-staten som ligger i HomeViewModel

@Composable
fun AlpacaCard() {

    val temporaryPartyName = "Party name"
    val temporaryImageURL = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRQAWoLZpHFCADozs4_TEvQwAXwEURTgakqV-9auJ_klHJcF1Wrxg&s"
    val temporaryLeaderName = "Leader"
    val temporaryPartyColor: Color = Color.Red

    Card(
        modifier = Modifier.size(150.dp),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(text = temporaryPartyName)
            Image(
                painter = rememberAsyncImagePainter(temporaryImageURL),
                contentDescription = null,
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
                    .border(2.dp, color = temporaryPartyColor, CircleShape)
            )
            Text(text = temporaryLeaderName)
        }
    }
}


@Preview
@Composable
fun PreviewAlpacaCard() {
    AlpacaCard()
}

@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    val partyList = viewModel.partyList

    LazyColumn {
        items(partyList.value) { party ->
            Text(text = party.toString())
            // Render each party info item
        }
    }
}
