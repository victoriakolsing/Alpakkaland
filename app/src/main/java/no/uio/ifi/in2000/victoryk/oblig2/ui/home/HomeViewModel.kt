package no.uio.ifi.in2000.victoryk.oblig2.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import no.uio.ifi.in2000.victoryk.oblig2.data.alpacas.AlpacaPartiesRepository
import no.uio.ifi.in2000.victoryk.oblig2.model.alpacas.PartyInfo
import no.uio.ifi.in2000.victoryk.oblig2.model.votes.District

data class HomeUiState(
    val parties: List<PartyInfo> = emptyList()
)

data class VotesUiState(
    val districtOneVotes: Map<String, Int> = emptyMap(),
    val districtTwoVotes: Map<String, Int> = emptyMap(),
    val districtThreeVotes: Map<String, Int> = emptyMap()
)


class HomeViewModel(): ViewModel() {
    private val repo: AlpacaPartiesRepository = AlpacaPartiesRepository()

    private val _partyList = MutableStateFlow(HomeUiState())
    val partyList: StateFlow<HomeUiState> = _partyList.asStateFlow()

    private val _voteState = MutableStateFlow(VotesUiState())
    val voteState: StateFlow<VotesUiState> = _voteState.asStateFlow()

    init {
        loadPartyList()
        getVotes()
    }

    private fun loadPartyList() {
        viewModelScope.launch(Dispatchers.IO) {
            _partyList.update { state ->
                val parties = repo.getParties()
                state.copy(parties = parties)
            }
        }
    }
    fun getVotes() {
        viewModelScope.launch {
            _voteState.update { state ->
                val votes1 = repo.getVotes(District.ONE)
                val votes2 = repo.getVotes(District.TWO)
                val votes3 = repo.getVotes(District.THREE)
                state.copy(districtOneVotes = votes1, districtTwoVotes = votes2, districtThreeVotes = votes3)
            }
        }
    }
}