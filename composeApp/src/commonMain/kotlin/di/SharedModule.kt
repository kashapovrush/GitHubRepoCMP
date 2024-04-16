package di

import data.network.ktorClient.Service
import data.repository.RepoRepositoryImpl
import domain.GetRepositoriesUseCase
import domain.RepoRepository
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module
import presentation.RepoViewModel

private val domainModule = module {
    factory { GetRepositoriesUseCase() }
}

private val presentationModule = module {
    single<RepoRepository> {
        RepoRepositoryImpl()
    }
    single { RepoViewModel()}
}

val serviceModule = module {
    single {
        HttpClient {
            install(Logging) {
                level = LogLevel.ALL
            }

            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                    isLenient = true
                    prettyPrint = true
                })
            }
        }
    }

    single { Service.createServiceInstance(get()) }
}

private fun getAllModule() = listOf(
    domainModule, presentationModule, serviceModule
)

fun getSharedModule() = getAllModule()