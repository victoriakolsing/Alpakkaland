package no.uio.ifi.in2000.victoryk.oblig2.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun VoteList(
    viewModel: HomeViewModel,
    district: String
) {
    val votesUiStateOne: VotesUiState by viewModel.districtOneUiState.collectAsState()
    val votesUiStateTwo: VotesUiState by viewModel.districtOneUiState.collectAsState()
    val votesUiStateThree: VotesUiState by viewModel.districtOneUiState.collectAsState()

    val partyUiState: HomeUiState by viewModel.partyList.collectAsState()

    val votesUiState = when (district) {
        "District 1" -> viewModel.districtOneUiState.collectAsState()
        "District 2" -> viewModel.districtTwoUiState.collectAsState()
        "District 3" -> viewModel.districtThreeUiState.collectAsState()
        else -> viewModel.districtOneUiState.collectAsState() // Default or handle error
    }.value

    Column {
        Row {
            if (district == "District 1") {
                val parties = partyUiState.parties
                var counter = 0
                votesUiState.districtOneVotes.let { listVotes ->
                    listVotes.forEach { districtVotes ->
                        Row(modifier = Modifier.padding(8.dp)){
                            Text(text = parties[counter].name)
                            Spacer(modifier = Modifier.padding(8.dp))
                            Text(text = districtVotes.numberOfVotesForParty.toString())
                            counter++
                        }
                    }
                }
            }

            if (district == "District 2") {
                val parties = partyUiState.parties
                var counter = 0
                votesUiState.districtOneVotes.let { listVotes ->
                    listVotes.forEach { districtVotes ->
                        Row(modifier = Modifier.padding(8.dp)) {
                            Text(text = parties[counter].name)
                            Spacer(modifier = Modifier.padding(8.dp))
                            Text(text = districtVotes.numberOfVotesForParty.toString())
                            counter++
                        }
                    }
                }
            }

            if (district == "District 3") {
                val parties = partyUiState.parties
                var counter = 0
                votesUiState.districtOneVotes.let { listVotes ->
                    listVotes.forEach { districtVotes ->
                        Row(modifier = Modifier.padding(8.dp)) {
                            Text(text = parties[counter].name)
                            Spacer(modifier = Modifier.padding(8.dp))
                            Text(text = districtVotes.numberOfVotesForParty.toString())
                            counter++
                        }
                    }
                }
            }
        }
    }
}
