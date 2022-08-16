package com.example.wltrackingmobile.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class rastreadores_veiculos(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    val imeirastreador: String,
    val placa: String,
)