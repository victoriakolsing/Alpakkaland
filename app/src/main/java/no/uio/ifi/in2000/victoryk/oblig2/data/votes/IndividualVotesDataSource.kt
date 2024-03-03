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
    suspend fun getVotesOne(): List<DistrictVotes> {
        val votes: List<IndividualVotes> =
            try {
                client.get(district1).body()
            } catch (e: Exception) {
                emptyList()
            }

        /* val countVotes = individualVotes.groupingBy { it.id }.eachCount().toMap()

        val votes1 = DistrictVotes(District.ONE, "1", countVotes.getValue("1"))
        val votes2 = DistrictVotes(District.ONE, "2", countVotes.getValue("2"))
        val votes3 = DistrictVotes(District.ONE, "3", countVotes.getValue("3"))
        val votes4 = DistrictVotes(District.ONE, "4", countVotes.getValue("4"))


        return listOf(votes1, votes2, votes3, votes4)
        */

        return listOf("1", "2", "3", "4").map {id ->
            DistrictVotes(District.ONE, id, votes.count {it.id == id})
        }
    }

    suspend fun getVotesTwo(): List<DistrictVotes> {
        val votes: List<IndividualVotes> =
            try {
                client.get(district2).body()
            } catch (e: Exception) {
                emptyList()
            }

       /* val countVotes = individualVotes.groupingBy { it.id }.eachCount().toMap()

        val votes1 = DistrictVotes(District.TWO, "1", countVotes.getValue("1"))
        val votes2 = DistrictVotes(District.TWO, "2", countVotes.getValue("2"))
        val votes3 = DistrictVotes(District.TWO, "3", countVotes.getValue("3"))
        val votes4 = DistrictVotes(District.TWO, "4", countVotes.getValue("4"))


        return listOf(votes1, votes2, votes3, votes4)
        */

        return listOf("1", "2", "3", "4").map {id ->
            DistrictVotes(District.TWO, id, votes.count {it.id == id})

        }
    }

   }
