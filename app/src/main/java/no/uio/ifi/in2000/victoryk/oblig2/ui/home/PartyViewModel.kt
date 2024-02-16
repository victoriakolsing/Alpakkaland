package no.uio.ifi.in2000.victoryk.oblig2.ui.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import no.uio.ifi.in2000.victoryk.oblig2.data.alpacas.AlpacaPartiesRepository
import no.uio.ifi.in2000.victoryk.oblig2.model.alpacas.PartyInfo

data class PartyUiState(
    val party: PartyInfo? = null // nullable fordi det kan forsøkes å hente et parti som ikke finnes
)

class PartyViewModel : ViewModel() {
    private val repository: AlpacaPartiesRepository = AlpacaPartiesRepository()
    private val _uiState = MutableStateFlow(PartyUiState())
    val uiState: StateFlow<PartyUiState> = _uiState.asStateFlow()

    var id by mutableStateOf("")
    var name by mutableStateOf("")
    var leader by mutableStateOf("")
    var img by mutableStateOf("")
    var color by mutableStateOf("")
    var description by mutableStateOf("")


    fun getPartyInfo(partyId: String) {
        viewModelScope.launch {
            val partyInfo = repository.getPartyByID(partyId)
            _uiState.value = _uiState.value.copy(party = partyInfo)


            // Ville egt hatt egne funksjoner for å håndtere og bearbeide disse (f.eks. opprette farge for color String)
            // men prioriterer i nåværende øyeblikk å få noe ferdig
            id = partyInfo.id
            name = partyInfo.name
            leader = partyInfo.leader
            img = partyInfo.img
            color = partyInfo.color
            description = partyInfo.description
        }
    }
}