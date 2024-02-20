package no.uio.ifi.in2000.victoryk.oblig2.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import no.uio.ifi.in2000.victoryk.oblig2.data.alpacas.AlpacaPartiesRepository
import no.uio.ifi.in2000.victoryk.oblig2.model.alpacas.PartyInfo
import no.uio.ifi.in2000.victoryk.oblig2.model.votes.DistrictVotes

data class HomeUiState(
    val parties: List<PartyInfo> = emptyList()
)

data class VotesUiState(
    val districtOneVotes: List<DistrictVotes> = listOf(),
    val districtTwoVotes: List<DistrictVotes> = listOf(),
    val districtThreeVotes: List<DistrictVotes> = listOf()
)


class HomeViewModel(): ViewModel() {
    private val repo: AlpacaPartiesRepository = AlpacaPartiesRepository()
    private val _partyList = MutableStateFlow(HomeUiState())
    val partyList: StateFlow<HomeUiState> = _partyList.asStateFlow()

    private fun loadPartyList() {
        viewModelScope.launch {
            _partyList.update { state ->
                val parties = repo.getParties()
                state.copy(parties = parties)
            }
        }
    }

    init {
        viewModelScope.launch {
            repo.getParties()
        }
    }

    // ON INITIALIZATION
    init {
        loadPartyList()
    }
}