package no.uio.ifi.in2000.victoryk.oblig2.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.SavedStateHandle
import coil.compose.rememberAsyncImagePainter

@Composable
fun PartyScreen(viewModel: PartyViewModel = PartyViewModel(savedStateHandle = SavedStateHandle()), partyId: String?) {
    val state by viewModel.uiState.collectAsState()


}

@Composable
fun PartyLayout(
    name: String,
    leader: String,
    img: String,
    color: String,
    description: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier.padding(all = 8.dp)
    ) {
        Text(
            text = name,
            style = typography.titleMedium
        )
        Image(
            painter = rememberAsyncImagePainter(model = img),
            contentDescription = null,
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
                .border(2.dp, color = Color(color.toInt()), CircleShape)
        )
        Text(text = "Navn: $leader")
        Text(description)
    }
}

@Preview
@Composable
fun PreviewPartyLayout() {
    PartyLayout(
        name = "NAME",
        leader = "YAHOO",
        img = "https://cdn.pixabay.com/photo/2019/06/24/10/42/alpaca-4295702_960_720.jpg",
        color = "#edb879",
        description = "Chewpaca, med sin saftige, brune pels og navn inspirert av den berømte Star Wars-karakteren Chewbacca, er en uimotståelig alpakka født under de klare stjernehimmelen på et dyreelskende småbruk i Oregon.\\n\\nHan kom til verden med en bemerkelsesverdig høy statur og et ansikt så uttrykksfullt at det straks minnet gårdseierne om den kjære Wookiee krigeren. Chewpaca viste seg tidlig som en naturlig beskytter av de yngre og mindre alpakkaene på gården, og hans dype, nysgerrige brumming la til personligheten som allerede var like stor som hans filmiske motpart.\\n\\nKjærlig og leken, har han blitt lokalberømthet for sitt gode humør og for sin rolle i å gjøre gårdbesøk til et intergalaktisk eventyr for fans og familier som kommer for å møte denne stjernen fra alpakkaverdenen.")
}