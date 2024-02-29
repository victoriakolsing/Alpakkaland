package no.uio.ifi.in2000.victoryk.oblig2.ui.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.HorizontalDivider
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
import androidx.compose.ui.unit.dp
import no.uio.ifi.in2000.victoryk.oblig2.Blush
import no.uio.ifi.in2000.victoryk.oblig2.SuperLightPink

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VoteList(
    viewModel: HomeViewModel,
) {
    var isExpanded by remember { mutableStateOf(false) }
    var chosenDistrict by remember { mutableStateOf("") }
    val voteUiState by viewModel.voteState.collectAsState()
    var votes = emptyMap<String, Int>()

    when (chosenDistrict) {
        "1" -> {
            votes = getVotes(voteUiState, "1")
        }
        "2" -> {
            votes = getVotes(voteUiState, "2")
        }
        "3" -> {
            votes = getVotes(voteUiState, "3")
        }
    }


    ExposedDropdownMenuBox(
        expanded = isExpanded,
        onExpandedChange = { isExpanded = it },
        modifier = Modifier.fillMaxWidth()
    ) {

        OutlinedTextField(
            value = chosenDistrict,
            onValueChange = {},
            placeholder = { Text(text = "Please choose district") },
            readOnly = true,
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded) },
            colors = ExposedDropdownMenuDefaults.textFieldColors(
                unfocusedContainerColor = SuperLightPink,
                focusedContainerColor = SuperLightPink,
            ),
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth()
                .padding(top = 16.dp),
        )
        ExposedDropdownMenu(
            expanded = isExpanded,
            onDismissRequest = { isExpanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            DropdownMenuItem(
                modifier = Modifier.fillMaxWidth(),
                text = {
                    Text(
                        text = "District 1",
                        modifier = Modifier.fillMaxWidth(),
                        color = Blush
                    ) },
                onClick = { chosenDistrict = "1"}
            )
            DropdownMenuItem(
                modifier = Modifier.fillMaxWidth(),
                text = {
                    Text(
                        text = "District 2",
                        modifier = Modifier.fillMaxWidth(),
                        color = Blush
                    ) },
                onClick = { chosenDistrict = "2" }
            )
            DropdownMenuItem(
                modifier = Modifier.fillMaxWidth(),
                text = {
                    Text(
                        text = "District 3",
                        modifier = Modifier.fillMaxWidth(),
                        color = Blush
                    ) },
                onClick = { chosenDistrict = "3" }
            )
        }
    }

    LazyColumn(contentPadding = PaddingValues(all = 8.dp)) {
        item {
            Row() {
                Text(text = "Party")
                Spacer(modifier = Modifier
                    .weight(1f)
                    .height(20.dp))
                Text(text = "Vote Count")
            }
            HorizontalDivider(color = SuperLightPink)
            Row(
                verticalAlignment = Alignment.Top
            ) {
                //Text(text = votes.keys.joinToString("\n"))
                Text(text = "get")
                Spacer(modifier = Modifier
                    .weight(1f)
                    .height(20.dp))
                //Text(text = votes.values.joinToString("\n"))
            }
        }


    }
}


@Composable
fun getVotes(voteList: VotesUiState, district: String): Map<String, Int> {
    var voteMap: Map<String, Int> = emptyMap<String, Int>()

    return when (district) {
        "1" -> {
            voteList.districtOneVotes
        }

        "2" -> {
            voteList.districtTwoVotes
        }

        "3" -> {
            voteList.districtThreeVotes
        }

        else -> {
            return emptyMap()
        }
    }
}