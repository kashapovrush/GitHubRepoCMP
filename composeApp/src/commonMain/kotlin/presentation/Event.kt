package presentation

sealed interface Event {

    data object LoadRepositories: Event
}