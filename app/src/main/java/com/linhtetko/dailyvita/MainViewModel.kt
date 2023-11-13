package com.linhtetko.dailyvita

import android.app.Application
import android.util.Log.d
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.linhtetko.dailyvita.domain.respositories.DietRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    application: Application,
    private val dietRepository: DietRepository
) : AndroidViewModel(application = application) {
}