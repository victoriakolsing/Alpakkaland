package no.uio.ifi.in2000.victoryk.oblig2.ui.home

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


// Skal bruke viewModelScope for å
// hente data asynkront fra AlpacaPartiesRepository og oppdatere UI-staten


class HomeViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(HomeScreen())
    val uiState: StateFlow<HomeScreen> = _uiState.asStateFlow()

}