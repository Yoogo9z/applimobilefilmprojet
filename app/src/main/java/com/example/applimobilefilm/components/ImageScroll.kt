package com.example.applimobilefilm

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest

@Composable
fun ImageScroll(imageUrl: String, text: String) {
	val painter = rememberAsyncImagePainter(
		model = ImageRequest.Builder(LocalContext.current)
			.data(imageUrl)
			.crossfade(true)
			.build()
	)

	Box(
		modifier = Modifier.fillMaxSize()
	) {
		Image(
			painter = painter,
			contentDescription = null,
			modifier = Modifier
				.fillMaxSize()
				.padding(end = 8.dp)
				.width(130.dp)
				.clip(RoundedCornerShape(14.dp)),
			contentScale = ContentScale.Crop
		)
		Column(
			modifier = Modifier
				.fillMaxSize(),
			verticalArrangement = Arrangement.Bottom,
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			Spacer(
				modifier = Modifier
					.weight(8f)
			)
			Box(
				modifier = Modifier
					.fillMaxWidth()
					.weight(2f)
					.clip(RoundedCornerShape(bottomStart = 14.dp, bottomEnd = 14.dp))
					.background(Color.Black.copy(alpha = 0.6f))
					.width(130.dp),
				contentAlignment = Alignment.Center
			) {
				Text(
					text = text,
					color = Color.White,
					modifier = Modifier
						.align(Alignment.Center)
				)
			}
		}
	}
}
