package com.c_antuanet.AppUEREPASO1162003.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorite_countries")
data class FavoriteCountryEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val ranking: Int,
    val imageUrl: String
)