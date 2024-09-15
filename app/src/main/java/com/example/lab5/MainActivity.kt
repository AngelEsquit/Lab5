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
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.example.lab5.ui.theme.Lab5Theme
import com.example.lab5.AppNavigation

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            Lab5Theme {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { Text(text = "TodoEventos", modifier = Modifier.padding(start = 5.dp)) },
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = Color(0xFF139DC0), // Color de fondo
                                titleContentColor = Color.White, // Color del título
                                actionIconContentColor = Color.White // Color de los iconos
                            )
                        )
                    }) { innerPadding ->
                    AppNavigation(navController = navController, innerPadding = innerPadding)
                }
            }
        }
    }
}

@Composable
fun HomeScreen(navController: NavController = rememberNavController()) {
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

    val imageIdsFavorites = listOf(
        R.drawable.image_fx_1,
        R.drawable.image_fx_3,
        R.drawable.image_fx_5,
        R.drawable.image_fx_6,
        R.drawable.image_fx_8
    )

    val systemUiController = rememberSystemUiController()
    val color1 = Color(0xFF139DC0)
    val color2 = Color(0xAB13BAC0)

    systemUiController.setSystemBarsColor(
        color = color1,
        darkIcons = false
    )

    Column (modifier = Modifier
        .background(color = Color.White)
        .padding(bottom = 10.dp)) {

        LazyColumn (modifier = Modifier
            .background(color = Color.White)
            .fillMaxWidth()
        ) {
            item {
                Row (modifier = Modifier
                    .background(color = Color.White)
                    .fillMaxWidth()
                    .height(90.dp)
                    .padding(horizontal = 20.dp),
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

            items(imageIdsFavorites.chunked(2)) { rowImages ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    rowImages.forEach { imageId ->
                        Card(
                            modifier = Modifier
                                .weight(1f)
                                .heightIn(min = 135.dp)
                        ) {
                            Column (modifier = Modifier
                                .fillMaxSize()){
                                // Imagen
                                Row (modifier = Modifier
                                    .fillMaxWidth(),
                                    horizontalArrangement = Arrangement.Center) {
                                    Image(
                                        painter = painterResource(id = imageId),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .padding(8.dp)
                                    )
                                }

                                // Título
                                Row (modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 12.dp)) {
                                    Text(text = "Title",
                                        style = TextStyle(color = Color.White,
                                            fontSize = 18.sp),
                                        modifier = Modifier
                                            .padding(bottom = 10.dp))
                                }

                                // Descripción
                                Row (modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 12.dp)) {
                                    Text(text = "Desc",
                                        style = TextStyle(color = Color.White,
                                            fontSize = 13.sp),
                                        modifier = Modifier
                                            .padding(bottom = 10.dp))
                                }
                            }
                        }
                    }
                }
            }

            item {
                Row (modifier = Modifier
                    .background(color = Color.White)
                    .fillMaxWidth()
                    .height(90.dp)
                    .padding(horizontal = 20.dp),
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

            items(imageIds.chunked(2)) { rowImages ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    rowImages.forEach { imageId ->
                        Card(
                            modifier = Modifier
                                .weight(1f)
                                .heightIn(min = 135.dp)
                        ) {
                            Column (modifier = Modifier
                                .fillMaxSize()){
                                // Imagen
                                Row (modifier = Modifier
                                    .fillMaxWidth(),
                                    horizontalArrangement = Arrangement.Center) {
                                    Image(
                                        painter = painterResource(id = imageId),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .padding(8.dp)
                                    )
                                }

                                // Título
                                Row (modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 12.dp)) {
                                    Text(text = "Title",
                                        style = TextStyle(color = Color.White,
                                            fontSize = 18.sp),
                                        modifier = Modifier
                                            .padding(bottom = 10.dp))
                                }

                                // Descripción
                                Row (modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 12.dp)) {
                                    Text(text = "Desc",
                                        style = TextStyle(color = Color.White,
                                            fontSize = 13.sp),
                                        modifier = Modifier
                                            .padding(bottom = 10.dp))
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    Lab5Theme {
        HomeScreen()
    }
}