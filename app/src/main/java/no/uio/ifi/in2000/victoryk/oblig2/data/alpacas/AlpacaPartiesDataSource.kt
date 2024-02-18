package no.uio.ifi.in2000.victoryk.oblig2.data.alpacas

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import no.uio.ifi.in2000.victoryk.oblig2.model.alpacas.PartyInfo

@Serializable
class AlpacaPartiesDataSource {

    private val url = "https://www.uio.no/studier/emner/matnat/ifi/IN2000/v24/obligatoriske-oppgaver/alpacaparties.json"

    suspend fun getPartyInfoList(): List<PartyInfo> {
        val response = HttpClient().get(url)
        return Json.decodeFromString<List<PartyInfo>>(response.toString())
    }

}

