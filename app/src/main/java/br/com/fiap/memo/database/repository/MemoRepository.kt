package br.com.fiap.memo.database.repository

import android.content.Context
import br.com.fiap.memo.database.dao.MemoDb
import br.com.fiap.memo.model.Memo

class MemoRepository(context: Context) {
    private val db = MemoDb.getDatabase(context).memoDao()
    fun salvar(Memo: Memo): Long {
        return db.salvar(Memo)
    }
    fun excluir(Memo: Memo): Int {
        return db.excluir(Memo)
    }
    fun listarMemo(): List<Memo> {
        return db.listarMemo()
    }
}