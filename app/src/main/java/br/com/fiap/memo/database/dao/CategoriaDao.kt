package br.com.fiap.memo.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import br.com.fiap.memo.model.Categoria

@Dao
interface CategoriaDao {

    @Insert
    fun salvar(categoria: Categoria): Long

    @Update
    fun atualizar(categoria: Categoria): Int

    @Delete
    fun excluir(categoria: Categoria): Int

    @Query("SELECT * FROM categoria WHERE id_categoria = :id_categoria")
    fun buscarCategoriaPeloId(id_categoria: Int): Categoria

    @Query("SELECT * FROM categoria ORDER BY descricao_categoria ASC")
    fun listarCategoria(): List<Categoria>

}