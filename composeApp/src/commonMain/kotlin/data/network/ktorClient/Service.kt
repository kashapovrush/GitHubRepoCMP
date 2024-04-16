package data.network.ktorClient

import data.network.model.Response
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

interface Service {

    suspend fun getRepositories(query: String): Response

    companion object {
        fun createServiceInstance(client: HttpClient): Service {
            return ServiceImpl(client)
        }
    }
}