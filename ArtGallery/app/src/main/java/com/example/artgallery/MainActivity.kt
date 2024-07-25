package com.example.artgallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        2 -> R.drawable.palm_tree_shadow
        3 -> R.drawable.burning_fire
        4 -> R.drawable.stream_to_the_beach
        else -> R.drawable.stream_to_the_beach
    }
    val imageDescription = when(artworkNum) {
        1 -> "Clapping Gorilla"
        2 -> "Shadow of a palm tree"
        3 -> "Large Fire"
        4 -> "Stream to the beach"
        else -> "Stream to the beach"
    }
    val title = when(artworkNum) {
        1 -> "The happy gorilla"
        2 -> "Under the palms"
        3 -> "Flames reaching high"
        4 -> "Beach stream by dusk"
        else -> "Beach stream by dusk"
    }
    val artist = when(artworkNum) {
        1 -> "JK"
        2 -> "JK"
        3 -> "JK"
        4 -> "JK"
        else -> "JK"
    }
    val year = when(artworkNum) {
        1 -> 2017
        2 -> 2018
        3 -> 2018
        4 -> 2018
        else -> 2018
    }
    Column(
        modifier = modifier
            .wrapContentSize(Alignment.Center)
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    )
    {
        ArtworkWall(
            image = imageId,
            contentDescription = imageDescription
        )
        Spacer(modifier = Modifier.height(20.dp))
        ArtworkDescription(
            title = title,
            artist = artist,
            year = year ,
            modifier = modifier
        )
        Spacer(modifier = Modifier.height(20.dp))
        DisplayController(
            onNextChange = {
                if (artworkNum==4){
                    artworkNum = 1
                } else {
                    artworkNum++
                }},
            onPrevChange = {if (artworkNum==1){
                artworkNum = 4
            } else {
                artworkNum--
            }}
        )
    }
}

@Composable
fun ArtworkWall(
    @DrawableRes image: Int,
    contentDescription: String
) {
    Box(
        modifier = Modifier
            .border(1.dp, Color.LightGray, shape = RoundedCornerShape(8.dp))
            .shadow(
                elevation = 10.dp,
                shape = RoundedCornerShape(8.dp)
            )
            .background(Color.White)
            .size(width = 300.dp, height = 400.dp),
        contentAlignment = Alignment.Center
    ){
        Image(
            painter = painterResource(image),
            contentDescription = contentDescription,
            modifier = Modifier.size( width = 250.dp, height = 350.dp),
            contentScale = ContentScale.Fit
        )
    }

}

@Composable
fun ArtworkDescription(
    title: String,
    artist: String,
    year: Int,
    modifier: Modifier
) {
    Column(
        modifier = Modifier
            .background(Color(0xffecebf4))
            .padding(20.dp)
            .width(250.dp)
    ) {
        Text(
            text = title,
            modifier = modifier,
            fontSize = 24.sp
        )
        Text(
            text = "$artist ($year)",
            modifier = modifier,
            fontWeight = FontWeight.Bold
        )
    }

}

@Composable
fun DisplayController(
    onNextChange: () -> Unit,
    onPrevChange: () -> Unit
) {
    Row {
        Button(
            onClick = onPrevChange,
            ) {
            Text(text = "Previous")
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Button(onClick = onNextChange) {
            Text(text = "Next")
        }
    }
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