package com.linhtetko.dailyvita.ui.screens.onboarding.allergie

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.linhtetko.dailyvita.domain.respositories.AllegicRepository
import com.linhtetko.dailyvita.domain.vos.AllergieVO
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class AllergiesViewModel @Inject constructor(
    private val allergiesRepo: AllegicRepository
) : ViewModel() {

    init {
        getAllergies()
    }

    var allergies by mutableStateOf<List<AllergieVO>>(listOf())
        private set

    var filterAllergies by mutableStateOf<List<AllergieVO>>(listOf())
        private set

    var selectedAllergies by mutableStateOf<List<AllergieVO>>(listOf())
        private set


    var inputAllergy by mutableStateOf("")

    private fun getAllergies() {
        viewModelScope.launch {
            val mAllergies = async(Dispatchers.IO) { allergiesRepo.getAllegics() }.await()
            allergies = mAllergies
        }
    }

    fun filterAllergies(input: String) {
        inputAllergy = input
        if (input.isEmpty()) {
            filterAllergies = listOf()
            return
        }
        val mAllergies =
            allergies.toList()
                .filter { it.name.lowercase(Locale.getDefault()).contains(input.lowercase()) }

        filterAllergies = mAllergies
    }

    fun onSelectedAllergy(allergy: AllergieVO) {
        val temp = selectedAllergies.toMutableList()
        temp.add(allergy)

        filterAllergies("")

        selectedAllergies = temp.distinctBy { it.id }
    }


}