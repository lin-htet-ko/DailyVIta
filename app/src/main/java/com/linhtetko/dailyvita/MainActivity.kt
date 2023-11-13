package com.linhtetko.dailyvita

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.linhtetko.dailyvita.ui.screens.Screen
import com.linhtetko.dailyvita.ui.screens.get_started.GetStartedScreen
import com.linhtetko.dailyvita.ui.screens.onboarding.OnBoardingScreen
import com.linhtetko.dailyvita.ui.theme.DailyVItaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DailyVItaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()

                    DailyVitaAppNavHost(navController = navController)
                }
            }
        }
    }
}

@Composable
fun DailyVitaAppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.GetStarted.route) {
        composable(route = Screen.GetStarted.route) {
            GetStartedScreen(onTapGetStarted = {
                navController.navigate(Screen.OnBoarding.route){
                    restoreState = true
                }
            })
        }
        composable(route = Screen.OnBoarding.route){
            OnBoardingScreen(navController = navController)
        }
    }
}