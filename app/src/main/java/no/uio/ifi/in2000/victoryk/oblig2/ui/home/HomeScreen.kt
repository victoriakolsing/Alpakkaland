package no.uio.ifi.in2000.victoryk.oblig2.ui.home

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import no.uio.ifi.in2000.victoryk.oblig2.model.alpacas.PartyInfo

// Viser kortene i en LazyColumn eller LazyVerticalGrid.
// Denne skal kun observere UI-staten som ligger i HomeViewModel


@Composable
fun PartyCard(partyInfo: PartyInfo, modifier: Modifier = Modifier) {
    Card(modifier) {

    }
}
@Composable 
fun HomeScreen(
    partyList: List<PartyInfo>,
    modifier: Modifier = Modifier,
    homeUiState: HomeUiState
) {
    Row {
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 128.dp)
        ) {
            items(partyList) {
                PartyCard(
                    partyInfo = homeUiState.parties[0], // WOWOWOWOWO PLACEHOLDER HARDKODET INTEGER HER
                    modifier.padding(all = 8.dp)
                )
            }
        }
    }
}