package com.linhtetko.dailyvita.ui.screens.onboarding.questions

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class QuestionsViewModel @Inject constructor() : ViewModel() {

    var dailyExposureToSun by mutableStateOf(
        listOf(
            "Yes" to true,
            "No" to false,
        )
    )

    var currentSmokee by mutableStateOf(
        listOf(
            "Yes" to true,
            "No" to false,
        )
    )

    var alcoholicPerWeek by mutableStateOf(
        listOf(
            "0 - 1" to true,
            "2 - 5" to false,
            "5+" to false,
        )
    )

    fun onCheckChangeDailyExposure(index: Int) {
        val temp = dailyExposureToSun.toList()
        dailyExposureToSun = temp.mapIndexed { i, pair -> pair.copy(second = index == i)  }
    }

    fun onCheckChangeSmokee(index: Int) {
        val temp = currentSmokee.toList()
        currentSmokee = temp.mapIndexed { i, pair -> pair.copy(second = index == i)  }
    }

    fun onCheckChangeAlcoholic(index: Int) {
        val temp = alcoholicPerWeek.toList()
        alcoholicPerWeek = temp.mapIndexed { i, pair -> pair.copy(second = index == i)  }
    }

}