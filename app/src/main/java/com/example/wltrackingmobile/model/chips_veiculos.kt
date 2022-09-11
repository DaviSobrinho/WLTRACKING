package com.example.wltrackingmobile.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class chips_veiculos(
    @PrimaryKey @ColumnInfo(name ="placaveiculo") val placaveiculo: String,
    @ColumnInfo(name = "imeichip") val imeichip: String?,
)