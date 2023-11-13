package com.linhtetko.dailyvita.ui.screens.onboarding.diet

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.linhtetko.dailyvita.domain.respositories.DietRepository
import com.linhtetko.dailyvita.domain.vos.DietVO
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DietViewModel @Inject constructor(
    private val dietRepo: DietRepository
) : ViewModel() {

    init {
        getDiets()
    }

    var diets by mutableStateOf<List<DietVO>>(listOf())
        private set

    fun isNoneSelected() = diets.none { it.isSelected }

    private fun getDiets() {
        viewModelScope.launch {
            val mDiets = async(Dispatchers.Default) { dietRepo.getDiets() }.await()
            diets = mDiets
        }
    }

    fun onCheckDietItem(diet: DietVO) {
        viewModelScope.launch {
            val mDiets = async(Dispatchers.Default) {
                diets.map { if (it.id == diet.id) it.copy(isSelected = !it.isSelected) else it }
            }.await()

            diets = mDiets
        }
    }

    fun onTapShowTooltip(diet: DietVO) {
        viewModelScope.launch{
            val mDiets = async(Dispatchers.Default) {
                diets.map { it.copy(showTooltip = it.id == diet.id) }
            }.await()

            diets = mDiets
        }
    }
}