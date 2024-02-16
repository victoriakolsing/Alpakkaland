package no.uio.ifi.in2000.victoryk.oblig2

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import no.uio.ifi.in2000.victoryk.oblig2.ui.home.HomeScreen
import no.uio.ifi.in2000.victoryk.oblig2.ui.home.HomeViewModel
import no.uio.ifi.in2000.victoryk.oblig2.ui.home.PartyScreen
import no.uio.ifi.in2000.victoryk.oblig2.ui.home.PartyViewModel

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val homeViewModel = remember { HomeViewModel() }
    val partyViewModel = remember { PartyViewModel() }

    NavHost(
        navController = navController,
        startDestination = "homeScreen"
    ) {
        composable("homeScreen") {
            HomeScreen (
                homeViewModel,
                navigateToParty = { id ->
                    navController.navigate("party/$id")
                }
            )
        }
        composable(
            route = "party/${id}",
            arguments = listOf(navArgument("$id") { type = NavType.StringType })
        ) {backStackEntry ->
            val arguments = requireNotNull(backStackEntry.arguments)
            val partyID = arguments.getInt("$id")
            PartyScreen(partyViewModel = partyViewModel, partyId = "$id")
        }
    }
}