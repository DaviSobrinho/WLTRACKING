package com.example.wltrackingmobile.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class chips_clientes(
    @ColumnInfo(name = "imeichip") val imeichip: String?,
    @PrimaryKey @ColumnInfo(name ="cpfcliente") val cpfcliente: String,
)