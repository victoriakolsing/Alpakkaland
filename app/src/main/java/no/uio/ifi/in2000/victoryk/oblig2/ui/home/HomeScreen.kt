package no.uio.ifi.in2000.victoryk.oblig2.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
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
fun HomeScreen(navController: NavHostController, homeViewModel: HomeViewModel = viewModel()) {
    val homeUiState by homeViewModel.uiState.collectAsState() // pæser data til viewmodel
    Row {
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 128.dp)
        ) {
            items(homeUiState.parties) { partyInfo ->
                PartyCard(
                    partyInfo = partyInfo,
                    modifier = Modifier.padding(all = 8.dp)
                )
            }
        }
    }
}