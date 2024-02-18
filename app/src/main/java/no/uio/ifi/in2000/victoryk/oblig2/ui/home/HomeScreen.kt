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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import kotlinx.coroutines.flow.StateFlow
import no.uio.ifi.in2000.victoryk.oblig2.model.alpacas.PartyInfo

// Viser kortene i en LazyColumn eller LazyVerticalGrid.
// Denne skal kun observere UI-staten som ligger i HomeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlpacaCard(partyInfo: PartyInfo, onNavigateToParty: (PartyInfo) -> Unit) {

    // temporary values to test composable
    /*
    val temporaryPartyName = "Party name"
    val temporaryImageURL = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRQAWoLZpHFCADozs4_TEvQwAXwEURTgakqV-9auJ_klHJcF1Wrxg&s"
    val temporaryLeaderName = "Leader"
    val temporaryPartyColor: Color = Color.Red
    */

    // REMEMBER TO ADD HANDLING FOR IMAGES AND COLOURS AND SUCH

    Card(
        modifier = Modifier.size(150.dp),
        onClick = { onNavigateToParty }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(text = partyInfo.name)
            Image(
                painter = rememberAsyncImagePainter(partyInfo.img),
                contentDescription = null,
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
                    .border(2.dp, color = Color(partyInfo.color.toInt()), CircleShape)
            )
            Text(text = partyInfo.leader)
        }
    }
}

@Composable

// add navcontroller as arg
fun HomeScreen(viewModel: HomeViewModel, onNavigateToParty: (PartyInfo) -> Unit) {

    val partyListState: StateFlow<List<PartyInfo>> = viewModel.partyList
    // val partyList = partyListState.collectAsState(initial = emptyList())
    val partyInfoList by viewModel.partyList.collectAsState()

    LazyColumn{
        items(partyInfoList) {party ->
            AlpacaCard(partyInfo = party, onNavigateToParty = onNavigateToParty)
        }
    }
}
