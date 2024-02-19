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

data class PartyScreenUiState(
    val party: List<PartyInfo> = emptyList()
)

class PartyViewModel(private val partyId: String): ViewModel() {
    private val repo: AlpacaPartiesRepository = AlpacaPartiesRepository()
    private val _uiState = MutableStateFlow(PartyScreenUiState())
    val uiState: StateFlow<PartyScreenUiState> = _uiState.asStateFlow()


    init {
        getPartyInfo(partyId)
    }

    private fun getPartyInfo(id: String) {
        viewModelScope.launch {
            _uiState.update {state ->
                val party = repo.getById(id)
                state.copy(party = party)
            }
        }
    }

}