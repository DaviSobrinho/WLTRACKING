package com.example.wltrackingmobile.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao
import com.example.wltrackingmobile.model.*


@Dao
interface funcoesdbdao {


    @Query("SELECT * FROM clientes")
    fun buscaTodosclientes() :List<clientes>

    @Query("SELECT * FROM clientes WHERE cpf = :cpf")
    fun findClientePorCPF(cpf: String?): List<clientes>

    @Query("Select * from clientes where cpf like :cpf")
    fun getSearchResultsclientes(cpf : String) : LiveData<List<clientes>>

    @Query("SELECT * FROM clientes")
    fun buscaUmclientes() : List<clientes>

    @Insert
    fun salvaclientes(vararg Clientes: clientes)

    @Delete
    fun removeclientes(vararg Clientes: clientes)

    @Update
    fun atualizaclientes(vararg Clientes: clientes)

    @Query("SELECT * FROM chips")
    fun buscaTodoschips() :List<chips>

    @Query("SELECT * FROM chips WHERE imei = :imei")
    fun findChipPorimei(imei: String?): List<chips>

    @Query("Select * from chips where imei like :imei")
    fun getSearchResultschips(imei : String) : LiveData<List<chips>>

    @Query("SELECT * FROM chips")
    fun buscaUm() : List<chips>

    @Insert
    fun salva(vararg Chips: chips)

    @Delete
    fun remove(vararg Chips: chips)

    @Update
    fun atualizachips(vararg Chips: chips)

    @Query("DELETE FROM chips")
    fun nukeTable()

    @Query("SELECT * FROM rastreadores")
    fun buscaTodosrastreadores() :List<rastreadores>

    @Query("SELECT * FROM rastreadores WHERE imei = :imei")
    fun findRastreadoresPorimei(imei: String?): List<rastreadores>

    @Query("Select * from rastreadores where imei like :imei")
    fun getSearchResultsrastreadores(imei : String) : LiveData<List<rastreadores>>

    @Query("SELECT * FROM rastreadores")
    fun buscaUmrastreadores() : List<rastreadores>

    @Insert
    fun salvarastreadores(vararg Rastreadores: rastreadores)

    @Delete
    fun removerastreadores(vararg Rastreadores: rastreadores)

    @Update
    fun atualizarastreadores(vararg Rastreadores: rastreadores)

    @Query("SELECT * FROM veiculos")
    fun buscaTodosveiculos() :List<veiculos>

    @Query("SELECT * FROM veiculos WHERE placa = :placa")
    fun findveiculosPorplaca(placa: String?): List<veiculos>

    @Query("Select * from veiculos where placa like :placa")
    fun getSearchResultsveiculos(placa : String) : LiveData<List<veiculos>>

    @Query("SELECT * FROM veiculos")
    fun buscaUmveiculos() : List<veiculos>

    @Insert
    fun salvaveiculos(vararg Veiculos: veiculos)

    @Delete
    fun removeveiculos(vararg Veiculos: veiculos)

    @Update
    fun atualizaveiculos(vararg Veiculos: veiculos)

    @Query("SELECT * FROM chips_rastreadores")
    fun buscaTodosChipsRastreadores() :List<chips_rastreadores>

    @Query("SELECT * FROM chips_rastreadores WHERE imeichip = :imeichip")
    fun findChipsRastreadoresPorImeiChip(imeichip: String?): List<chips_rastreadores>

    @Query("Select * from chips_rastreadores where imeichip like :imeichip")
    fun getSearchResultsChipsRastreadores(imeichip : String) : LiveData<List<chips_rastreadores>>

    @Query("SELECT * FROM chips_rastreadores")
    fun buscaUmChipsRastreadores() : List<chips_rastreadores>

    @Insert
    fun salvaChipsRastreadores(vararg ChipsRastreadores: chips_rastreadores)

    @Delete
    fun removeChipsRastreadores(vararg ChipsRastreadores: chips_rastreadores)

    @Update
    fun atualizaChipsRastreadores(vararg ChipsRastreadores: chips_rastreadores)
}