package no.uio.ifi.in2000.victoryk.oblig2.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import no.uio.ifi.in2000.victoryk.oblig2.SuperLightPink
import no.uio.ifi.in2000.victoryk.oblig2.model.alpacas.PartyInfo

@Composable
fun AlpacaCard(
    party: PartyInfo,
    navController: NavController
    ) {
    Card(
        modifier = Modifier
            .clickable {
                navController.navigate("PartyScreen/${party.id}")
            }
            .padding(all = 8.dp)
            .fillMaxSize(),
        colors = CardDefaults.cardColors(SuperLightPink),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
                .padding(all = 16.dp)
        ) {
            Text(text = party.name, fontWeight = FontWeight.Bold)
            Image(
                painter = rememberAsyncImagePainter(party.img),
                contentDescription = null,
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
                    .border(8.dp, color = getColor(party.color), CircleShape)
            )
            Text(text = "Leder: ${party.leader}")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = HomeViewModel(),
) {
    val uiState by viewModel.partyList.collectAsState()
    var isExpanded by remember { mutableStateOf(false) }
    val districts: List<String> = listOf("District 1", "District 2", "District 3")
    var chosenDistrict by remember { mutableStateOf("") }

    val alpacaUiState: HomeUiState by viewModel.partyList.collectAsState()
    val votesUiStateOne: VotesUiState by viewModel.districtOneUiState.collectAsState()
    val votesUiStateTwo: VotesUiState by viewModel.districtTwoUiState.collectAsState()
    val votesUiStateThree: VotesUiState by viewModel.districtThreeUiState.collectAsState()


    Column(
        modifier = Modifier.padding(all = 8.dp)
    ) {
        ExposedDropdownMenuBox(
            expanded = isExpanded,
            onExpandedChange = { isExpanded= it && uiState.parties.isNotEmpty() },
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedTextField(
                value = chosenDistrict,
                onValueChange = {},
                placeholder = { Text(text = "Please hoose district") },
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded) },
                colors = ExposedDropdownMenuDefaults.textFieldColors(),
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            )
            ExposedDropdownMenu(
                expanded = isExpanded,
                onDismissRequest = { isExpanded = false },
                modifier = Modifier.fillMaxWidth()
            ) {
                districts.filter { it != chosenDistrict }.forEach {valgtDistrict ->
                    DropdownMenuItem(
                        modifier = Modifier.fillMaxWidth(),
                        text = { Text(text = valgtDistrict, modifier = Modifier.fillMaxWidth()) },
                        onClick = {
                            chosenDistrict = valgtDistrict
                            isExpanded = false
                            /*
                            when(district.indexOf(selectedDistrict)) {

                                0 -> homeScreenViewModel.getPartyVotes(District.ONE)
                                1 -> homeScreenViewModel.getPartyVotes(District.TWO)
                                2 -> homeScreenViewModel.getPartyVotes(District.THREE)

                            }

                             */
                        }
                    )
                }
            }
        }
        VoteList(viewModel = viewModel, district = chosenDistrict)

        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(uiState.parties) {partyInfo ->
                AlpacaCard(
                    party = partyInfo,
                    navController = navController
                )
            }
        }
    }

}

@Composable
fun getColor(color: String): Color {
    return Color(android.graphics.Color.parseColor(color))
}