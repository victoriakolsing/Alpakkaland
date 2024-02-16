package no.uio.ifi.in2000.victoryk.oblig2.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import no.uio.ifi.in2000.victoryk.oblig2.data.alpacas.AlpacaPartiesRepository
import no.uio.ifi.in2000.victoryk.oblig2.model.alpacas.PartyInfo

data class HomeUiState ( // Model class for state UI
    val parties: List<PartyInfo> = listOf()
)

class HomeViewModel : ViewModel() {
    private val repository: AlpacaPartiesRepository = AlpacaPartiesRepository()
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            repository.getParties()
        }
    }

    fun getPartyList() {
        viewModelScope.launch {
            val partyList = repository.getParties()
            _uiState.value = _uiState.value.copy(parties = partyList)
        }
    }
}