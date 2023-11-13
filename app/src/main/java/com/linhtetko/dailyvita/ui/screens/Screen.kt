package com.linhtetko.dailyvita.ui.screens

import com.linhtetko.dailyvita.ui.screens.Screen.Route.OnBoarding.ALLERGIES
import com.linhtetko.dailyvita.ui.screens.Screen.Route.OnBoarding.DIETS
import com.linhtetko.dailyvita.ui.screens.Screen.Route.OnBoarding.HEALTH_CONCERN
import com.linhtetko.dailyvita.ui.screens.Screen.Route.OnBoarding.ONBOARDING
import com.linhtetko.dailyvita.ui.screens.Screen.Route.OnBoarding.QUESTIONS

sealed class Screen(val route: String) {

    companion object Route {
        const val GET_START = "/get_started"

        object OnBoarding {
            const val ONBOARDING = "/onboarding"
            const val HEALTH_CONCERN = "/health_concern"
            const val DIETS = "/diets"
            const val ALLERGIES = "/allergies"
            const val QUESTIONS = "/questions"
        }
    }

    data object GetStarted : Screen(GET_START)

    data object OnBoarding : Screen(ONBOARDING)
    data object HealthConcern : Screen(HEALTH_CONCERN)
    data object Diet : Screen(DIETS)
    data object Allergies : Screen(ALLERGIES)
    data object Questions : Screen(QUESTIONS)
}
