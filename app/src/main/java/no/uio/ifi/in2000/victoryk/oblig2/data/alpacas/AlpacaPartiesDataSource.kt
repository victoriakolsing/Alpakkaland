package no.uio.ifi.in2000.victoryk.oblig2.data.alpacas

import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import no.uio.ifi.in2000.victoryk.oblig2.model.alpacas.PartyInfo

val BASE_URL = "https://www.uio.no/studier/emner/matnat/ifi/IN2000/v24/obligatoriske-oppgaver/alpacaparties.json"
@Serializable
class AlpacaPartiesDataSource {
    suspend fun getPartyInfoList(): List<PartyInfo> {
        return withContext(Dispatchers.Default) {
            try {
                val response = HttpClient().get(BASE_URL)
                Json.decodeFromString<List<PartyInfo>>(response.toString())
            } catch (ex: Exception) {
                Log.e("OOPS", "sum ting wong with api call")
                emptyList()
            }
        }
    }

}

