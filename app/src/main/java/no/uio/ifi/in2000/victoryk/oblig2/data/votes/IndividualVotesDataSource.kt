package no.uio.ifi.in2000.victoryk.oblig2.data.votes

class IndividualVotesDataSource {
    private val district1 = "https://www.uio.no/studier/emner/matnat/ifi/IN2000/v24/obligatoriske-oppgaver/district1.json"
    private val district2 = "https://www.uio.no/studier/emner/matnat/ifi/IN2000/v24/obligatoriske-oppgaver/district2.json"

    /*
        private val client = HttpClient() {
            install(ContentNegotiation) {
                json(Json)
            }
        }
            val response = client.get(district).toString()
            val typeToken = object : TypeToken<DistrictVotes>() {}.type
            return Gson().fromJson(response, typeToken)
        }


    suspend fun getVotesDistrict1(): DistrictVotes {
        return getVotes(district1)
    }
    suspend fun getVotesDistrict2(): DistrictVotes {
        return getVotes(district2)
    }
        */
}