package no.uio.ifi.in2000.victoryk.oblig2.data.votes

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import no.uio.ifi.in2000.victoryk.oblig2.model.votes.District
import no.uio.ifi.in2000.victoryk.oblig2.model.votes.DistrictVotes

@Serializable
data class PartiesD (
    val parties: List<DistrictVotes>
)

class AggregatedVotesDataSource {
    private val url = "https://www.uio.no/studier/emner/matnat/ifi/IN2000/v24/obligatoriske-oppgaver/district3.json"

    private val client = HttpClient() {
        install(ContentNegotiation) {
            json(Json)

        }
    }

    suspend fun getAggregatedVotesThree(): List<DistrictVotes> {
        val response: PartiesD =
            try {
                Log.d("YIKES", "check check found $url")
                client.get(url).body()
            } catch (e: Exception) {
                Log.e("YIKES", "Couldn't fetch data from url $url")
                PartiesD(emptyList())
            }

        /*
        Log.i("response", "parties size: ${response.parties.size}")
        Log.i("tag", "WE GET HERE")

        val partiesVote: List<AggregatedVotes> = response.parties.map {
            AggregatedVotes(it.partyId, it.votes)
        }
        Log.i("YO", "partiesVote size: ${partiesVote.size}") // PartiesVote == 0

        val vote1 = DistrictVotes(District.THREE, partiesVote[0].partyId, partiesVote[0].votes)
        val vote2 = DistrictVotes(District.THREE, partiesVote[1].partyId, partiesVote[1].votes)
        val vote3 = DistrictVotes(District.THREE, partiesVote[2].partyId, partiesVote[2].votes)
        val vote4 = DistrictVotes(District.THREE, partiesVote[3].partyId, partiesVote[3].votes)


        return response.parties
         */
        return response.parties.map {
            DistrictVotes(District.THREE, it.partyId, it.votes)
        }

    }
}
