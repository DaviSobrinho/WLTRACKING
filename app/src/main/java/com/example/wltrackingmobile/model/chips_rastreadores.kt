package com.example.wltrackingmobile.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity
class chips_rastreadores(
    @PrimaryKey @ColumnInfo(name = "imeichip") val imeichip: String,
    @ColumnInfo(name ="imeirastreador") val imeirastreador: String?,
)