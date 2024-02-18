package no.uio.ifi.in2000.victoryk.oblig2.data.alpacas

import no.uio.ifi.in2000.victoryk.oblig2.model.alpacas.PartyInfo

// Et repo som får data fra AlpacaPartiesDataSource
// og som tilbyr en metode ViewModel-en kan bruke for å få informasjon om partiene.
// Denne dataen skal være på formatet List<PartyInfo>.

class AlpacaPartiesRepository() {
    private val dataSource: AlpacaPartiesDataSource = AlpacaPartiesDataSource()
    suspend fun getParties(): List<PartyInfo> {
        val array = dataSource.fml();
        return array.toList() // trenger man toList? eller?
    }

/*
    suspend fun getById(id: Int): PartyInfo? {
        val partyList = dataSource.fml()
        return partyList.find { it.id.toInt() == id }
    }
    */
}
