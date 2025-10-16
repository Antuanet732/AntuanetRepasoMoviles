package com.c_antuanet.AppUEREPASO1162003.presentation.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.core.app.NotificationCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.c_antuanet.AppUEREPASO1162003.presentation.auth.LoginScreen
import com.c_antuanet.AppUEREPASO1162003.presentation.auth.RegisterScreen
import com.c_antuanet.AppUEREPASO1162003.presentation.home.HomeScreen
import com.c_antuanet.AppUEREPASO1162003.presentation.permissions.GalleryPermissionsScreen


@Composable
fun AppNavGraph(){

    val navController = rememberNavController()

    NavHost(navController = navController,
        startDestination = "home"){

        composable("register") { RegisterScreen(navController) }
        composable ("login") { LoginScreen(navController) }

        composable ("home") {
            DrawerScaffold(navController) {
                HomeScreen()
            }
        }
        composable ("permissions") {
            DrawerScaffold(navController) {
                GalleryPermissionsScreen()
            }
        }
        composable ("Favorites") {
            DrawerScaffold(navController) {
                Text("Pantalla de favoritos próximamente")
            }
        }
    }
}