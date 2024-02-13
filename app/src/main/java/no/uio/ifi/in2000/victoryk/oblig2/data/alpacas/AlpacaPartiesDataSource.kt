package no.uio.ifi.in2000.victoryk.oblig2.data.alpacas

import android.util.Log
import io.ktor.client.*
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.coroutineScope
import no.uio.ifi.in2000.victoryk.oblig2.model.alpacas.PartyInfo

// Henter og deserialiserer responsen fra https://www.uio.no/studier/emner/matnat/ifi/IN2000/v24/obligatoriske-oppgaver/alpacaparties.json
// og returnerer en liste av PartyInfo-objekter

private const val BASE_URL =
    "https://www.uio.no/studier/emner/matnat/ifi/IN2000/v24/obligatoriske-oppgaver/alpacaparties.json"

class AlpacaPartiesDataSource {
    suspend fun getFromURL(): List<PartyInfo> = coroutineScope {
        val client = HttpClient() {
            install(ContentNegotiation) {
                json()
            }
        }
        val response: List<PartyInfo> = client.get(BASE_URL).body()
        return@coroutineScope response
    }
}