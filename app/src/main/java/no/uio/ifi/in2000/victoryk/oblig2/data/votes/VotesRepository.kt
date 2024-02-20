package no.uio.ifi.in2000.victoryk.oblig2.data.votes

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import no.uio.ifi.in2000.victoryk.oblig2.model.votes.DistrictVotes

class VotesRepository {
    private val individualVotesDataSource = IndividualVotesDataSource()
    private val aggregatedVotesDataSource = AggregatedVotesDataSource()

    private val districtOneVotes = MutableStateFlow<List<DistrictVotes>>(listOf())
    private val districtTwoVotes = MutableStateFlow<List<DistrictVotes>>(listOf())
    private val districtThreeVotes = MutableStateFlow<List<DistrictVotes>>(listOf())

    fun updatePartyVotes() {
        districtOneVotes.update {
            individualVotesDataSource.getVotesOne()
        }
        districtTwoVotes.update {
            individualVotesDataSource.getVotesTwo()
        }
        districtThreeVotes.update {
            aggregatedVotesDataSource.getAggregatedVotesThree()
        }
    }

}