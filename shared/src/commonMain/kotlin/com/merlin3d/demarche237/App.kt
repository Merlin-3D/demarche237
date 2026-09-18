package com.merlin3d.demarche237
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.merlin3d.demarche237.ui.screen.SplashScreen
import com.merlin3d.demarche237.ui.screen.main.MainNavigation

@Composable
@Preview
fun App() {
    val navController = rememberNavController()

    MaterialTheme {
        NavHost(
            navController = navController,
            startDestination = "splash"
        ){
            composable("splash") {
                SplashScreen(
                    onFinish = {
                        navController.navigate(("main"))
                    }
                )
            }
            composable("main") {
                MainNavigation()
            }
        }
    }


}