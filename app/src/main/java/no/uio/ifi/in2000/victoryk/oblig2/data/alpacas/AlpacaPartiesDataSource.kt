package no.uio.ifi.in2000.victoryk.oblig2.data.alpacas

// import com.google.gson.reflect.TypeToken
// import kotlinx.serialization.json.Json
import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import no.uio.ifi.in2000.victoryk.oblig2.model.alpacas.Parties
import no.uio.ifi.in2000.victoryk.oblig2.model.alpacas.PartyInfo

class AlpacaPartiesDataSource {
    private val url =
        "https://www.uio.no/studier/emner/matnat/ifi/IN2000/v24/obligatoriske-oppgaver/alpacaparties.json"

    private val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
            })
            Log.i("YEE", "Client started")
        }
    }
    suspend fun fml(): ArrayList<PartyInfo> {
        Log.i("test", "trying to fetch data")
        val response: Parties = client.get(url).body();
        // Log.i("test", "$response")
        // val resBody: List<PartyInfo> = response.body();
        // val typeToken = object : TypeToken<String>() {}.type
        return response.parties; // Gson().fromJson(response, typeToken)
    }
}

