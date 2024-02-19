package no.uio.ifi.in2000.victoryk.oblig2.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import no.uio.ifi.in2000.victoryk.oblig2.Blush

@Composable
fun VoteList(
    viewModel: HomeViewModel,
    district: String
) {
    val votesUiStateOne: VotesUiState by viewModel.districtOneUiState.collectAsState()
    val votesUiStateTwo: VotesUiState by viewModel.districtOneUiState.collectAsState()
    val votesUiStateThree: VotesUiState by viewModel.districtOneUiState.collectAsState()

    val partyUiState: HomeUiState by viewModel.partyList.collectAsState()


    Column( modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row {
            Text(
                text = "Parties",
                fontWeight = FontWeight.Bold,
                color = Blush
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Votes per party",
                fontWeight = FontWeight.Bold,
                color = Blush
            )
            if (district == "District 1") {
                val parties = partyUiState.parties
                var counter = 0
                votesUiStateOne.districtOneVotes.let { listVotes ->
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
                votesUiStateTwo.districtOneVotes.let { listVotes ->
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
                votesUiStateThree.districtOneVotes.let { listVotes ->
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
