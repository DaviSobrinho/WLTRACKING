package com.example.wltrackingmobile.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class rastreadores_veiculos(
    @PrimaryKey @ColumnInfo(name = "imeirastreador") val imeirastreador: String,
    @ColumnInfo(name ="placaveiculo") val placaveiculo: String?,
)