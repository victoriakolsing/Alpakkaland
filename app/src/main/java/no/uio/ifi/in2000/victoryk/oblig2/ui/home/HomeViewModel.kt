package no.uio.ifi.in2000.victoryk.oblig2.ui.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import no.uio.ifi.in2000.victoryk.oblig2.data.alpacas.AlpacaPartiesRepository
import no.uio.ifi.in2000.victoryk.oblig2.model.alpacas.PartyInfo

class HomeViewModel(private val repo: AlpacaPartiesRepository): ViewModel() {

    // STUPID STATE HOLDERS
    private val _partyList: MutableState<List<PartyInfo>> = mutableStateOf(emptyList())
    val partyList: State<List<PartyInfo>> = _partyList

    // FETCH DATA FROM REPOSITORY
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