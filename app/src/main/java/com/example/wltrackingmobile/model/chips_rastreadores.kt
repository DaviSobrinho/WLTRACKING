package com.example.wltrackingmobile.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class chips_rastreadores(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    val imeichip: String,
    val imeirastreador: String,
)