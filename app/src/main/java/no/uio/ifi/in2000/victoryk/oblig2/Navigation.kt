package no.uio.ifi.in2000.victoryk.oblig2

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import no.uio.ifi.in2000.victoryk.oblig2.ui.home.HomeScreen
import no.uio.ifi.in2000.victoryk.oblig2.ui.home.PartyScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "homeScreen"
    ) {
        composable("homeScreen") { HomeScreen(navController = navController) }
        composable("partyScreen/{id}", arguments = listOf(navArgument("id") { type = NavType.StringType }) )
        { BackStackEntry ->
            val id = BackStackEntry.arguments?.getString("id")
            PartyScreen(navController, id)
        }
    }
}