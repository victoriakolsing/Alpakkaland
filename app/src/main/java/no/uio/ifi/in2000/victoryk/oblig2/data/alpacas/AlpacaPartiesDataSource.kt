package no.uio.ifi.in2000.victoryk.oblig2.data.alpacas

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import no.uio.ifi.in2000.victoryk.oblig2.model.alpacas.PartyInfo

// Henter og deserialiserer responsen fra https://www.uio.no/studier/emner/matnat/ifi/IN2000/v24/obligatoriske-oppgaver/alpacaparties.json
// og returnerer en liste av PartyInfo-objekter

private const val BASE_URL =
    "https://www.uio.no/studier/emner/matnat/ifi/IN2000/v24/obligatoriske-oppgaver/alpacaparties.json"

class AlpacaPartiesDataSource {
    suspend fun getParties(): List<PartyInfo> {
        val client = HttpClient() {
            install(ContentNegotiation) {
                json()
            }
        }

        // FIKS COIL FOR Å HENTE BILDER
        // uhh returnerer denne hele teksten som ett objekt (liste med ett element)?
        return Json.decodeFromString<List<PartyInfo>>(client.get(BASE_URL).body<String>())
    }
}