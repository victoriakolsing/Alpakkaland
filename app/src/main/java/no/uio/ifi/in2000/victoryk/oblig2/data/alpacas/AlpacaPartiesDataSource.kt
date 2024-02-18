package no.uio.ifi.in2000.victoryk.oblig2.data.alpacas

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import no.uio.ifi.in2000.victoryk.oblig2.model.alpacas.PartyInfo

class AlpacaPartiesDataSource {
    private val url =
        "https://www.uio.no/studier/emner/matnat/ifi/IN2000/v24/obligatoriske-oppgaver/alpacaparties.json"

    private val client = HttpClient() {
        install(ContentNegotiation) {
            json(Json)
        }
    }
    suspend fun fml(): List<PartyInfo> {
        val response = client.get(url).toString()
        val typeToken = object : TypeToken<List<PartyInfo>>() {}.type
        return Gson().fromJson(response, typeToken)
    }
}

