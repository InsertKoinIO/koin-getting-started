package com.jetbrains.kmpapp

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.jetbrains.kmpapp.di.ScopedData
import com.jetbrains.kmpapp.screens.detail.DetailScreen
import com.jetbrains.kmpapp.screens.list.ListScreen
import kotlinx.serialization.Serializable
import org.koin.compose.koinInject
import org.koin.compose.scope.KoinNavigationScope

@Serializable
object ListDestination

@Serializable
data class DetailDestination(val objectId: Int)

@Composable
fun App() {

    MaterialTheme(
        colorScheme = if (isSystemInDarkTheme()) darkColorScheme() else lightColorScheme()
    ) {
        Surface {
            val navController: NavHostController = rememberNavController()
            NavHost(navController = navController, startDestination = ListDestination) {
                composable<ListDestination> { backStackEntry ->

                    KoinNavigationScope(backStackEntry) {
                        val scoped = koinInject<ScopedData>()
                        println("ListDestination -> scoped : $scoped")

                        ListScreen(navigateToDetails = { objectId ->
                            navController.navigate(DetailDestination(objectId))
                        })
                    }
                }
                composable<DetailDestination> { backStackEntry ->

                    KoinNavigationScope(backStackEntry) {
                        val scoped = koinInject<ScopedData>()

                        println("DetailDestination -> scoped : $scoped")

                        DetailScreen(
                            objectId = backStackEntry.toRoute<DetailDestination>().objectId,
                            navigateBack = {
                                navController.popBackStack()
                            }
                        )
                    }
                }
            }
        }
    }
}