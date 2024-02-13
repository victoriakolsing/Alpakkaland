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


// Skal bruke viewModelScope for å
// hente data asynkront fra AlpacaPartiesRepository og oppdatere UI-staten

// 1. UI state for the Home screen
// 2. huhhhhhnngnggggg

data class HomeUiState (
    val parties: List<PartyInfo> = listOf()
)

class HomeViewModel : ViewModel() {

    private val repository: AlpacaPartiesRepository = AlpacaPartiesRepository()

    private val _homeUiState = MutableStateFlow(HomeUiState())
    val homeUiState: StateFlow<HomeUiState> = _homeUiState.asStateFlow()

    init {
        viewModelScope.launch {
            repository.loadParties()
        }
    }
}