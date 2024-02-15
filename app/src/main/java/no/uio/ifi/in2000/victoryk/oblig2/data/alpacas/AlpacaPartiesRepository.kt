package no.uio.ifi.in2000.victoryk.oblig2.data.alpacas

import no.uio.ifi.in2000.victoryk.oblig2.model.alpacas.PartyInfo

// Et repo som får data fra AlpacaPartiesDataSource
// og som tilbyr en metode ViewModel-en kan bruke for å få informasjon om partiene.
// Denne dataen skal være på formatet List<PartyInfo>.

interface AlpacaPartiesRepository {
    suspend fun getParties(): List<PartyInfo>
    suspend fun getParyByID(partyId: String): PartyInfo?
}

class NetworkAlpacaRepo(
    private val partyDataSource: AlpacaPartiesDataSource = AlpacaPartiesDataSource()
): AlpacaPartiesRepository {
    override suspend fun getParties(): List<PartyInfo> {
        return partyDataSource.getParties()
    }

    override suspend fun getParyByID(partyId: String): PartyInfo? {
        return partyDataSource.getParties().firstOrNull { it.id == partyId }
    }
}