package com.example.lab5

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.lab5.ui.theme.Lab5Theme

@Composable
fun DescriptionScreen(navController: NavController = rememberNavController(), viewModel: MainViewModel, itemId: Int) {
    val context = LocalContext.current

    LazyColumn (modifier = Modifier
        .heightIn(min = 100.dp))
    {
        item {
            Image(painter = painterResource(id = viewModel.items[itemId - 1].image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth())
        }

        item {
            Column (modifier = Modifier
                .heightIn(min = 450.dp)
                .fillMaxWidth()
                .background(color = Color.White)
            ) {
                Text(text = viewModel.items[itemId - 1].name,
                    style = TextStyle(
                        fontSize = 22.sp,
                        color = Color.Black
                    ),
                    modifier = Modifier
                        .padding(20.dp)
                )

                Row (modifier = Modifier
                    .padding(start = 15.dp),
                    verticalAlignment = Alignment.CenterVertically,){
                    Image(
                        painter = painterResource(id = R.drawable.calendario),
                        contentDescription = null,
                        modifier = Modifier
                            .size(40.dp)
                    )

                    Text(text = "Fecha:" + " " + viewModel.items[itemId - 1].date,
                        style = TextStyle(
                            fontSize = 15.sp,
                            color = Color.Black
                        ),
                        modifier = Modifier
                            .padding(15.dp)
                            .padding(end = 30.dp)
                    )

                    Text(text = "Hora:" + " " + viewModel.items[itemId - 1].hour,
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

                Row (modifier = Modifier
                    .padding(vertical = 20.dp)
                    .heightIn(min = 50.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center){
                    Button(onClick = {
                        viewModel.addOrRemoveFavorite(viewModel.items[itemId - 1], context)
                        navController.navigate("home")
                                     },
                        modifier = Modifier
                            .padding(horizontal = 50.dp)
                            .width(125.dp)
                            .height(80.dp)){
                        Row (verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center){
                            Text(if (viewModel.items[itemId - 1] in viewModel.favorites) "Quitar de favoritos"
                            else "Agregar a favoritos", style = TextStyle(textAlign = TextAlign.Center)
                            )
                        }
                    }
                    Button(onClick = { /*TODO*/ }) {
                        Text(text = "Comprar")
                    }
                }
            }
        }
    }
}