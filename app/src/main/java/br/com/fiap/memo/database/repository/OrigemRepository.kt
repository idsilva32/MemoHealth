package br.com.fiap.memo.database.repository
import android.content.Context
import br.com.fiap.memo.database.dao.OrigemDb
import br.com.fiap.memo.model.Origem

class OrigemRepository(context: Context) {

    private val db = OrigemDb.getDatabase(context).origemDao()

    fun salvar(Origem: Origem): Long {
        return db.salvar(Origem)
    }

      fun excluir(Origem: Origem): Int {
        return db.excluir(Origem)
    }

    fun listarOrigem(): List<Origem> {
        return db.listarOrigem()
    }
}