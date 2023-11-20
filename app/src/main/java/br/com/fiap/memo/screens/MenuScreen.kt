package br.com.fiap.memo.screens
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun MenuScreen(navController: NavController) {
    Box(modifier = Modifier
        .fillMaxSize()
     //   .background(Color(0xFF2C4EC7))
        .padding(32.dp)
    ){
        Text(
            text = "Menu - Cadastros e Pesquisa",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF040C3A)
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
        ) {

            
            Button(
                onClick = { navController.navigate("memo") },
                modifier = Modifier.size(width = 300.dp, height = 55.dp)
            ) {
                Text(text = "Registrar Memo", fontSize = 20.sp, color = Color.White)
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { navController.navigate("Origem") },
                modifier = Modifier.size(width = 300.dp, height = 55.dp)
            ) {
                Text(text = "Origem", fontSize = 20.sp, color = Color.White)
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { navController.navigate("categoria") },
                modifier = Modifier.size(width = 300.dp, height = 55.dp)
            ) {
                Text(text = "Categoria", fontSize = 20.sp, color = Color.White)
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { navController.navigate("lembrete") },
                modifier = Modifier.size(width = 300.dp, height = 55.dp)
            ) {
                Text(text = "Forma Lembrete", fontSize = 20.sp, color = Color.White)
            }


        }
    }
}