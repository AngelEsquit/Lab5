package com.example.lab5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.lab5.ui.theme.Lab5Theme

@Composable
fun ProfileScreen(navController: NavController = rememberNavController()) {
    val imageIds = listOf(
        R.drawable.perfil,
        R.drawable.candado,
        R.drawable.campana,
        R.drawable.estrella
    )


    val color1 = Color(0xFF139DC0)

    // Estado del switch
    val isChecked = remember { mutableStateOf(false) }

    Column (modifier = Modifier
        .padding(top = 35.dp)
        .fillMaxSize()
        .background(color = Color.White)
    ) {
        Column (modifier = Modifier
            .height(350.dp)
            .padding(top = 35.dp)
            .fillMaxWidth()
            .background(color = color1),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box (modifier = Modifier.padding(top = 60.dp)){
                Image(
                    painter = painterResource(id = imageIds[0]),
                    contentDescription = null,
                    modifier = Modifier
                        .size(150.dp)
                )
            }

            Text(text = "Angel Esquit",
                style = TextStyle(
                    fontSize = 20.sp,
                    color = Color.White
                ),
                modifier = Modifier
                    .padding(top = 30.dp))
        }

        LazyColumn (modifier = Modifier
            .background(color = Color.White)) {
            items(4) { index ->
                Row (modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .background(color = Color.White),
                    verticalAlignment = Alignment.CenterVertically){
                    Box (modifier = Modifier.padding(start = 15.dp)){
                        Image(
                            painter = painterResource(id = imageIds[index]),
                            contentDescription = null,
                            modifier = Modifier
                                .size(40.dp)
                        )
                    }

                    Column (modifier = Modifier
                        .weight(1f)
                        .fillMaxSize()
                        .padding(vertical = 15.dp)) {
                        Text(
                            text = "Item $index",
                            style = TextStyle(color = Color.Black),
                            modifier = Modifier
                                .padding(start = 20.dp)
                        )
                    }
                    if (index == 2) {
                        Switch(
                            checked = isChecked.value,
                            onCheckedChange = { isChecked.value = it },
                            modifier = Modifier.padding(end = 20.dp)
                        )
                    } else {
                        Box (modifier = Modifier.padding(end = 20.dp)){
                            Image(
                                painter = painterResource(id = R.drawable.flecha),
                                contentDescription = null,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }
                }
                Divider(modifier = Modifier
                    .fillMaxWidth())
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    Lab5Theme {
        ProfileScreen()
    }
}