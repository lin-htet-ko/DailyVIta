package com.linhtetko.dailyvita.ui.screens.onboarding.health_concern

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.linhtetko.dailyvita.domain.respositories.HealthConcernRepository
import com.linhtetko.dailyvita.domain.vos.HealthConcernVO
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HealthConcernViewModel @Inject constructor(
    private val healthConcernRepository: HealthConcernRepository
) : ViewModel() {

    var healthConcerns by mutableStateOf<List<HealthConcernVO>>(listOf())
        private set

    var selectedHealthConcerns by mutableStateOf(healthConcerns.filter { it.isSelected })
        private set

    init {
        getHealthConcerns()
    }

    private fun getHealthConcerns() {
        viewModelScope.launch {
            healthConcerns =
                async(Dispatchers.IO) { healthConcernRepository.getHealthConcerns() }.await()
            selectedHealthConcerns(healthConcerns)
        }
    }

    fun onSelectedHealthConcern(item: HealthConcernVO) {
        viewModelScope.launch {
            healthConcerns = async(Dispatchers.Default) {
                val items = healthConcerns.map {
                    if (it.id == item.id) it.copy(isSelected = !item.isSelected) else it
                }
                items
            }.await()
            selectedHealthConcerns(healthConcerns)
        }
    }

    private fun selectedHealthConcerns(items: List<HealthConcernVO>) {
        selectedHealthConcerns = items.filter { it.isSelected }
    }
}