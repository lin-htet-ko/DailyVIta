package com.linhtetko.dailyvita.ui.screens.onboarding

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.linhtetko.dailyvita.R
import com.linhtetko.dailyvita.ui.screens.Screen
import com.linhtetko.dailyvita.ui.screens.onboarding.allergie.AllergiesScreen
import com.linhtetko.dailyvita.ui.screens.onboarding.allergie.AllergiesViewModel
import com.linhtetko.dailyvita.ui.screens.onboarding.diet.DietScreen
import com.linhtetko.dailyvita.ui.screens.onboarding.diet.DietViewModel
import com.linhtetko.dailyvita.ui.screens.onboarding.health_concern.HealthConcernScreen
import com.linhtetko.dailyvita.ui.screens.onboarding.health_concern.HealthConcernViewModel
import com.linhtetko.dailyvita.ui.screens.onboarding.questions.QuestionsScreen
import com.linhtetko.dailyvita.ui.screens.onboarding.questions.QuestionsViewModel
import com.linhtetko.dailyvita.ui.utils.extesions.showToast
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Composable
fun OnBoardingScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
) {

    val innerNavHostController = rememberNavController()
    val onBoardingViewModel = hiltViewModel<OnBoardingViewModel>()

    Scaffold(modifier = modifier.fillMaxSize(), bottomBar = {
        LinearProgressIndicator(
            progress = onBoardingViewModel.currentProgress,
            strokeCap = StrokeCap.Butt,
            color = MaterialTheme.colors.secondary,
            backgroundColor = MaterialTheme.colors.surface,
            modifier = Modifier
                .fillMaxWidth()
                .height(10.dp)
        )
    }) {
        OnBoardingNavHost(
            modifier = Modifier.padding(it),
            navController = navController,
            innerNavHostController = innerNavHostController,
            onBoardingViewModel = onBoardingViewModel
        )

    }
}

@Composable
fun OnBoardingNavHost(
    modifier: Modifier,
    navController: NavController,
    innerNavHostController: NavHostController,
    onBoardingViewModel: OnBoardingViewModel
) {

    val context = LocalContext.current

    NavHost(navController = innerNavHostController, startDestination = Screen.HealthConcern.route) {
        composable(route = Screen.HealthConcern.route) {
            val healthConcernViewModel = hiltViewModel<HealthConcernViewModel>()

            HealthConcernScreen(
                modifier = modifier,
                healthConcernViewModel = healthConcernViewModel,
                onTapBack = {
                    navController.popBackStack()
                },
                onTapNext = {
                    val healthConcerns = healthConcernViewModel.selectedHealthConcerns
                    if (healthConcerns.isNotEmpty() && healthConcerns.size >= 5) {
                        onBoardingViewModel.healthConcerns = healthConcerns
                        innerNavHostController.navigate(Screen.Diet.route) {
                            restoreState = true
                        }
                        onBoardingViewModel.calculateProgress(Screen.Diet.route)
                    } else {
                        context.showToast(R.string.lbl_please_select_health_concern_up_to_5)
                    }
                }
            )
        }
        composable(route = Screen.Diet.route) {
            val dietViewModel = hiltViewModel<DietViewModel>()

            DietScreen(
                modifier = modifier,
                dietViewModel = dietViewModel,
                onTapBack = {
                    innerNavHostController.popBackStack()
                    onBoardingViewModel.calculateProgress(Screen.HealthConcern.route)
                },
                onTapNext = {
                    onBoardingViewModel.diets = dietViewModel.diets.filter { it.isSelected }

                    innerNavHostController.navigate(Screen.Allergies.route) {
                        restoreState = true
                    }
                    onBoardingViewModel.calculateProgress(Screen.Allergies.route)
                })
        }
        composable(route = Screen.Allergies.route) {
            val allergiesViewModel = hiltViewModel<AllergiesViewModel>()

            AllergiesScreen(modifier = modifier, allergiesViewModel = allergiesViewModel,
                onTapBack = {
                    innerNavHostController.navigateUp()
                    onBoardingViewModel.calculateProgress(Screen.Diet.route)
                },
                onTapNext = {

                    onBoardingViewModel.allergies = allergiesViewModel.selectedAllergies

                    innerNavHostController.navigate(Screen.Questions.route) {
                        restoreState = true
                    }
                    onBoardingViewModel.calculateProgress(Screen.Questions.route)
                })
        }
        composable(route = Screen.Questions.route) {
            val questionsViewModel = hiltViewModel<QuestionsViewModel>()

            QuestionsScreen(
                modifier = modifier,
                questionsViewModel = questionsViewModel,
                onTapPersonalize = {
                    onBoardingViewModel.isDailyExposeToSun =
                        questionsViewModel.dailyExposureToSun.first { item -> item.second }.second
                    onBoardingViewModel.isCurrentlySmokee =
                        questionsViewModel.currentSmokee.first { item -> item.second }.second
                    onBoardingViewModel.alcoholicPerWeeks =
                        questionsViewModel.alcoholicPerWeek.first { item -> item.second }.first

                    println(Json.encodeToString(onBoardingViewModel.getPersonalizeVitamin()))
                })
        }
    }
}