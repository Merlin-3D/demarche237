package com.merlin3d.demarche237.ui.screen.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import demarche237.shared.generated.resources.Res
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.merlin3d.demarche237.ui.screen.main.navigation.FavoriteScreen
import com.merlin3d.demarche237.ui.screen.main.navigation.HomeScreen
import com.merlin3d.demarche237.ui.screen.main.navigation.SearchScreen
import demarche237.shared.generated.resources.favorite_outline
import demarche237.shared.generated.resources.home
import demarche237.shared.generated.resources.search

enum class Destination(
    val route: String,
    val label: String,
    val icon: DrawableResource,
    val contentDescription: String
) {
    HOME("home", "Accueil", Res.drawable.home, "Accueil"),
    SEARCH("search", "Recherche", Res.drawable.search, "Recherche"),
    FAVORITE("favorite", "Favoris", Res.drawable.favorite_outline, "Favoris"),
}

@Composable
fun AppNavHost(
    navController: NavHostController,
    startDestination: Destination,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = startDestination.route,
        modifier = modifier
    ) {
        Destination.entries.forEach { destination ->
            composable(destination.route) {
                when (destination) {
                    Destination.HOME -> HomeScreen()
                    Destination.SEARCH -> SearchScreen()
                    Destination.FAVORITE -> FavoriteScreen()
                }
            }
        }
    }
}

@Preview
@Composable
fun MainNavigation() {

    val navController = rememberNavController()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            NavigationBar(
                windowInsets = NavigationBarDefaults.windowInsets
            ) {
                Destination.entries.forEach { destination ->
                    val isSelected =
                        currentRoute == destination.route
                    NavigationBarItem(
                        selected = isSelected,
                        onClick = {
                            navController.navigate(destination.route) {
                                popUpTo(
                                    navController.graph.startDestinationId
                                ) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        colors = NavigationBarItemDefaults.colors(
                            indicatorColor = Color.Transparent
                        ),
                        icon = {
                            Column(
                                horizontalAlignment =
                                    Alignment.CenterHorizontally
                            ) {
                                Icon(
                                    painter = painterResource(
                                        destination.icon
                                    ),
                                    contentDescription =
                                        destination.contentDescription,
                                    modifier = Modifier.size(24.dp),
                                    tint = if (isSelected) Color(0xFF017962) else Color.Gray
                                )
                                Text(
                                    text = destination.label,
                                    fontSize = 12.sp,
                                    fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal,
                                    color = if (isSelected) Color(0xFF017962) else Color.Gray
                                )
                                Box(
                                    modifier = Modifier
                                        .size(70.dp, 2.dp)
                                        .background(
                                            if (isSelected) Color(0xFF017962) else Color.Transparent
                                        )
                                )
                            }
                        }
                    )
                }
            }
        }
    ) { contentPadding ->
        AppNavHost(
            navController = navController,
            startDestination = Destination.HOME,
            modifier = Modifier.padding(contentPadding)
        )
    }
}