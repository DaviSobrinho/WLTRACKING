package com.example.wltrackingmobile.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.wltrackingmobile.model.*


@Dao
interface funcoesdbdao {


    // Funções Chips


    @Query("SELECT * FROM clientes")
    fun buscaTodosclientes() :List<clientes>

    @Query("SELECT * FROM clientes WHERE cpf = :cpf")
    fun findClientePorCPF(cpf: String?): List<clientes>

    @Insert
    fun salvaclientes(vararg Clientes: clientes)

    @Delete
    fun removeclientes(vararg Clientes: clientes)

    @Update
    fun atualizaclientes(vararg Clientes: clientes)


    // Funções Chips_Rastreadores


    @Query("SELECT * FROM chips")
    fun buscaTodoschips() :List<chips>

    @Query("SELECT * FROM chips WHERE imei = :imei")
    fun findChipPorimei(imei: String?): List<chips>

    @Insert
    fun salva(vararg Chips: chips)

    @Delete
    fun remove(vararg Chips: chips)

    @Update
    fun atualizachips(vararg Chips: chips)


    // Funções Rastreadores


    @Query("SELECT * FROM rastreadores")
    fun buscaTodosrastreadores() :List<rastreadores>

    @Query("SELECT * FROM rastreadores WHERE imei = :imei")
    fun findRastreadoresPorimei(imei: String?): List<rastreadores>

    @Insert
    fun salvarastreadores(vararg Rastreadores: rastreadores)

    @Delete
    fun removerastreadores(vararg Rastreadores: rastreadores)

    @Update
    fun atualizarastreadores(vararg Rastreadores: rastreadores)


    // Funções Veiculos


    @Query("SELECT * FROM veiculos")
    fun buscaTodosveiculos() :List<veiculos>

    @Query("SELECT * FROM veiculos WHERE placa = :placa")
    fun findveiculosPorplaca(placa: String?): List<veiculos>

    @Insert
    fun salvaveiculos(vararg Veiculos: veiculos)

    @Delete
    fun removeveiculos(vararg Veiculos: veiculos)

    @Update
    fun atualizaveiculos(vararg Veiculos: veiculos)


    // Funções Chips_Rastreadores


    @Query("SELECT * FROM chips_rastreadores")
    fun buscaTodosChipsRastreadores() :List<chips_rastreadores>

    @Query("SELECT imeirastreador FROM chips_rastreadores where imeichip like :imeichip")
    fun findChipsRastreadoresPorImeiChip(imeichip: String): String?

    @Query("SELECT imeichip FROM chips_rastreadores where imeirastreador like :imeirastreador")
    fun findChipsRastreadoresPorImeiRastreador(imeirastreador: String): String?

    @Insert
    fun salvaChipsRastreadores(vararg ChipsRastreadores: chips_rastreadores)

    @Delete
    fun removeChipsRastreadores(vararg ChipsRastreadores: chips_rastreadores)

    @Update
    fun atualizaChipsRastreadores(vararg ChipsRastreadores: chips_rastreadores)


    // Funções Chips_Clientes


    @Query("SELECT * FROM chips_clientes")
    fun buscaTodosChipsClientes() :List<chips_clientes>

    @Query("SELECT cpfcliente FROM chips_clientes where imeichip like :imeichip")
    fun findChipsClientesporImeiChip(imeichip: String): String?

    @Query("SELECT imeichip FROM chips_clientes where cpfcliente like :cpfcliente")
    fun findChipsClientesPorCpfCliente(cpfcliente: String): String?

    @Insert
    fun salvaChipsClientes(vararg ChipsClientes: chips_clientes)

    @Delete
    fun removeChipsClientes(vararg ChipsClientes: chips_clientes)

    @Update
    fun atualizaChipsClientes(vararg ChipsClientes: chips_clientes)


    // Funções Chips_Veiculos


    @Query("SELECT * FROM chips_veiculos")
    fun buscaTodosChipsVeiculos() :List<chips_veiculos>

    @Query("SELECT placaveiculo FROM chips_veiculos where imeichip like :imeichip")
    fun findChipsVeiculosporImeiChip(imeichip: String): String?

    @Query("SELECT imeichip FROM chips_veiculos where placaveiculo like :placaveiculo")
    fun findChipsVeiculosPorPlacaVeiculo(placaveiculo: String): String?

    @Insert
    fun salvaChipsVeiculos(vararg ChipsVeiculos: chips_veiculos)

    @Delete
    fun removeChipsVeiculos(vararg ChipsVeiculos: chips_veiculos)

    @Update
    fun atualizaChipsVeiculos(vararg ChipsVeiculos: chips_veiculos)


    // Funções Rastreadores_Clientes


    @Query("SELECT * FROM rastreadores_clientes")
    fun buscaRastreadoresClientes() :List<rastreadores_clientes>

    @Query("SELECT cpfcliente FROM rastreadores_clientes where imeirastreador like :imeirastreador")
    fun findRastreadoresClientesporImeiRastreador(imeirastreador: String): String?

    @Query("SELECT imeirastreador FROM rastreadores_clientes where cpfcliente like :cpfcliente")
    fun findRastreadoresClientesPorCpfCliente(cpfcliente: String): String?

    @Insert
    fun salvaRastreadoresClientes(vararg RastreadoresClientes: rastreadores_clientes)

    @Delete
    fun removeRastreadoresClientes(vararg RastreadoresClientes: rastreadores_clientes)

    @Update
    fun atualizaRastreadoresClientes(vararg RastreadoresClientes: rastreadores_clientes)


    // Funções Rastreadores_Veiculos


    @Query("SELECT * FROM rastreadores_veiculos")
    fun buscaRastreadoresVeiculos() :List<rastreadores_veiculos>

    @Query("SELECT imeirastreador FROM rastreadores_veiculos where placaveiculo like :placaveiculo")
    fun findRastreadoresVeiculosPorPlacaVeiculo(placaveiculo: String): String?

    @Query("SELECT placaveiculo FROM rastreadores_veiculos where imeirastreador like :imeirastreador")
    fun findRastreadoresVeiculosPorImeiRastreador(imeirastreador: String): String?

    @Insert
    fun salvaRastreadoresVeiculos(vararg RastreadoresVeiculos: rastreadores_veiculos)

    @Delete
    fun removeRastreadoresVeiculos(vararg RastreadoresVeiculos: rastreadores_veiculos)

    @Update
    fun atualizaRastreadoresVeiculos(vararg RastreadoresVeiculos: rastreadores_veiculos)


    // Funções Veiculos_Clientes


    @Query("SELECT * FROM veiculos_clientes")
    fun buscaVeiculosClientes() :List<veiculos_clientes>

    @Query("SELECT cpfcliente FROM veiculos_clientes where placaveiculo like :placaveiculo")
    fun findVeiculosClientesPorPlacaVeiculo(placaveiculo: String): String?

    @Query("SELECT placaveiculo FROM veiculos_clientes where cpfcliente like :cpfcliente")
    fun findVeiculosClientesPorCpfCliente(cpfcliente: String): String?

    @Insert
    fun salvaVeiculosClientes(vararg VeiculosClientes: veiculos_clientes)

    @Delete
    fun removeVeiculosClientes(vararg VeiculosClientes: veiculos_clientes)

    @Update
    fun atualizaVeiculosClientes(vararg VeiculosClientes: veiculos_clientes)

}