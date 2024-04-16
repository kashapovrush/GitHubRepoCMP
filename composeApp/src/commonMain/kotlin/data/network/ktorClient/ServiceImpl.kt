package data.network.ktorClient

import data.network.model.Response
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import org.koin.core.component.KoinComponent

class ServiceImpl(private val client: HttpClient) : Service, KoinComponent {

    override suspend fun getRepositories(query: String): Response {
        val response = client.get ("https://api.github.com/search/repositories"){
            url {
                parameters.append("q", query)
            }
        }
        return response.body()
    }
}