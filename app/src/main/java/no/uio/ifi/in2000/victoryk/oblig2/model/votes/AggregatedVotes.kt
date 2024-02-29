package no.uio.ifi.in2000.victoryk.oblig2.model.votes

import kotlinx.serialization.Serializable

@Serializable

data class AggregatedVotes(
    val partyId: String,
    val votes: Int
)

