package com.example.artgallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.artgallery.ui.theme.ArtGalleryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtGalleryTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ArtGallery(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ArtGallery(
    modifier: Modifier = Modifier
) {
    var artworkNum by remember {
        mutableIntStateOf(1)
    }
    val imageId = when(artworkNum) {
        1 -> R.drawable.clapping_gorilla
        else -> R.drawable.stream_to_the_beach
    }
    val imageDescription = when(artworkNum) {
        1 -> "Clapping Gorilla"
        else -> "Stream to the beach"
    }
    val title = when(artworkNum) {
        1 -> "The happy gorilla"
        else -> "Beach stream by dusk"
    }
    val artist = when(artworkNum) {
        1 -> "JK"
        else -> "JK"
    }
    val year = when(artworkNum) {
        1 -> 2017
        else -> 2018
    }
    Column(
        modifier = modifier
            .wrapContentSize(Alignment.Center)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {
        ArtworkWall(
            image = imageId,
            contentDescription = imageDescription
        )
        ArtworkDescription(
            title = title,
            artist = artist,
            year = year ,
            modifier = modifier
        )

    }
}

@Composable
fun ArtworkWall(
    @DrawableRes image: Int,
    contentDescription: String
) {
    Image(
        painter = painterResource(image),
        contentDescription = contentDescription
    )
}

@Composable
fun ArtworkDescription(
    title: String,
    artist: String,
    year: Int,
    modifier: Modifier
) {
    Text(
        text = title,
        modifier = modifier
    )
    Text(
        text = "$artist($year)",
        modifier = modifier
    )
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun ArtGalleryPreview() {
    ArtGalleryTheme {
        ArtGallery()
    }
}