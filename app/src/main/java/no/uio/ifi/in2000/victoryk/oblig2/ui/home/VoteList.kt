package no.uio.ifi.in2000.victoryk.oblig2.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import no.uio.ifi.in2000.victoryk.oblig2.Blush
import no.uio.ifi.in2000.victoryk.oblig2.LightPink

@Composable
fun VoteList(
    parties: List<String>,
    votes: List<Int>
) {
    Row(
        modifier = Modifier
            .fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.Start
        ) {
            Text( // Jeg vet dette ikke er optimalt, men noe som funker innen tidsfristen > god kodeskikk
                text = "Parti",
                fontWeight = FontWeight.Bold,
                color = Blush
            )
            Text(
                text = parties[0],
                color = LightPink
            )
            Text(
                text = parties[1],
                color = LightPink
            )
            Text(
                text = parties[2],
                color = LightPink
            )
            Text(
                text = parties[3],
                color = LightPink
            )
        }
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = "Stemmer",
                fontWeight = FontWeight.Bold,
                color = Blush
            )
            Text(
                text = "${votes[0]}",
                color = LightPink
            )
            Text(
                text = "${votes[1]}",
                color = LightPink
            )
            Text(
                text = "${votes[2]}",
                color = LightPink
            )
            Text(
                text = "${votes[3]}",
                color = LightPink
            )
        }
    }
}

@Preview
@Composable
fun PreviewVoteList() {
    val parties: List<String> = listOf("ONE", "TWO", "THREE", "FOUR")
    val votes: List<Int> = listOf(1, 2, 3, 4)
    VoteList(parties, votes)
}