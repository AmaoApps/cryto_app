package pe.paku.cryptoapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import pe.paku.cryptoapp.presentation.crypto_detail.CryptoDetailScreen
import pe.paku.cryptoapp.presentation.crypto_list.CryptoListScreen
import pe.paku.cryptoapp.presentation.ui.theme.CryptoAppTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CryptoListScreen.route
                    ) {
                        composable(
                            route = Screen.CryptoListScreen.route
                        ) {
                            CryptoListScreen(navController = navController)
                        }
                        composable(
                            route = Screen.CryptoDetailScreen.route + "/{cryptoId}"
                        ) {
                            CryptoDetailScreen()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CryptoAppTheme {
        Greeting("Android")
    }
}