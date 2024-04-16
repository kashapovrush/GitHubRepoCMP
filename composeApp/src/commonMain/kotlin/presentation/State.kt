package presentation

import data.network.model.SearchItem

sealed class State {

    data object Loading: State()

    data class Success(val list: List<SearchItem>): State()

//    data class Error(val message: String): State()
}