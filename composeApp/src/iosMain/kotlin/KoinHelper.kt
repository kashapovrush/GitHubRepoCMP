import di.getSharedModule
import org.koin.core.context.startKoin

fun doInitKoin() {
    startKoin {
        modules(getSharedModule())
    }
}