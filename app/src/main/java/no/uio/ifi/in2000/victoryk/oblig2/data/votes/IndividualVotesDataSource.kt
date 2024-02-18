package no.uio.ifi.in2000.victoryk.oblig2.data.votes

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import kotlinx.serialization.json.Json
import no.uio.ifi.in2000.victoryk.oblig2.model.votes.DistrictVotes

class IndividualVotesDataSource {
    private val district1 = "https://www.uio.no/studier/emner/matnat/ifi/IN2000/v24/obligatoriske-oppgaver/district1.json"
    private val district2 = "https://www.uio.no/studier/emner/matnat/ifi/IN2000/v24/obligatoriske-oppgaver/district2.json"

    private suspend fun getVotes(district: String): DistrictVotes {
        val response = HttpClient().get(district)
        return Json.decodeFromString<DistrictVotes>(response.toString())
    }
    suspend fun getVotesDistrict1(): DistrictVotes {
        return getVotes(district1)
    }
    suspend fun getVotesDistrict2(): DistrictVotes {
        return getVotes(district2)
    }

}