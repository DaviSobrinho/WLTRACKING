package com.example.wltrackingmobile.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class veiculos_clientes (
    @PrimaryKey @ColumnInfo(name ="cpfcliente") val cpfcliente: String,
    @ColumnInfo(name = "placaveiculo") val placaveiculo: String?,
)