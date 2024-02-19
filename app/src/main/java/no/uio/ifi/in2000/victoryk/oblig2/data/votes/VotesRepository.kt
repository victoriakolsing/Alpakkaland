package no.uio.ifi.in2000.victoryk.oblig2.data.votes

import no.uio.ifi.in2000.victoryk.oblig2.model.votes.District
import no.uio.ifi.in2000.victoryk.oblig2.model.votes.DistrictVotes

class VotesRepository {
    private val individualVotes = IndividualVotesDataSource()
    private val aggregatedVotes = AggregatedVotesDataSource()

    suspend fun getVotesOne(): List<DistrictVotes> {
        return individualVotes.getVotesDistrict1()
    }

    suspend fun getVotesTwo(): List<DistrictVotes> {
        return individualVotes.getVotesDistrict2()
    }

    suspend fun getVotesThree(): List<DistrictVotes> {
        return aggregatedVotes.getAggregatedVotes()
    }

    suspend fun getAllVotes(district: District): List<DistrictVotes> {
        val districtOne: List<DistrictVotes> = getVotesOne()
        val districtTwo: List<DistrictVotes> = getVotesTwo()
        val districtThree: List<DistrictVotes> = getVotesThree()

        return when(district) {
            District.ONE -> districtOne
            District.TWO -> districtTwo
            District.THREE -> districtThree
        }
    }

}