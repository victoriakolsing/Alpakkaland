package no.uio.ifi.in2000.victoryk.oblig2.data.alpacas

import no.uio.ifi.in2000.victoryk.oblig2.model.alpacas.PartyInfo

// Et repo som får data fra AlpacaPartiesDataSource
// og som tilbyr en metode ViewModel-en kan bruke for å få informasjon om partiene.
// Denne dataen skal være på formatet List<PartyInfo>.

class AlpacaPartiesRepository(val dataSource: AlpacaPartiesDataSource) {
    suspend fun getParties(): List<PartyInfo> {
        return dataSource.getPartyInfoList()
    }

    suspend fun getById(id: Int): PartyInfo? {
        val partyList = dataSource.getPartyInfoList()
        return partyList.find { it.id.toInt() == id }
    }
}
