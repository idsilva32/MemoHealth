package br.com.fiap.memo.model
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "memo")
data class Memo(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nome: String,
    val dhregistromemo: String,
    val idlembrete: String,
    val idcategoria: String,
    val idorigem: String
)

data class MemoAPI(
    @SerializedName("codigo")           val id:              Int = 0,
    @SerializedName("nome")             val nome:            String = "",
    @SerializedName("dh_registro_memo") val dhregistromemo:  String = "",
    @SerializedName("id_lembrete")      val idlembrete:      String = "",
    @SerializedName("id_categoria")     val idcategoria:     String = "",
    @SerializedName("id_origem")        val idorigem:        String = "",
)
