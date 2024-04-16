package presentation

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import domain.GetRepositoriesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class RepoViewModel : ViewModel(), KoinComponent {

    val getRepositoriesUseCase: GetRepositoriesUseCase by inject()


    private val _state = MutableStateFlow<State>(State.Loading)
    val state = _state.asStateFlow().stateIn(
        viewModelScope, SharingStarted.Lazily, State.Loading
    )

    fun onEvent(event: Event) {
        when (event) {
            Event.LoadRepositories -> {
                getRepositories()
            }
        }
    }

    private fun getRepositories() {
        viewModelScope.launch {
            getRepositoriesUseCase.getRepositories()
//                .catch {
//                    _state.value = State.Error(it.message.toString())
//                }
                .collect {
                    _state.value = State.Success(it.items)
                }
        }

    }

}