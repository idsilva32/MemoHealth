package br.com.fiap.memo.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import br.com.fiap.memo.model.Memo

@Dao
interface MemoDao {

    @Insert
    fun salvar(memo: Memo): Long

    @Update
    fun atualizar(memo: Memo): Int

    @Delete
    fun excluir(memo: Memo): Int

    @Query("SELECT * FROM memo WHERE id = :id")
    fun buscarMemoPeloId(id: Int): Memo

    @Query("SELECT * FROM memo ORDER BY nome ASC")
    fun listarMemo(): List<Memo>

}