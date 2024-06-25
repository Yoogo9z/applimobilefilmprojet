import com.example.applimobilefilm.api.MovieApiClient
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request
import okio.IOException


class MovieRepository(private val client: OkHttpClient) {

    fun getPopularMovies(apiKey: String): MovieApiClient.MoviesResponse? {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url("https://api.example.com/movies?api_key=$apiKey")
            .build()

        client.newCall(request).execute().use { response ->
            if (!response.isSuccessful) throw IOException("Unexpected code $response")

            val responseBody = response.body?.string()
            val moviesResponse =
                Gson().fromJson(responseBody, MovieApiClient.MoviesResponse::class.java)
            response.close()
            return moviesResponse
        }
    }

    companion object {
        fun getPopularMovies(apiKey: String): MovieApiClient.MoviesResponse? {
            val client = OkHttpClient()
            val request = Request.Builder()
                .url("https://dummyapi.online/api/movies")
                .build()

            client.newCall(request).execute().use { response ->
                if (!response.isSuccessful) throw IOException("Unexpected code $response")

                val responseBody = response.body?.string()
                val moviesResponse =
                    Gson().fromJson(responseBody, MovieApiClient.MoviesResponse::class.java)
                response.close()
                return moviesResponse
            }
        }
    }
}
