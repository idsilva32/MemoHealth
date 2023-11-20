package br.com.fiap.memo.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import br.com.fiap.memo.model.Lembrete

@Dao
interface LembreteDao {

    @Insert
    fun salvar(lembrete: Lembrete): Long

    @Update
    fun atualizar(lembrete: Lembrete): Int

    @Delete
    fun excluir(lembrete: Lembrete): Int

    @Query("SELECT * FROM lembrete WHERE id_lembrete = :id_lembrete")
    fun buscarLembretePeloId(id_lembrete: Int): Lembrete

    @Query("SELECT * FROM lembrete ORDER BY descricao_lembrete ASC")
    fun listarLembrete(): List<Lembrete>

}