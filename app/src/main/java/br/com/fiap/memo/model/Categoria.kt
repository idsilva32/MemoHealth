package br.com.fiap.memo.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categoria")
data class Categoria(
    @PrimaryKey(autoGenerate = true) val id_categoria: Long = 0,
    val descricao_categoria: String = "",
)