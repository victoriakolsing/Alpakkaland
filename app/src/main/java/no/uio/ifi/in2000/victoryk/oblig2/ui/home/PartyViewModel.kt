package no.uio.ifi.in2000.victoryk.oblig2.ui.home

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import no.uio.ifi.in2000.victoryk.oblig2.data.alpacas.AlpacaPartiesRepository
import no.uio.ifi.in2000.victoryk.oblig2.model.alpacas.PartyInfo

class PartyViewModel(savedStateHandle: SavedStateHandle): ViewModel() {
    private val repo: AlpacaPartiesRepository = AlpacaPartiesRepository()

    private val partyId: String = checkNotNull(savedStateHandle["partyId"])
    private val partyInfo: Flow<PartyInfo> = repo.getById(partyId)

}