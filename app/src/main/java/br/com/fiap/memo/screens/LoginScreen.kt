package br.com.fiap.memo.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.com.fiap.memo.R
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.*

@Composable
fun LoginScreen(navController: NavHostController) {
    val backgroundImage = painterResource(id = R.drawable.logomemo)
    Box(
        modifier = Modifier
            .size(100.dp, 100.dp) // Substitua esses valores pelos desejados
    ) {
        Image(
            painter = painterResource(id = R.drawable.logomemo),
            contentDescription = null, // Adicione uma descrição se necessário
            modifier = Modifier
                .fillMaxSize() // Para preencher todo o espaço do Box
                .clip(shape = CircleShape) // Opcional: para um formato de círculo, por exemplo
        )
    }
    // Conteúdo da tela de login
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.Transparent) // Para que o fundo não fique opaco
    ) {
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = stringResource(id = R.string.login),
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF040C3A),
            modifier = Modifier
                .padding(start = 40.dp) // Ajuste o valor conforme necessário

        )
        Text(text = stringResource(id = R.string.subtitle))
        Spacer(modifier = Modifier.height(48.dp))

        Spacer(modifier = Modifier.height(70.dp))

        // Adicione um Spacer com uma altura maior aqui
        Spacer(modifier = Modifier.height(340.dp))

        Button(
            onClick = {
                // Simplesmente navegue para a próxima tela
                navController.navigate("menu")
            }
        ) {
            Text(
                text = stringResource(id = R.string.enter),
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
    }
}

