import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.applimobilefilm.GestionActivity
import com.example.applimobilefilm.ImageScroll
import com.example.applimobilefilm.R
import com.example.applimobilefilm.components.BottomBar
import com.example.applimobilefilm.components.SearchBarWithIcon
import com.example.applimobilefilm.ui.theme.ApplimobilefilmTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MoviePreview()
        }
    }

    @Composable
    fun ListContent(car1: List<Int>, modifier: Modifier = Modifier, navigateToGestion: () -> Unit) {
        Column(
            modifier = modifier.fillMaxWidth()
        ) {
            Box(
                Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 12.dp, end = 12.dp),
                ) {
                    Spacer(
                        modifier = Modifier.height(30.dp)
                    )
                    Text(
                        text = "Romance",
                        color = Color(0xFFE0D68A)
                    )
                    Row(
                        modifier = Modifier
                            .height(130.dp)
                            .fillMaxWidth()
                    ) {
                        LazyRow(
                            modifier = Modifier.padding(top = 12.dp)
                        ) {
                            items(car1) { painter ->
                                ImageScroll(painter = painterResource(painter), text = "Wolverine")
                            }
                        }
                    }
                    Spacer(
                        modifier = Modifier.height(30.dp)
                    )
                    Text(
                        text = "Thriller",
                        color = Color(0xFFE0D68A)
                    )
                    Row(
                        modifier = Modifier
                            .height(130.dp)
                            .fillMaxWidth()
                    ) {
                        LazyRow(
                            modifier = Modifier.padding(top = 12.dp)
                        ) {
                            items(car1) { painter ->
                                ImageScroll(painter = painterResource(painter), text = "Superman")
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(30.dp))
                    Text(
                        text = "Action",
                        color = Color(0xFFE0D68A)
                    )
                    Row(
                        modifier = Modifier
                            .height(130.dp)
                            .fillMaxWidth()
                    ) {
                        LazyRow(
                            modifier = Modifier.padding(top = 12.dp)
                        ) {
                            items(car1) { painter ->
                                ImageScroll(painter = painterResource(painter), text = "Batman")
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(30.dp))
            }
        }
    }

    @Composable
    fun MoviePreview() {
        ApplimobilefilmTheme {
            Scaffold(
                bottomBar = {
                    BottomBar(
                        onHomeClick = {
                            // Ne rien faire ici car on est déjà dans MainActivity
                        },
                        onStarClick = {
                            // Utiliser l'intent pour naviguer vers GestionActivity
                            startActivity(Intent(this@MainActivity, GestionActivity::class.java))
                        },
                        onInfoClick = {
                            // Handle Info click if needed
                        }
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
                            Box(
                                Modifier
                                    .weight(1.5f)
                                    .fillMaxHeight()
                                    .fillMaxWidth()
                            ) {
                                SearchBarWithIcon()
                            }
                            Spacer(modifier = Modifier.weight(0.1f))
                            ListContent(
                                car1 = listOf(
                                    R.drawable.image1,
                                    R.drawable.image2,
                                    R.drawable.image3,
                                    R.drawable.car1
                                ),
                                modifier = Modifier.weight(8.4f),
                                navigateToGestion = {
                                    startActivity(Intent(this@MainActivity, GestionActivity::class.java))
                                }
                            )
                        }
                    }
                }
            }
        }
    }

    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    fun MoviePreviewPreview() {
        MoviePreview()
    }
}
