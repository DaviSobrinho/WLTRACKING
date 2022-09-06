package com.example.wltrackingmobile.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.wltrackingmobile.database.dao.funcoesdbdao
import com.example.wltrackingmobile.model.*


@Database(entities = [veiculos_clientes::class, rastreadores_veiculos::class,
    chips_rastreadores::class, clientes::class, chips_clientes::class,
    chips_veiculos::class, rastreadores_clientes::class,
    chips::class, rastreadores::class, veiculos::class],
    version = 2, exportSchema = true)
abstract class AppDatabase : RoomDatabase(){
        abstract fun funcoesdbdao(): funcoesdbdao

        companion object {
            fun instancia(context : Context) : AppDatabase {
                return Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "wltrackingmobile.db"
                ).allowMainThreadQueries()
                    .build()
            }
        }

}
