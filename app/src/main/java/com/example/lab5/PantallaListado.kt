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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab5.ui.theme.Lab5Theme

class PantallaListado : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab5Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting2(
                        name = "Android A",
                        modifier = Modifier.padding(innerPadding).background(color = Color.White)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
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

    LazyColumn (modifier = Modifier
        .padding(top = 35.dp)
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

                    Text(
                        text = "Desc",
                        style = TextStyle(color = Color.Black),
                        modifier = Modifier
                            .weight(1f)
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

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    Lab5Theme {
        Greeting2("Android")
    }
}