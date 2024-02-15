package no.uio.ifi.in2000.victoryk.oblig2.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import no.uio.ifi.in2000.victoryk.oblig2.data.alpacas.AlpacaPartiesRepository
import no.uio.ifi.in2000.victoryk.oblig2.model.alpacas.PartyInfo


// 1. Skal bruke viewModelScope for å hente data asynkront fra AlpacaPartiesRepository, og
// 2. oppdatere UI-staten

data class HomeUiState ( // Model class for state UI
    val parties: List<PartyInfo> = listOf()
)

class HomeViewModel : ViewModel() {

    private val repository: AlpacaPartiesRepository = AlpacaPartiesRepository()

    // StateFlow is a data holder observable flow that emits the current and new state updates.
    // Its value property reflects the current state value.
    // To update state and send it to the flow,
    // assign a new value to the value property of the MutableStateFlow class.

    private val _homeUiState = MutableStateFlow(HomeUiState())
    val homeUiState: StateFlow<HomeUiState> = _homeUiState.asStateFlow()

    init {
        viewModelScope.launch {
            repository.getParties()
        }
    }
}