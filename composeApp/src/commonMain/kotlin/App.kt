import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import di.getSharedModule
import org.koin.compose.KoinApplication
import presentation.RepositoriesScreen

@Composable
fun App() {

        MaterialTheme {
            RepositoriesScreen()
        }
}



