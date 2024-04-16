package domain

import data.network.model.Response
import kotlinx.coroutines.flow.Flow

interface RepoRepository {

    suspend fun getRepositories(): Flow<Response>
}