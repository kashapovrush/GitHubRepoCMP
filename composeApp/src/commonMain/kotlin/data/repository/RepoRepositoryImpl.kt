package data.repository

import data.network.ktorClient.Service
import data.network.model.Response
import domain.RepoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class RepoRepositoryImpl : RepoRepository, KoinComponent {

    private val service: Service by inject()

    override suspend fun getRepositories(): Flow<Response> = flow {
        emit(service.getRepositories("mvp"))
    }
}