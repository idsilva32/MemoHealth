package br.com.fiap.memo.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lembrete")
data class Lembrete(
    @PrimaryKey(autoGenerate = true) val id_lembrete: Long = 0,
    val descricao_lembrete: String = "",
)