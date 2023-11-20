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
import br.com.fiap.memo.database.repository.CategoriaRepository
import br.com.fiap.memo.model.Categoria

@Composable
fun CategoriasScreen() {

    val context = LocalContext.current
    val categoriaRepository = CategoriaRepository(context)

    val descricao_categoriaState = remember {
        mutableStateOf("")
    }
    val listaCategoriasState = remember {
        mutableStateOf(categoriaRepository.listarCategoria())
    }

    Column {
        CategoriaForm(
            descricao_categoria = descricao_categoriaState.value,
            onDescricao_categoriaChange = {
                descricao_categoriaState.value= it
            },
            atualizar = {
                listaCategoriasState.value = categoriaRepository.listarCategoria()
            }
        )
        CategoriaList(listaCategoriasState.value){
            listaCategoriasState.value = categoriaRepository.listarCategoria()
        }
    }
}

@Composable
fun CategoriaCard(categoria: Categoria, context: Context, atualizar: () -> Unit) {
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
                    text = categoria.descricao_categoria,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            IconButton(onClick = {
                val categoriaRepository = CategoriaRepository(context)
                categoriaRepository.excluir(categoria)
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
fun CategoriaList(categorias: List<Categoria>, atualizar: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        for (categoria in categorias) {
            CategoriaCard(categoria, context = LocalContext.current, atualizar)
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoriaForm(

    descricao_categoria: String,

    onDescricao_categoriaChange: (String) -> Unit,
    atualizar: () -> Unit,

    ) {
    // obter instância do repositório
    val context = LocalContext.current
    val categoriaRepository = CategoriaRepository(context)

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(

            text = "Cadastro de categoria",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF040C3A)
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = descricao_categoria,
            onValueChange = { onDescricao_categoriaChange(it) },
            modifier = Modifier.fillMaxWidth(),
            label = {
                Text(text = "Nome da categoria")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                capitalization = KeyboardCapitalization.Words
            )
        )

        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                val categoria = Categoria(
                    descricao_categoria = descricao_categoria,
                )
                categoriaRepository.salvar(Categoria = categoria)
                atualizar()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Cadastrar",
                modifier = Modifier.padding(8.dp)
                //modifier = Modifier.size(width = 200.dp, height = 48.dp)
            )

        }
    }
}





