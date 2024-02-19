package no.uio.ifi.in2000.victoryk.oblig2.data.alpacas

import no.uio.ifi.in2000.victoryk.oblig2.model.alpacas.PartyInfo

class AlpacaPartiesRepository() {
    private val dataSource: AlpacaPartiesDataSource = AlpacaPartiesDataSource()
    suspend fun getParties(): List<PartyInfo> {
        return dataSource.getPartiesFromUrl()
    }

    suspend fun getById(id: String): List<PartyInfo> {
        return dataSource.getPartiesFromUrl().filter { it.id == id }
    }
}
