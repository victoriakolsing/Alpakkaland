@file:OptIn(ExperimentalMaterial3Api::class)

package no.uio.ifi.in2000.victoryk.oblig2.ui.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme.typography
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.lifecycle.SavedStateHandle
import coil.compose.rememberAsyncImagePainter
import no.uio.ifi.in2000.victoryk.oblig2.Blush
import no.uio.ifi.in2000.victoryk.oblig2.LightPink

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PartyScreen(
    partyId: String,
    viewModel: PartyViewModel = PartyViewModel(savedStateHandle = SavedStateHandle())
) {

    val state by viewModel.uiState.collectAsState()
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
                colors = topAppBarColors(
                    containerColor = LightPink,
                    titleContentColor = Blush
                ),
                title = {
                    Text("Alpaca Parties")
                }
            )
        }
    ) {
        PartyLayout(
            name = state.name,
            leader = state.leader,
            img = state.img,
            color = state.color,
            description = state.description
        )
    }
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
