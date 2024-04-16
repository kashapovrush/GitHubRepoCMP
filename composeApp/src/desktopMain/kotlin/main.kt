import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import di.getSharedModule
import org.koin.core.context.startKoin
import org.koin.dsl.koinApplication


fun main() = application {

    Window(onCloseRequest = ::exitApplication, title = "CounterApp") {
        App()
    }
}




