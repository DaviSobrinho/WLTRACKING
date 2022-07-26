package com.example.wltrackingmobile.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class clientes(
    @PrimaryKey val cpf: String,
    val id: Long = 0L,
    val nome: String,
    val data: String,
    val valor: String,
    val contrato: String,
    val telefone: String,
    val notas: String,
)