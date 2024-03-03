package no.uio.ifi.in2000.victoryk.oblig2.data.alpacas

import no.uio.ifi.in2000.victoryk.oblig2.data.votes.VotesRepository
import no.uio.ifi.in2000.victoryk.oblig2.model.alpacas.PartyInfo
import no.uio.ifi.in2000.victoryk.oblig2.model.votes.District
import no.uio.ifi.in2000.victoryk.oblig2.model.votes.DistrictVotes

class AlpacaPartiesRepository() {
    private val dataSource: AlpacaPartiesDataSource = AlpacaPartiesDataSource()
    private val votesRepo: VotesRepository = VotesRepository()
    suspend fun getParties(): List<PartyInfo> {
        return dataSource.getPartiesFromUrl()
    }

    suspend fun getById(id: String): List<PartyInfo> {
        return dataSource.getPartiesFromUrl().filter { it.id == id }
    }

    suspend fun getVotes(district: District): Map<String, Int> {
        val parties: List<String> = listOf("AlpacaNorth", "AlpacaSouth", "AlpacaEast", "AlpacaWest")
        val vote: List<DistrictVotes> = votesRepo.getDistrictVotes(district)
        val mapped: List<Int> = vote.map { it.votes }

        return parties.zip(mapped).toMap()
    }
}
