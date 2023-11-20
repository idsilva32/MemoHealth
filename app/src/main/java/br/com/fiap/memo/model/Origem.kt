package br.com.fiap.memo.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "origem")
data class Origem(
    @PrimaryKey(autoGenerate = true) val id_origem: Long = 0,
    val descricao_origem: String = "",
)