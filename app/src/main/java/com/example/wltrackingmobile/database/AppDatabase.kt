package com.example.wltrackingmobile.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.wltrackingmobile.database.dao.funcoesdbdao
import com.example.wltrackingmobile.model.chips
import com.example.wltrackingmobile.model.clientes
import com.example.wltrackingmobile.model.rastreadores
import com.example.wltrackingmobile.model.veiculos


@Database(entities = [clientes::class, chips::class, rastreadores::class, veiculos::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase(){
        abstract fun funcoesdbdao(): funcoesdbdao

        companion object {
            fun instancia(context : Context) : AppDatabase {
                return Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "gpsafe_for_galaxym52.db"
                ).allowMainThreadQueries()
                    .build()
            }
        }

}
