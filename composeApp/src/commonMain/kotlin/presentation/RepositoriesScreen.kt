package presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.createFontFamilyResolver
import androidx.compose.ui.unit.sp
import data.network.model.SearchItem
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.koinInject

@Composable
@Preview
fun RepositoriesScreen() {

    val commonModifier = Modifier.fillMaxSize()

    val viewModel: RepoViewModel = koinInject()
    viewModel.onEvent(Event.LoadRepositories)
    val state by viewModel.state.collectAsState()

    when (state) {
        is State.Loading -> {
            Box(modifier = commonModifier, contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }

//        is State.Error -> {
//            Box(modifier = commonModifier, contentAlignment = Alignment.Center) {
//                Text(text = state.toString())
//            }
//        }

        is State.Success -> {
            LazyColumn(modifier = commonModifier) {
                items((state as State.Success).list) {
                    Items(it)
                }
            }
        }

    }
}


@Composable
fun Items(item: SearchItem) {
    Column {
        Text(text = item.name.toString(), fontSize = 20.sp)
        Text(text = item.fullName.toString(), fontSize = 16.sp)
        Divider()
    }
}