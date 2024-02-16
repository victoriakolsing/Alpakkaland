package no.uio.ifi.in2000.victoryk.oblig2.data.alpacas

import kotlinx.serialization.Serializable

@Serializable
data class AlpacaPartiesDataSource (
    val id: String,
    val name: String,
    val leader: String,
    val img: String,
    val color: String,
    val description: String
)