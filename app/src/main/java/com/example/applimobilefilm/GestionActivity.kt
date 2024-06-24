package com.example.applimobilefilm

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.applimobilefilm.components.BottomBar
import com.example.applimobilefilm.ui.theme.ApplimobilefilmTheme

class GestionActivity : AppCompatActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ApplimobilefilmTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = {
                        BottomBar(
                            navController = navController,
                            onHomeClick = { navController.navigate("home") },
                            onStarClick = { navController.navigate("favoris") },
                            onInfoClick = { /* Handle Info click */ }
                        )
                    },
                    modifier = Modifier.fillMaxSize()
                ) {
                    NavHost(navController, startDestination = "favoris") {
                        composable("favoris") {
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Favoris(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Box(
            Modifier
                .fillMaxWidth()
                .weight(10f)
                .background(Color(0xFF511730))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 12.dp, end = 12.dp),
            ) {
                Text(
                    modifier = Modifier
                        .padding(top = 20.dp, bottom = 20.dp)
                        .align(Alignment.CenterHorizontally),
                    style = androidx.compose.ui.text.TextStyle(fontSize = 24.sp),
                    text = "Mes favoris",
                    color = Color(0xFFE0D68A)
                )
                Text(
                    modifier = Modifier
                        .padding(top = 20.dp, bottom = 20.dp),
                    text = "Batman",
                    color = Color(0xFFE0D68A)
                )
                Spacer(
                    modifier = Modifier
                        .height(1.dp)
                        .fillMaxWidth()
                        .background(color = Color.White)
                )
                Text(
                    modifier = Modifier
                        .padding(top = 20.dp, bottom = 20.dp),
                    text = "Superman",
                    color = Color(0xFFE0D68A)
                )
                Spacer(
                    modifier = Modifier
                        .height(1.dp)
                        .fillMaxWidth()
                        .background(color = Color.White)
                )
                Text(
                    modifier = Modifier
                        .padding(top = 20.dp, bottom = 20.dp),
                    text = "The Mask",
                    color = Color(0xFFE0D68A)
                )
                Spacer(
                    modifier = Modifier
                        .height(1.dp)
                        .fillMaxWidth()
                        .background(color = Color.White)
                )
                Text(
                    modifier = Modifier
                        .padding(top = 20.dp, bottom = 20.dp),
                    text = "Le Prénom",
                    color = Color(0xFFE0D68A)
                )
                Spacer(
                    modifier = Modifier
                        .height(1.dp)
                        .fillMaxWidth()
                        .background(color = Color.White)
                )
                Text(
                    modifier = Modifier
                        .padding(top = 20.dp, bottom = 20.dp),
                    text = "Fight Club",
                    color = Color(0xFFE0D68A)
                )
                Spacer(
                    modifier = Modifier
                        .height(1.dp)
                        .fillMaxWidth()
                        .background(color = Color.White)
                )
                Text(
                    modifier = Modifier
                        .padding(top = 20.dp, bottom = 20.dp),
                    text = "Edge of Tomorrow",
                    color = Color(0xFFE0D68A)
                )
                Spacer(
                    modifier = Modifier
                        .height(1.dp)
                        .fillMaxWidth()
                        .background(color = Color.White)
                )
                Text(
                    modifier = Modifier
                        .padding(top = 20.dp, bottom = 20.dp),
                    text = "Infinity War",
                    color = Color(0xFFE0D68A)
                )
                Spacer(
                    modifier = Modifier
                        .height(1.dp)
                        .fillMaxWidth()
                        .background(color = Color.White)
                )
                Text(
                    modifier = Modifier
                        .padding(top = 20.dp, bottom = 20.dp),
                    text = "Winter Soldier",
                    color = Color(0xFFE0D68A)
                )
                Spacer(
                    modifier = Modifier
                        .height(1.dp)
                        .fillMaxWidth()
                        .background(color = Color.White)
                )
                Text(
                    modifier = Modifier
                        .padding(top = 20.dp, bottom = 20.dp),
                    text = "Taxi 2",
                    color = Color(0xFFE0D68A)
                )
                Spacer(
                    modifier = Modifier
                        .height(1.dp)
                        .fillMaxWidth()
                        .background(color = Color.White)
                )
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MoviePreviewContentFav(onHomeClick: () -> Unit, onStarClick: () -> Unit) {
    val navController = rememberNavController()
    ApplimobilefilmTheme {
        Scaffold(
            bottomBar = {
                BottomBar(
                    navController = rememberNavController(),
                    onHomeClick = onHomeClick,
                    onStarClick = onStarClick,
                    onInfoClick = {  }
                )
            },
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
            ) {
                Favoris(modifier = Modifier.weight(8.4f))
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MoviePreview() {
    MoviePreviewContentFav(onHomeClick = { /*TODO*/ }) {
    }
}