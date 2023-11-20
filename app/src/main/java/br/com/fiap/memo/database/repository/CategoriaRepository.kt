package br.com.fiap.memo.database.repository

import android.content.Context
import br.com.fiap.memo.database.dao.CategoriaDb
import br.com.fiap.memo.model.Categoria

class CategoriaRepository(context: Context) {
    private val db = CategoriaDb.getDatabase(context).categoriaDao()
    fun salvar(Categoria: Categoria): Long {
        return db.salvar(Categoria)
    }
      fun excluir(Categoria: Categoria): Int {
        return db.excluir(Categoria)
    }
    fun listarCategoria(): List<Categoria> {
        return db.listarCategoria()
    }
}