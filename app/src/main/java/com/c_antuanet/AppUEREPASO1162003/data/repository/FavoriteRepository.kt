package com.c_antuanet.AppUEREPASO1162003.data.repository

import com.c_antuanet.AppUEREPASO1162003.data.local.FavoriteCountryDao
import com.c_antuanet.AppUEREPASO1162003.data.local.FavoriteCountryEntity
import kotlinx.coroutines.flow.Flow

class FavoriteRepository (private val dao: FavoriteCountryDao) {

    suspend fun insert(country: FavoriteCountryEntity)
            = dao.insertFavoriteCountry(country)

    suspend fun delete(country: FavoriteCountryEntity)
            = dao.deleteFavoriteCountry(country)

    fun getAll(): Flow<List<FavoriteCountryEntity>>
            = dao.getAll()





}