package no.uio.ifi.in2000.victoryk.oblig2.data.votes

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import no.uio.ifi.in2000.victoryk.oblig2.model.votes.AggregatedVotes
import no.uio.ifi.in2000.victoryk.oblig2.model.votes.District
import no.uio.ifi.in2000.victoryk.oblig2.model.votes.DistrictVotes

data class ApiResults(
    val aggregatedVotes: List<AggregatedVotes>
)


class AggregatedVotesDataSource {
    private val url =
        "https://www.uio.no/studier/emner/matnat/ifi/IN2000/v24/obligatoriske-oppgaver/district3.json"

    private val client = HttpClient() {
        install(ContentNegotiation) {
            json(Json)
            Log.i("YEE", "Client started")
        }
    }

    suspend fun getAggregatedVotes(): List<DistrictVotes> {
        val response: ApiResults =
            try {
                client.get(url).body()
            } catch (e: Exception)  {
                ApiResults(listOf())
            }
        return response.aggregatedVotes.map {
            DistrictVotes(District.THREE, it.partyId, it.votes)
        }
    }
}
