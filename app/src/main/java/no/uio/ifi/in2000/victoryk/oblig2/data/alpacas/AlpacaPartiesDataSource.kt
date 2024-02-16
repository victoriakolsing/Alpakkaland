package no.uio.ifi.in2000.victoryk.oblig2.data.alpacas

import no.uio.ifi.in2000.victoryk.oblig2.model.alpacas.PartyInfo

// Henter og deserialiserer responsen fra PartyInfo
// og returnerer en liste av PartyInfo-objekter



class AlpacaPartiesDataSource {

    val partyInfo: List<PartyInfo> = listOf()
    // BYTT UT listOf() MED RESULTAT FRA API-KALL


    suspend fun getPartyInfo() : List<PartyInfo> {
        return partyInfo
    }

}

