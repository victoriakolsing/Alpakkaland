package no.uio.ifi.in2000.victoryk.oblig2.data.alpacas

// import com.google.gson.reflect.TypeToken
// import kotlinx.serialization.json.Json
import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import no.uio.ifi.in2000.victoryk.oblig2.model.alpacas.Parties
import no.uio.ifi.in2000.victoryk.oblig2.model.alpacas.PartyInfo

class AlpacaPartiesDataSource {
    private val url =
        "https://www.uio.no/studier/emner/matnat/ifi/IN2000/v24/obligatoriske-oppgaver/alpacaparties.json"

    private val client = HttpClient() {
        install(ContentNegotiation) {
            json(Json)
            Log.i("YEE", "Client started")
        }
    }
    suspend fun getPartiesFromUrl(): List<PartyInfo> {
        Log.i("test", "trying to fetch alpaca data")
        val response: Parties =
            try {
                client.get(url).body()
            } catch (e: Exception) {
                Log.e("YIKES", "Couldn't fetch data from url $url")
                Parties(emptyList())
            }
        return response.parties
    }
}

