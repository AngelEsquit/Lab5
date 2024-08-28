package com.example.lab5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab5.ui.theme.Lab5Theme

class Description : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab5Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting3(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting3(name: String, modifier: Modifier = Modifier) {
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

    LazyColumn {
        item {
            Row (modifier = Modifier
                .height(350.dp)
                .padding(top = 35.dp)
                .fillMaxWidth()
                .background(color = color1)
            ) {

            }
        }

        item {
            Column (modifier = Modifier
                .height(450.dp)
                .fillMaxWidth()
                .background(color = Color.White)
            ) {
                Text(text = "Title",
                    style = TextStyle(
                        fontSize = 20.sp,
                        color = Color.Black
                    ),
                    modifier = Modifier
                        .padding(20.dp)
                )

                Row (modifier = Modifier.padding(start = 15.dp)){
                    Image(
                        painter = painterResource(id = imageIds[1]),
                        contentDescription = null,
                        modifier = Modifier
                            .size(40.dp)
                    )

                    Text(text = "Fecha",
                        style = TextStyle(
                            fontSize = 15.sp,
                            color = Color.Black
                        ),
                        modifier = Modifier
                            .padding(15.dp)
                            .padding(end = 70.dp)
                    )

                    Text(text = "Hora",
                        style = TextStyle(
                            fontSize = 15.sp,
                            color = Color.Black
                        ),
                        modifier = Modifier
                            .padding(15.dp)
                    )
                }

                Text(text = "About",
                    style = TextStyle(
                        fontSize = 17.sp,
                        color = Color.Black
                    ),
                    modifier = Modifier
                        .padding(15.dp)
                )

                Text(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                    style = TextStyle(
                        fontSize = 15.sp,
                        color = Color.Black
                    ),
                    modifier = Modifier
                        .padding(15.dp)
                )

                Row {
                    Button(onClick = { /*TODO*/ },
                        modifier = Modifier
                            .padding(horizontal = 60.dp)) {
                        Text(text = "Favorito")
                    }
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "Comprar")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    Lab5Theme {
        Greeting3("Android")
    }
}