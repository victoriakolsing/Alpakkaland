package no.uio.ifi.in2000.victoryk.oblig2.data.alpacas

import kotlinx.coroutines.coroutineScope
import no.uio.ifi.in2000.victoryk.oblig2.model.alpacas.PartyInfo
import no.uio.ifi.in2000.victoryk.oblig2.data.alpacas.AlpacaPartiesDataSource

// Et repo som får data fra AlpacaPartiesDataSource
// og som tilbyr en metode ViewModel-en kan bruke for å få informasjon om partiene.
// Denne dataen skal være på formatet List<PartyInfo>.

class AlpacaPartiesRepository() {
    suspend fun loadParties(): List<PartyInfo> {
        return AlpacaPartiesDataSource().getFromURL()
    }
}
