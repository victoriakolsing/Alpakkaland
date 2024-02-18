package no.uio.ifi.in2000.victoryk.oblig2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.SavedStateHandle
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

val SuperLightPink = Color(0xfffff0f3)
val LightPink = Color(0xffffc1cc)
val Blush = Color(0xffde5d83)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Victoryk_oblig2Theme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Text("pls")
                    // NAVIGATION ---------------------------------------------------------------------------------------------------------------------
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "HomeScreen") {
                        composable(route = "HomeScreen") {
                            HomeScreen (
                                viewModel = HomeViewModel(),
                                navController = navController
                            )
                        }
                        composable(route = "PartyScreen/{partyId}",
                            arguments = listOf(
                                navArgument(name = "partyId") {
                                    type = NavType.StringType
                                }
                            )
                        ) { backStackEntry ->
                            backStackEntry.arguments?.getString("partyId")?.let {
                                PartyScreen (
                                    viewModel = PartyViewModel(savedStateHandle = SavedStateHandle())
                                )
                            }
                        }
                    }
                    // APP START ---------------------------------------------------------------------------------------------------------------------
                    val homeViewModel = HomeViewModel()
                    HomeScreen (
                        viewModel = homeViewModel,
                        navController = navController
                    )
                }
            }
        }
    }
}

