package no.uio.ifi.in2000.victoryk.oblig2.data.votes

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import no.uio.ifi.in2000.victoryk.oblig2.model.votes.District
import no.uio.ifi.in2000.victoryk.oblig2.model.votes.DistrictVotes
import no.uio.ifi.in2000.victoryk.oblig2.model.votes.IndividualVotes


class IndividualVotesDataSource() {
    private val district1 = "https://www.uio.no/studier/emner/matnat/ifi/IN2000/v24/obligatoriske-oppgaver/district1.json"
    private val district2 = "https://www.uio.no/studier/emner/matnat/ifi/IN2000/v24/obligatoriske-oppgaver/district2.json"


    private val client = HttpClient() {
        install(ContentNegotiation) {
            json(Json)
        }
    }

    suspend fun getVotesDistrict1(): List<DistrictVotes> {
        val responseVotes: List<IndividualVotes> = try {
            client.get(district1).body()
        } catch (e: Exception) {
            emptyList()
        }

        return listOf("1", "2", "3", "4").map { id ->
            DistrictVotes(District.ONE, id, responseVotes.count { it.id == id } )

        }
    }

    suspend fun getVotesDistrict2(): List<DistrictVotes> {
        val responseVotes: List<IndividualVotes> = try {
            client.get(district2).body()
        } catch (e: Exception) {
            emptyList()
        }

        return listOf("1", "2", "3", "4").map { id ->
            DistrictVotes(District.TWO, id, responseVotes.count { it.id == id } )

        }
    }
}