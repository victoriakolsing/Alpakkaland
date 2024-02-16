package no.uio.ifi.in2000.victoryk.oblig2.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import no.uio.ifi.in2000.victoryk.oblig2.model.alpacas.PartyInfo

// Viser kortene i en LazyColumn eller LazyVerticalGrid.
// Denne skal kun observere UI-staten som ligger i HomeViewModel



    @Composable
    fun AlpacaCard(partyInfo: PartyInfo, navigateToParty: (Int) -> Unit) {
        Card(modifier = Modifier
            .padding(8.dp)
            .size(192.dp)
            .clickable { navigateToParty(partyInfo.id.toInt()) }
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = partyInfo.name)
                Image(
                    painter = rememberAsyncImagePainter(partyInfo.img),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(text = "Leder: $partyInfo.leader")
                Box(modifier = Modifier
                    .background(color = Color(partyInfo.color.toInt()))
                    .fillMaxWidth()
                    .height(28.dp))
            }
        }
    }

    @Composable
    fun HomeScreen(
        homeViewModel: HomeViewModel = viewModel(),
        navigateToParty: (Int) -> Unit

    ) {
        val homeUiState by homeViewModel.uiState.collectAsState() // pæser data til viewmodel

        LaunchedEffect(Unit) {
            homeViewModel.getPartyList()
        }
        Row {
            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 128.dp),
                content = {
                    items(homeUiState.parties) { partyInfo ->
                        AlpacaCard(partyInfo = partyInfo, navigateToParty = navigateToParty)
                    }
                }
            )
        }
    }
