package no.uio.ifi.in2000.victoryk.oblig2.ui.home

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import no.uio.ifi.in2000.victoryk.oblig2.data.alpacas.AlpacaPartiesRepository
import no.uio.ifi.in2000.victoryk.oblig2.model.alpacas.PartyInfo

data class PartyUiState(
    val party: PartyInfo? = null
    // nullable fordi det kan forsøkes å hente et parti som ikke finnes
)

class PartyViewModel : ViewModel() {
    private val repository: AlpacaPartiesRepository = AlpacaPartiesRepository()
    private val _uiState = MutableStateFlow(PartyUiState())
    val uiState: StateFlow<PartyUiState> = _uiState.asStateFlow()

    fun getPartyInfo() {

    }
}