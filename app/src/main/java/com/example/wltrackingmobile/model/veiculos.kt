package com.example.wltrackingmobile.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class veiculos(
    @PrimaryKey val placa: String,
    val id: Long = 0L,
    val modelo: String,
    val ano: String,
)