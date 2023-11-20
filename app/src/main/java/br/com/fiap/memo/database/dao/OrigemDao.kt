package br.com.fiap.memo.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import br.com.fiap.memo.model.Origem

@Dao
interface OrigemDao {

    @Insert
    fun salvar(origem: Origem): Long

    @Update
    fun atualizar(origem: Origem): Int

    @Delete
    fun excluir(origem: Origem): Int

    @Query("SELECT * FROM origem WHERE id_origem = :id_origem")
    fun buscarOrigemPeloId(id_origem: Int): Origem

    @Query("SELECT * FROM origem ORDER BY descricao_origem ASC")
    fun listarOrigem(): List<Origem>

}