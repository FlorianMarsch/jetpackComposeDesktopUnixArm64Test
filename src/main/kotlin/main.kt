import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application

@Composable
@Preview
fun App() {
    var text by remember { mutableStateOf("Hello, World!") }

    MaterialTheme {
        Button(
            onClick = { text = "Hello, Desktop!" },
            modifier = Modifier.testTag("button")
        ) {
            Text(text)
        }
    }
}

fun main() = application {
    val windowState = remember { WindowState(
        isMinimized = false,
        size = DpSize(640.dp, 480.dp)
    ) }
    Window(onCloseRequest = ::exitApplication,
        undecorated = true,
        resizable = true,
        alwaysOnTop = true,
        state = windowState
        ) {
        App()
    }
}
