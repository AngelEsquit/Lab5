package com.example.lab5

import android.content.ClipData.Item
import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.example.lab5.ui.theme.Lab5Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab5Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier
                            .padding(innerPadding)
                            .systemBarsPadding()
                    )
                }
            }
        }
    }
}


@Composable
fun Greeting(modifier: Modifier = Modifier) {
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

    val imageIdsFavorites = listOf(
        R.drawable.icon_1_background,
        R.drawable.icon_3_background,
        R.drawable.icon_5_background,
        R.drawable.icon_8_background,
        R.drawable.icon_9_background
    )

    val systemUiController = rememberSystemUiController()
    val color1 = Color(0xFF139DC0)
    val color2 = Color(0xAB13BAC0)
    Column {
        Row (modifier = Modifier
            .background(color = color1)
            .fillMaxWidth()
            .height(95.dp)
            .padding(top = 30.dp, start = 25.dp, end = 25.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(modifier = Modifier,
                text = "TodoEventos",
                style = TextStyle(
                    fontSize = 21.sp,
                    color = Color.White
                )
            )
        }

        LazyColumn (modifier = Modifier
            .background(color = Color.White)
            .fillMaxWidth()
        ) {
            systemUiController.setSystemBarsColor(
                color = color1,
                darkIcons = false
            )

            item {
                Row (modifier = Modifier
                    .background(color = Color.White)
                    .fillMaxWidth()
                    .height(90.dp)
                    .padding(start = 25.dp, end = 25.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(modifier = Modifier,
                        text = "Tus favoritos",
                        style = TextStyle(
                            fontSize = 19.sp,
                            color = Color.Black
                        )
                    )
                }
            }

            var countElements = 3

            val adjustedCount = if (countElements % 2 != 0) countElements + 1 else countElements

            item {
                LazyVerticalGrid(columns = GridCells.Fixed(2),
                    modifier = Modifier
                        .padding(start = 20.dp, end = 20.dp)
                        .height(((adjustedCount / 2) * 180).dp)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                    items(countElements) {index ->
                        val imageId = imageIds[index % imageIds.size]

                        Card (modifier = Modifier
                            .fillMaxHeight()){
                            Image(
                                painter = painterResource(id = imageId),
                                contentDescription = null,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(15.dp)
                            )
                            Text(modifier = Modifier.padding(horizontal = 15.dp),
                                text = "Item $index")
                        }
                    }
                }
            }

            item {
                Row (modifier = Modifier
                    .background(color = Color.White)
                    .fillMaxWidth()
                    .height(90.dp)
                    .padding(start = 25.dp, end = 25.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(modifier = Modifier,
                        text = "Todos los eventos",
                        style = TextStyle(
                            fontSize = 19.sp,
                            color = Color.Black
                        )
                    )
                }
            }

            var countElements2 = 10

            val adjustedCount2 = if (countElements2 % 2 != 0) countElements2 + 1 else countElements2

            item {
                LazyVerticalGrid(columns = GridCells.Fixed(2),
                    modifier = Modifier
                        .padding(start = 20.dp, end = 20.dp, bottom = 32.dp)
                        .height(((adjustedCount2 / 2) * 95).dp)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                    items(countElements2) {index ->
                        Card (modifier = Modifier.height(75.dp)){
                            Text(text = "Item $index")
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab5Theme {
        Greeting()
    }
}