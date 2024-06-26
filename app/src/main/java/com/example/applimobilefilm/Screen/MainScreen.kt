package com.example.applimobilefilm

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.applimobilefilm.components.BottomBar
import com.example.applimobilefilm.components.DetailsPage
import com.example.applimobilefilm.components.FavorisPage
import com.example.applimobilefilm.components.HomePage
import com.example.applimobilefilm.ui.theme.ApplimobilefilmTheme

class MainScreen : AppCompatActivity() {
	@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			ApplimobilefilmTheme {
				val navController = rememberNavController()
				Scaffold(
					bottomBar = {
						BottomBar(
							navController = navController,
							onHomeClick = { /*TODO*/ },
							onStarClick = { /*TODO*/ },
							onInfoClick = { /*TODO*/ }
						)
					},
					modifier = Modifier.fillMaxSize()
				) {
					NavHost(navController = navController, startDestination = "home") {
						composable("home") { HomePage(navController, onHomeClick = {}, onStarClick = {}, onInfoClick={}) }
						composable("favoris") { FavorisPage() }
						composable("details") { DetailsPage() }
					}
				}
			}
		}
	}
}



