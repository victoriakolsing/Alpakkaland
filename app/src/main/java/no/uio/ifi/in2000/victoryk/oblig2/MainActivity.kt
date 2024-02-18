package no.uio.ifi.in2000.victoryk.oblig2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import no.uio.ifi.in2000.victoryk.oblig2.ui.home.HomeScreen
import no.uio.ifi.in2000.victoryk.oblig2.ui.home.HomeViewModel
import no.uio.ifi.in2000.victoryk.oblig2.ui.home.PartyScreen
import no.uio.ifi.in2000.victoryk.oblig2.ui.home.PartyViewModel
import no.uio.ifi.in2000.victoryk.oblig2.ui.theme.Victoryk_oblig2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Victoryk_oblig2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // NAVIGATION

                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "HomeScreen") {
                        composable("HomeScreen") {
                            HomeScreen (
                                viewModel = HomeViewModel(),
                                onNavigateToParty = { navController.navigate("PartyScreen/{partyId}") }
                            )
                        }
                        composable("PartyScreen/{partyId}", arguments = listOf(navArgument("partyId") { type = NavType.StringType })) { backStackEntry ->
                            PartyScreen (
                                viewModel = PartyViewModel(),
                                backStackEntry.arguments?.getString("partyId")
                            )
                        }
                    }




                }
            }
        }
    }
}

