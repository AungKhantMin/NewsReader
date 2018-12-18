package akm.hades.newsreader

import org.json.JSONObject
import java.lang.Exception

class JsonParse {
    fun getJson() : JSONObject?{
        try{
            val res = khttp.get("https://newsapi.org/v2/top-headlines",
                params = mapOf("country" to "us", "apiKey" to "b193681c4c9b438499947edcf5c66574"))
            return res.jsonObject
        }
        catch (e : Exception){

        }
        return null

    }
}