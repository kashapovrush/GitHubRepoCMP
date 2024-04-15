package ktor

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.ktor.http.isSuccess

class ServiceImpl(private val client: HttpClient) : Service {

    override suspend fun getRepositories(query: String): Response {
        val response = client.get ("https://api.github.com/search/repositories"){
            url {
                parameters.append("q", query)
            }
        }
        return response.body()
    }
}