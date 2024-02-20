package no.uio.ifi.in2000.victoryk.oblig2.data.votes

import no.uio.ifi.in2000.victoryk.oblig2.model.votes.DistrictVotes

class VotesRepository {
    private val individualVotes = IndividualVotesDataSource()
    private val aggregatedVotes = AggregatedVotesDataSource()

    suspend fun getIndividualVotesOne() : List<DistrictVotes> {
        return individualVotes.getVotesOne()
    }

    suspend fun getIndividualVotesTwo() : List<DistrictVotes> {
        return individualVotes.getVotesTwo()
    }

    suspend fun getAggregatedVotes(): List<DistrictVotes> {
        return aggregatedVotes.getAggregatedVotesThree()
    }

}