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
import androidx.compose.material3.Divider
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.lab5.ui.theme.Lab5Theme

@Composable
fun ListScreen(navController: NavController = rememberNavController()) {
    val imageIds = listOf(
        R.drawable.image_fx_,
        R.drawable.image_fx_1,
        R.drawable.image_fx_2,
        R.drawable.image_fx_3,
        R.drawable.image_fx_4,
        R.drawable.image_fx_5,
        R.drawable.image_fx_6,
        R.drawable.image_fx_7,
        R.drawable.image_fx_8,
        R.drawable.image_fx_9
    )

    LazyColumn (modifier = Modifier
        .padding(top = 35.dp)
        .background(color = Color.White)) {
        items(imageIds.size) { index ->
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
                        painter = painterResource(id = R.drawable.flecha),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
            Divider(modifier = Modifier
                .fillMaxWidth())
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListScreenPreview() {
    Lab5Theme {
        ListScreen()
    }
}