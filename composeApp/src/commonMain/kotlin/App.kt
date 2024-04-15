import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import ktor.SearchItem
import ktor.Service
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {

    val service = Service.create()

    MaterialTheme {

        val scope = rememberCoroutineScope()

        val products = remember {
            mutableStateOf(emptyList<SearchItem>())
        }

        LaunchedEffect(true) {
            scope.launch {
                products.value = service.getRepositories("mvp").items
            }
        }

        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(products.value) {
                Text(text = it.name ?: "", fontSize = 20.sp)
                Text(text = it.fullName ?: "", fontSize = 14.sp)
            }
        }
    }
}