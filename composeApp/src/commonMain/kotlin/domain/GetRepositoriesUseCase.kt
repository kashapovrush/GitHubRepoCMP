package domain

import data.network.model.Response
import kotlinx.coroutines.flow.Flow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GetRepositoriesUseCase: KoinComponent {

    val repository: RepoRepository by inject()

    suspend fun getRepositories(): Flow<Response> {
        return repository.getRepositories()
    }
}