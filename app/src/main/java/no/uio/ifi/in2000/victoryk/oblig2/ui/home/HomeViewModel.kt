package no.uio.ifi.in2000.victoryk.oblig2.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import no.uio.ifi.in2000.victoryk.oblig2.data.alpacas.AlpacaPartiesRepository
import no.uio.ifi.in2000.victoryk.oblig2.model.alpacas.PartyInfo

// gir type mismatch i getPartyList()
/*
data class partyList (
    val parties: List<PartyInfo> = emptyList()
)
*/


class HomeViewModel(): ViewModel() {

    private val repo: AlpacaPartiesRepository = AlpacaPartiesRepository()

    private val _partyList = MutableStateFlow<List<PartyInfo>>(emptyList())
    val partyList: StateFlow<List<PartyInfo>> = _partyList.asStateFlow()

    private fun getPartyList() {
        viewModelScope.launch {
            _partyList.value = repo.getParties()
        }
    }

    // ON INITIALIZATION
    init {
        getPartyList()
    }

}