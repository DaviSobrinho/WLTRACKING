package com.example.wltrackingmobile.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class veiculos_clientes(
    @PrimaryKey(autoGenerate = true) val id: Long = 0L,
    val placa: String,
    val cpf: String,
)