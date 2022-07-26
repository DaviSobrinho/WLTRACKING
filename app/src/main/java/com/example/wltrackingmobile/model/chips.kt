package com.example.wltrackingmobile.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class chips(
    @PrimaryKey val imei: String,
    val id: Long = 0L,
    val estado: String,
    val modelo: String,
    val telefone: String,
    val custo: String,
    val dia: String,
)