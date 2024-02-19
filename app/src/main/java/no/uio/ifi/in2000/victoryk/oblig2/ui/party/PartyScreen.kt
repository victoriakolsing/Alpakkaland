@file:OptIn(ExperimentalMaterial3Api::class)

package no.uio.ifi.in2000.victoryk.oblig2.ui.party

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import no.uio.ifi.in2000.victoryk.oblig2.Blush
import no.uio.ifi.in2000.victoryk.oblig2.SuperLightPink
import no.uio.ifi.in2000.victoryk.oblig2.ui.home.getColor

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PartyScreen(
    navController: NavController,
    viewModel: PartyViewModel,
) {
    val state by viewModel.uiState.collectAsState()
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
                colors = topAppBarColors(
                    containerColor = SuperLightPink,
                    titleContentColor = Blush
                ),
                title = {
                    Text("Alpaca Parties")
                }
            )
        }
    ) { innerPadding ->
        LazyColumn {
            items(state.party) { party ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier.padding(innerPadding)
                ) {
                    Text(
                        text = party.name,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Image(
                        painter = rememberAsyncImagePainter(model = party.img),
                        contentDescription = null,
                        modifier = Modifier
                            .size(64.dp)
                            .clip(CircleShape)
                            .border(2.dp, color = getColor(party.color), CircleShape)
                    )
                    Text(text = "Navn: ${party.leader}")
                    Text(
                        text = party.description,
                        modifier = Modifier.padding(all = 16.dp)
                    )
                }
            }
        }
    }
}

