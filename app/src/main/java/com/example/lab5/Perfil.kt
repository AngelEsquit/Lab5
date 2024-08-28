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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab5.ui.theme.Lab5Theme

class Perfil : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab5Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting4(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting4(name: String, modifier: Modifier = Modifier) {
    val imageIds = listOf(
        R.drawable.icon_2_background,
        R.drawable.icon_3_background,
        R.drawable.icon_4_background,
        R.drawable.icon_5_background,
        R.drawable.icon_6_background,
        R.drawable.icon_7_background,
        R.drawable.icon_8_background,
        R.drawable.icon_9_background,
        R.drawable.icon_10_background
    )


    val color1 = Color(0xFF139DC0)

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
                    painter = painterResource(id = imageIds[1]),
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
            items(5) { index ->
                Row (modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .background(color = Color.White)
                    .border(width = 2.dp, color = Color.Black),
                    verticalAlignment = Alignment.CenterVertically){
                    Box (modifier = Modifier.padding(start = 15.dp)){
                        Image(
                            painter = painterResource(id = imageIds[index % imageIds.size]),
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

                    Box (modifier = Modifier.padding(end = 20.dp)){
                        Image(
                            painter = painterResource(id = imageIds[index % imageIds.size]),
                            contentDescription = null,
                            modifier = Modifier.size(40.dp)
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview4() {
    Lab5Theme {
        Greeting4("Android")
    }
}