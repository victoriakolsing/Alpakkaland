package no.uio.ifi.in2000.victoryk.oblig2.data.alpacas

import android.util.Log
import io.ktor.client.*
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import no.uio.ifi.in2000.victoryk.oblig2.model.alpacas.PartyInfo

// Henter og deserialiserer responsen fra https://www.uio.no/studier/emner/matnat/ifi/IN2000/v24/obligatoriske-oppgaver/alpacaparties.json
// og returnerer en liste av PartyInfo-objekter

suspend fun fetchParties(): List<PartyInfo> {
    val client = HttpClient() {
        install(ContentNegotiation) {
            json()
        }
    }
    val response: List<PartyInfo> = client.get("https://www.uio.no/studier/emner/matnat/ifi/IN2000/v24/obligatoriske-oppgaver/alpacaparties.json").body()
    return response
}

