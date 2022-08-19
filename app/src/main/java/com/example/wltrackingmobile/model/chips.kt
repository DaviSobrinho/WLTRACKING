package com.example.wltrackingmobile.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class chips(
    @PrimaryKey val imei: String,
    val id: Long = 0L,
    val estado: String = "1",
    val modelo: String = "1",
    val telefone: String = "1",
    val custo: String = "1",
    val dia: String = "1",
    val notas: String ="1"
)