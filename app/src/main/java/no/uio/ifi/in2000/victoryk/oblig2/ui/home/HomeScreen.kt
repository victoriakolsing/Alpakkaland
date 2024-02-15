package no.uio.ifi.in2000.victoryk.oblig2.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import no.uio.ifi.in2000.victoryk.oblig2.model.alpacas.PartyInfo

// Viser kortene i en LazyColumn eller LazyVerticalGrid.
// Denne skal kun observere UI-staten som ligger i HomeViewModel


@Composable
fun PartyCard(
    modifier: Modifier = Modifier,
    partyInfo: PartyInfo
) {
    Card(modifier = modifier) {
        Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
            Column(modifier = modifier) {
                Text(text = partyInfo.name)

                AsyncImage(
                    modifier = modifier,
                    model = partyInfo.img,
                    contentDescription = null)

                Text(text = partyInfo.leader)
            }
        }
    }
}

@Composable 
fun HomeScreen(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel = viewModel()
) {
    val parties by homeViewModel.homeUiState.collectAsState()

    Row {
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 128.dp)
        ) {
            items(parties.parties) { partyInfo ->
                PartyCard(
                    partyInfo = partyInfo,
                    modifier = modifier.padding(all = 8.dp)
                )
            }
        }
    }
}