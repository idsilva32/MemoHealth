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
import br.com.fiap.memo.database.repository.LembreteRepository
import br.com.fiap.memo.model.Lembrete

@Composable
fun LembretesScreen() {
    val context = LocalContext.current
    val lembreteRepository = LembreteRepository(context)

    val descricao_lembreteState = remember {
        mutableStateOf("")
    }
    val listaLembretesState = remember {
        mutableStateOf(lembreteRepository.listarLembrete())
    }

    Column {
        LembreteForm(
            descricao_lembrete = descricao_lembreteState.value,
            onDescricao_lembreteChange = {
                descricao_lembreteState.value= it
            },
            atualizar = {
                listaLembretesState.value = lembreteRepository.listarLembrete()
            }
        )
        LembreteList(listaLembretesState.value){
            listaLembretesState.value = lembreteRepository.listarLembrete()
        }
    }
}

@Composable
fun LembreteCard(lembrete: Lembrete, context: Context, atualizar: () -> Unit) {
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
                    text = lembrete.descricao_lembrete,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            IconButton(onClick = {
                val lembreteRepository = LembreteRepository(context)
                lembreteRepository.excluir(lembrete)
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
fun LembreteList(lembretes: List<Lembrete>, atualizar: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        for (lembrete in lembretes) {
            LembreteCard(lembrete, context = LocalContext.current, atualizar)
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LembreteForm(
    descricao_lembrete: String,
    onDescricao_lembreteChange: (String) -> Unit,
    atualizar: () -> Unit,
) {
    // Aqui a variável lembreteRepository está disponível
    val lembreteRepository = LembreteRepository(LocalContext.current)

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = "Cadastro de Lembrete",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF040C3A)
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = descricao_lembrete,
            onValueChange = { onDescricao_lembreteChange(it) },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Nome do Lembrete")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                capitalization = KeyboardCapitalization.Words
            )
        )

        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                val lembrete = Lembrete(
                    descricao_lembrete = descricao_lembrete,
                )
                lembreteRepository.salvar(Lembrete = lembrete)
                atualizar()
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





