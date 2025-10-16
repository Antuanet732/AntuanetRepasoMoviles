package com.c_antuanet.AppUEREPASO1162003.presentation.favorites


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.c_antuanet.AppUEREPASO1162003.data.local.FavoriteCountryEntity
import com.c_antuanet.AppUEREPASO1162003.data.repository.FavoriteRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class FavoritesViewModel
    (private val repository: FavoriteRepository) : ViewModel() {

    val favorites: StateFlow<List<FavoriteCountryEntity>>
            = repository.getAll().stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        emptyList()
    )
    fun insertFavorite(country: FavoriteCountryEntity) {
        viewModelScope.launch {
            repository.insert(country)
        }
    }
    fun deleteFavorite(country: FavoriteCountryEntity) {
        viewModelScope.launch {
            repository.delete(country)
        }
    }
}

