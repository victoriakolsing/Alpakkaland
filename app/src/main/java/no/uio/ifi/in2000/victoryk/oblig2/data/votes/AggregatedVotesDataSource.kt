package no.uio.ifi.in2000.victoryk.oblig2.data.votes

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import no.uio.ifi.in2000.victoryk.oblig2.model.votes.AggregatedVotes
import no.uio.ifi.in2000.victoryk.oblig2.model.votes.District
import no.uio.ifi.in2000.victoryk.oblig2.model.votes.DistrictVotes

data class AggregatedVotes (
    val aggregatedVotes: List<AggregatedVotes>
)


class AggregatedVotesDataSource {
    private val url =
        "https://www.uio.no/studier/emner/matnat/ifi/IN2000/v24/obligatoriske-oppgaver/district3.json"

    private val client = HttpClient() {
        install(ContentNegotiation) {
            json(Json)
        }
    }

    fun getAggregatedVotesThree(): List<DistrictVotes> {
        val partiesVote: List<AggregatedVotes>
        runBlocking {
            partiesVote = try {
                client.get(url).body()
            } catch (e: Exception) {
                emptyList()
            }
        }
        return partiesVote.map {
            DistrictVotes(District.THREE, it.partyId, it.votes)
        }
    }
}
