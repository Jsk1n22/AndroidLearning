package com.example.uitutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uitutorial.ui.theme.UITutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UITutorialTheme {
                Scaffold(modifier = Modifier.fillMaxSize(),
                    containerColor = MaterialTheme.colorScheme.background) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Column(modifier) {
        Image(
            painter = painterResource(id = R.drawable.bg_compose_background),
            contentDescription = "background image of technological items",
            contentScale = ContentScale.FillWidth)
        Text(
            text = stringResource(id = R.string.tutorial_title),
            modifier = modifier.padding(16.dp),
            fontSize = 24.sp
        )
        Text(
            text = stringResource(id = R.string.p_one),
            modifier = modifier
                .padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text = stringResource(id = R.string.p_two),
            modifier = modifier
                .padding(16.dp),
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(
    name = "My Preview",
    showBackground = true,
    showSystemUi = true)
@Composable
fun GreetingPreview() {
    UITutorialTheme {
        Greeting()
    }
}