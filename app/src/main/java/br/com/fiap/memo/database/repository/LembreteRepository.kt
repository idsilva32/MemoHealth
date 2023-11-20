package br.com.fiap.memo.database.repository

import android.content.Context
import br.com.fiap.memo.database.dao.LembreteDb
import br.com.fiap.memo.model.Lembrete

class LembreteRepository(context: Context) {
    private val db = LembreteDb.getDatabase(context).lembreteDao()
    fun salvar(Lembrete: Lembrete): Long {
        return db.salvar(Lembrete)
    }
    fun excluir(Lembrete: Lembrete): Int {
        return db.excluir(Lembrete)
    }
    fun listarLembrete(): List<Lembrete> {
        return db.listarLembrete()
    }
}