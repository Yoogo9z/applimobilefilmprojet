package com.example.applimobilefilm

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.applimobilefilm.components.BottomBar
import com.example.applimobilefilm.ui.theme.ApplimobilefilmTheme

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_details)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}

@Composable
fun FilmDetails(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        Column {
            val painter =
                painterResource(id = R.drawable.image1)
            Image(
                painter = painter,
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 10.dp, bottom = 10.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .align(Alignment.CenterHorizontally),
                contentScale = ContentScale.Crop
            )
            Text(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                text = "TITANIC",
                color = Color(0xFFE0D68A),
                style = TextStyle(fontSize = 22.sp, fontWeight = FontWeight.Medium)
            )
            Spacer(modifier = Modifier.height(30.dp))
            Column(
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp)
            )
            {
                Row(modifier = Modifier.padding(bottom = 8.dp))
                {
                    Text(
                        text = "Genre : ",
                        color = Color.White
                    )
                    Text(
                        text = "Thriller",
                        color = Color(0xFFE0D68A)
                    )
                }
                Row {
                    Text(
                        text = "Note : ",
                        color = Color.White
                    )
                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = "Star icon",
                        tint = Color.Yellow
                    )
                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = "Star icon",
                        tint = Color.Yellow
                    )
                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = "Star icon",
                        tint = Color.Yellow
                    )
                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = "Star icon",
                        tint = Color.Yellow
                    )
                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = "Star icon",
                        tint = Color.Yellow
                    )
                }
                Row(modifier = Modifier.padding(bottom = 8.dp))
                {
                    Text(
                        text = "Réalisateur : ",
                        color = Color.White
                    )
                    Text(
                        text = "Christopher Nolan",
                        color = Color(0xFFE0D68A)
                    )
                }
                Row(modifier = Modifier.padding(bottom = 8.dp))
                {
                    Text(
                        text = "Durée : ",
                        color = Color.White
                    )
                    Text(
                        text = "2h45",
                        color = Color(0xFFE0D68A)
                    )
                }
                Row(modifier = Modifier.padding(bottom = 8.dp))
                {
                    Text(
                        text = "Date de sortie : ",
                        color = Color.White
                    )
                    Text(
                        text = "21/06/2024",
                        color = Color(0xFFE0D68A)
                    )
                }
                Text(
                    text = "Synopsis : ",
                    color = Color.White,
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                )
                Text(
                    text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit." +
                            " Quisque non neque at dui efficitur lacinia quis ac leo." +
                            " Pellentesque habitant morbi tristique senectus et netus " +
                            "et malesuada fames ac turpis egestas.",
                    color = Color(0xFFE0D68A),
                    textAlign = TextAlign.Justify,
                    modifier = Modifier
                        .height(125.dp)
                )
                ButtonBandeAnnonce(context = context, modifier = Modifier.weight(0.1f))
            }

        }
    }
}

@Composable
fun ButtonBandeAnnonce(context: Context, modifier: Modifier) {
    Button(
        onClick = {
            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://www.youtube.com/watch?v=VIDEO_ID")
            )
            context.startActivity(intent)
        },
        modifier = modifier
    ) {
        Text(text = "Voir la bande annonce")
    }
}

@Composable
fun MyComposableFunction() {
    val context = LocalContext.current
    ButtonBandeAnnonce(context = context, modifier = Modifier.padding(16.dp))
}

@Composable
fun MoviePreviewDetails(onHomeClick: () -> Unit, onStarClick: () -> Unit) {
    val context = LocalContext.current
    ApplimobilefilmTheme {
        Scaffold(
            bottomBar = {
                BottomBar(
                    onHomeClick = onHomeClick,
                    onStarClick = onStarClick,
                    onInfoClick = { /* Handle Info click */ }
                )
            },
            modifier = Modifier.fillMaxSize()
        ) { innerPadding ->
            Column(
                modifier = Modifier.padding(innerPadding)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFF511730))
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth()
                    ) {
                        FilmDetails(modifier = Modifier.weight(0.9f))
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MoviePreviewD() {
    MoviePreviewDetails(onHomeClick = { /*TODO*/ }) {
    }
}
