package no.uio.ifi.in2000.victoryk.oblig2.data.votes

import no.uio.ifi.in2000.victoryk.oblig2.model.votes.District
import no.uio.ifi.in2000.victoryk.oblig2.model.votes.DistrictVotes

class VotesRepository {
    private val individualVotes = IndividualVotesDataSource()
    private val aggregatedVotes = AggregatedVotesDataSource()

    suspend fun getVotes(district: District): List<DistrictVotes> {
        return when (district) {
            District.ONE -> {
                individualVotes.getVotesOne()
            }
            District.TWO -> {
                individualVotes.getVotesTwo()
            }
            District.THREE -> {
                aggregatedVotes.getAggregatedVotesThree()
            }
        }
    }
}