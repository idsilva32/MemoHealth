package br.com.fiap.memo.screens
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.memo.model.MemoAPI
import br.com.fiap.memo.service.RetrofitFactory
import br.com.fiap.memo.ui.theme.MemoTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MemoTheme {
                MemoScreenAPI()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MemoScreenAPI() {
    var listaMemoState by remember { mutableStateOf(listOf<MemoAPI>()) }
    Text(
        text = "Memos cadastrados - Retornado da API",
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF040C3A)
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        IconButton(onClick = {
            // Chame a API e atualize a lista de Endereco
            val call = RetrofitFactory()
                .getMemoService()
                .getMemo()
            call.enqueue(object : Callback<List<MemoAPI>?> {
                override fun onResponse(call: Call<List<MemoAPI>?>, response: Response<List<MemoAPI>?>) {
                    val data = response.body()
                    if (response.isSuccessful && data != null) {
                        listaMemoState = data
                        Log.d("API", "Chamada à API bem-sucedida. ${data.size} resultados recebidos.")
                    } else {
                        Log.d("API", "Chamada à API bem-sucedida, mas nenhum dado retornado.")
                    }
                }

                override fun onFailure(call: Call<List<MemoAPI>?>, t: Throwable) {
                    Log.e("API", "Erro na chamada à API: ${t.message}")
                }
            })

        }) {
            Icon(imageVector = Icons.Default.Search, contentDescription = "Pesquisar")
        }

        Spacer(modifier = Modifier.height(8.dp))

        LazyColumn {
            items(listaMemoState.filterNotNull()) { endereco ->
                CardMemoAPI(endereco)
            }
        }
    }
}

@Composable
fun CardMemoAPI(memo: MemoAPI) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(bottom = 4.dp)) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
        )
        {
            Text("Nome: "   +  memo.nome)
            Text("Registro: "  +  memo.dhregistromemo)
            Text("Categoria: " +  memo.idcategoria)
            Text("Origem: "    +  memo.idorigem)
            Text("Forma Lembrete: "     +  memo.idlembrete)
        }
    }
}

