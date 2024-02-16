package no.uio.ifi.in2000.victoryk.oblig2.ui.home


import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import no.uio.ifi.in2000.victoryk.oblig2.data.alpacas.AlpacaPartiesRepository
import no.uio.ifi.in2000.victoryk.oblig2.model.alpacas.PartyInfo


data class HomeUiState(
    val homeUiState: List<PartyInfo> = listOf() // Placeholder klasse her
)

class HomeViewModel : ViewModel() {

    // UI
    private val _homeUiState = MutableStateFlow(HomeUiState())
    val homeUiState: StateFlow<HomeUiState> = _homeUiState.asStateFlow()



    // Repository

    init {
        viewModelScope.launch {
            val parties = AlpacaPartiesRepository().getAllParties().toMutableStateList()
        }
    }
}


