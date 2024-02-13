package no.uio.ifi.in2000.victoryk.oblig2.data.alpacas

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import no.uio.ifi.in2000.victoryk.oblig2.model.alpacas.PartyInfo

import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.Serializable

// Henter og deserialiserer responsen fra PartyInfo
// og returnerer en liste av PartyInfo-objekter


@Serializable
class AlpacaPartiesDataSource {


}

