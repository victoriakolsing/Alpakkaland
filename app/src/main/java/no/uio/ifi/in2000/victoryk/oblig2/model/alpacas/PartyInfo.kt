package no.uio.ifi.in2000.victoryk.oblig2.model.alpacas

import kotlinx.serialization.Serializable


// Dataklasse som inneholder de samme feltene som i endepunktet

@Serializable
data class PartyInfo(
    val name: String,
    val leader: String,
    val img: String,
    val color: String,
    val description: String,
)

