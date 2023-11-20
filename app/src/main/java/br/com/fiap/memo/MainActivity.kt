package br.com.fiap.memo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.memo.screens.MemoScreenAPI
import br.com.fiap.memo.screens.CategoriasScreen
import br.com.fiap.memo.screens.LembretesScreen
import br.com.fiap.memo.screens.LoginScreen
import br.com.fiap.memo.screens.MemosScreen
import br.com.fiap.memo.screens.MenuScreen
import br.com.fiap.memo.screens.OrigemsScreen
import br.com.fiap.memo.ui.theme.MemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MemoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "login"
                    ) {
                        composable(route = "login") { LoginScreen(navController) }
                        composable(route = "menu")  { MenuScreen(navController) }
                        composable(route = "memo")  { MemosScreen() }
                        composable(route = "memoapi") { MemoScreenAPI() }
                        composable(route = "lembrete") { LembretesScreen() }
                        composable(route = "categoria") { CategoriasScreen() }
                        composable(route = "origem") { OrigemsScreen() }

                    }
                }
            }
        }
    }
}


