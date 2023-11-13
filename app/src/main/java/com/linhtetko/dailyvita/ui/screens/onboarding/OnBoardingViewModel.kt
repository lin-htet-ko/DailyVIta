package com.linhtetko.dailyvita.ui.screens.onboarding

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.linhtetko.dailyvita.domain.vos.AllergieVO
import com.linhtetko.dailyvita.domain.vos.DietVO
import com.linhtetko.dailyvita.domain.vos.HealthConcernVO
import com.linhtetko.dailyvita.domain.vos.PersonalizeVO
import com.linhtetko.dailyvita.ui.screens.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor() : ViewModel() {

    var healthConcerns by mutableStateOf<List<HealthConcernVO>>(listOf())

    var diets by mutableStateOf<List<DietVO>>(listOf())

    var allergies by mutableStateOf<List<AllergieVO>>(listOf())

    var isDailyExposeToSun by mutableStateOf<Boolean>(false)
    var isCurrentlySmokee by mutableStateOf<Boolean>(false)
    var alcoholicPerWeeks by mutableStateOf<String>("")

    private val screens = listOf(
        Screen.HealthConcern.route,
        Screen.Diet.route,
        Screen.Allergies.route,
        Screen.Questions.route,
    )

    var currentProgress by mutableStateOf(0.25f)

    fun calculateProgress(currentRoute: String) {
        currentProgress =
            ((screens.indexOf(currentRoute) + 1f) * 0.25f)
    }


    fun getPersonalizeVitamin(): PersonalizeVO = PersonalizeVO(
        healthConcerns = healthConcerns,
        diets = diets,
        allergies = allergies,
        isDailyExposure = isDailyExposeToSun,
        isSmoke = isCurrentlySmokee,
        alchol = alcoholicPerWeeks
    )
}