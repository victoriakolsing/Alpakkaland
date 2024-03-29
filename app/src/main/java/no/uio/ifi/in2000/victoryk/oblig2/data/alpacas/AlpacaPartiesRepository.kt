package no.uio.ifi.in2000.victoryk.oblig2.data.alpacas

import no.uio.ifi.in2000.victoryk.oblig2.model.alpacas.PartyInfo

// Et repo som får data fra AlpacaPartiesDataSource
// og som tilbyr en metode ViewModel-en kan bruke for å få informasjon om partiene.
// Denne dataen skal være på formatet List<PartyInfo>.


class AlpacaPartiesRepository(private val partyDataSource: AlpacaPartiesDataSource = AlpacaPartiesDataSource()) {
    suspend fun getParties(): List<PartyInfo> {
        return partyDataSource.getParties()
    }

    suspend fun getPartyByID(partyId: String): PartyInfo {
        return getParties()[partyId.toInt() - 1]
    }
}