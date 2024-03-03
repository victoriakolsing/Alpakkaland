package no.uio.ifi.in2000.victoryk.oblig2.data.votes

import no.uio.ifi.in2000.victoryk.oblig2.model.votes.District
import no.uio.ifi.in2000.victoryk.oblig2.model.votes.DistrictVotes

class VotesRepository {
    private val individualVotes = IndividualVotesDataSource()
    private val aggregatedVotes = AggregatedVotesDataSource()

    private suspend fun getIndividualVotesOne() : List<DistrictVotes> {
        return individualVotes.getVotesOne()
    }

    suspend fun getIndividualVotesTwo() : List<DistrictVotes> {
        return individualVotes.getVotesTwo()
    }

    suspend fun getAggregatedVotes(): List<DistrictVotes> {
        return aggregatedVotes.getAggregatedVotesThree()
    }

    suspend fun getDistrictVotes(district: District): List<DistrictVotes> {
        val districtOne: List<DistrictVotes> = getIndividualVotesOne()
        val districtTwo: List<DistrictVotes> = getIndividualVotesTwo()
        val districtThree: List<DistrictVotes> = getAggregatedVotes()

        return when(district) {
            District.ONE -> districtOne
            District.TWO -> districtTwo
            District.THREE -> districtThree
        }

    }
}