package com.merlin3d.demarche237.ui.screen.main

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import demarche237.shared.generated.resources.Res
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
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
    HOME("home", "Accueil", Res.drawable.home , "Accueil"),
    SEARCH("search", "Recherche", Res.drawable.search, "Recherche"),
    FAVORITE("favorite", "Favoris", Res.drawable.favorite_outline, "Favoris"),
}

@Composable
fun AppNavHost(
    navController: NavController,
    startDestination: Destination,
    modifier: Modifier = Modifier
){
    NavHost(
        navController as NavHostController,
        startDestination = startDestination.route
    ) {
        Destination.entries.forEach { destination ->
            composable(destination.route) {
                when (destination) {
                    Destination.SEARCH -> SearchScreen()
                    Destination.FAVORITE -> FavoriteScreen()
                    else -> HomeScreen()
                }
            }
        }
    }
}

@Preview
@Composable
fun MainNavigation(){
    val navController = rememberNavController()
    val startDestination = Destination.HOME

    var selectedDestination by rememberSaveable { mutableIntStateOf(startDestination.ordinal) }

    val interactionSource = remember { MutableInteractionSource() }
    Scaffold (
        bottomBar = {
            NavigationBar(windowInsets = NavigationBarDefaults.windowInsets) {
                Destination.entries.forEachIndexed { index, destination ->
                    NavigationBarItem(
                        selected = selectedDestination == index,
                        onClick = {
                            navController.navigate(route = destination.route)
                            selectedDestination = index
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color(0xFF017962),
                            indicatorColor = Color.Transparent
                        ),
                        icon = {
                            Column(
                                verticalArrangement = Arrangement.spacedBy(4.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                            ){
                                Icon(
                                    painter = painterResource(destination.icon),
                                    contentDescription = destination.contentDescription,
                                    modifier = Modifier.size(24.dp),
                                    tint = if(selectedDestination == index ) Color(0xFF017962) else Color.Gray
                                )
                                Text(destination.label, style = TextStyle(
                                    fontWeight = FontWeight(600)
                                ))
                                Box(modifier = Modifier.size(80.dp, 2.dp).background(color = if (selectedDestination == index)  Color(0xFF017962) else Color.Transparent) )
                            }

                        },
                    )
                }
            }
        }
    ) { contentPadding ->  AppNavHost(navController, startDestination, modifier = Modifier.padding(contentPadding))}
}