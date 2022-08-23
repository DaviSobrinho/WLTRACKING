package com.example.wltrackingmobile.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class rastreadores(
    @PrimaryKey val imei: String,
    val id: Long = 0L,
    val modelo: String,
    val estado: String,
    val local: String,
    val notas: String,
)