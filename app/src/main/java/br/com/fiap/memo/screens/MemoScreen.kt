package br.com.fiap.memo.screens

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.memo.database.repository.MemoRepository
import br.com.fiap.memo.model.Memo
import android.util.Log


@Composable
fun MemosScreen() {
    val context = LocalContext.current
    val memoRepository = MemoRepository(context)

    val nomeState = remember {
        mutableStateOf("")
    }

    val dataregistroState = remember {
        mutableStateOf("")
    }
    val lembreteState = remember {
        mutableStateOf("")
    }
    val categoriaState = remember {
        mutableStateOf("")
    }
    val origemState = remember {
        mutableStateOf("")
    }
    val listaMemosState = remember {
        mutableStateOf(memoRepository.listarMemo())
    }

    Column {
        MemoForm(
            nome = nomeState.value,
            dataregistro = dataregistroState.value,
            lembrete = lembreteState.value,
            categoria = categoriaState.value,
            origem = origemState.value,

            onNomeChange = {
                nomeState.value = it
            },

            onDataregistroChange = {
                dataregistroState.value = it
            },
            onLembreteChange = {
                lembreteState.value = it
            },
            onCategoriaChange = {
                categoriaState.value = it
            },
            onOrigemChange = {
                origemState.value = it
            },
            atualizar = {
                listaMemosState.value = memoRepository.listarMemo()
            }
        )
        MemoList(listaMemosState.value) {
            listaMemosState.value = memoRepository.listarMemo()
        }
    }
}


@Composable
fun MemoCard(memo: Memo, context: Context, atualizar: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color.LightGray
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .padding(8.dp)
                    .weight(2f)
            ) {
                Text(
                    text = memo.nome,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                )


                Text(
                    text = memo.dhregistromemo,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                )
                Text(
                    text = memo.idlembrete,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                )
                Text(
                    text = memo.idcategoria,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                )
            }
            IconButton(onClick = {
                val memoRepository = MemoRepository(context)
                memoRepository.excluir(memo)
                atualizar()
            }) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = ""
                )
            }
        }
    }
}



@Composable
fun MemoList(memos: List<Memo>, atualizar: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        for (lembrete in memos) {
            MemoCard(lembrete, context = LocalContext.current, atualizar)
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MemoForm(
    nome: String,
    dataregistro: String,
    lembrete: String,
    categoria: String,
    origem: String,

    onNomeChange: (String) -> Unit,
    onDataregistroChange: (String) -> Unit,
    onLembreteChange: (String) -> Unit,
    onCategoriaChange: (String) -> Unit,
    onOrigemChange: (String) -> Unit,
    atualizar: () -> Unit,

) {
    // Obter instância do repositório
    val context = LocalContext.current
    val memoRepository = MemoRepository(context)

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = "Cadastro de Memo",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF040C3A)
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = nome,
            onValueChange = { onNomeChange(it) },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Legenda")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                capitalization = KeyboardCapitalization.Words
            )
        )
        OutlinedTextField(
            value = dataregistro,
            onValueChange = { onDataregistroChange(it) },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Data do Registro")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                capitalization = KeyboardCapitalization.Words
            )
        )
        OutlinedTextField(
            value = lembrete,
            onValueChange = { onLembreteChange(it) },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Forma lembrete")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Phone
            )
        )
        OutlinedTextField(
            value = categoria,
            onValueChange = { onCategoriaChange(it) },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Categoria")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Phone
            )
        )
        OutlinedTextField(
            value = origem,
            onValueChange = { onOrigemChange(it) },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Origem")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Phone
            )
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = {
                val memo = Memo(
                    nome = nome,
                    dhregistromemo = dataregistro,
                    idlembrete = lembrete,
                    idcategoria = categoria,
                    idorigem = origem
                )
                memoRepository.salvar(memo)
                atualizar()
                Log.d("MemoForm", "Botão de cadastro clicado")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Cadastrar",
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}
