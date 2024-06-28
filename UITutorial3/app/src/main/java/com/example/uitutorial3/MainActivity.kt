package com.example.uitutorial3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uitutorial3.ui.theme.UITutorial3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UITutorial3Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
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
    Column(modifier.fillMaxSize()) {
        Row(Modifier.weight(1f)) {
            DisplayCard(
                title = stringResource(id = R.string.text_title),
                text = stringResource(id = R.string.text_body),
                backgroundColour = Color(0xFFEADDFF),
                modifier = Modifier.weight(1f)
            )
            DisplayCard(
                title = stringResource(id = R.string.image_title),
                text = stringResource(id = R.string.image_body),
                backgroundColour = Color(0xFFD0BCFF),
                modifier = Modifier.weight(1f)
            )
        }
        Row(Modifier.weight(1f)){
            DisplayCard(
                title = stringResource(id = R.string.row_title),
                text = stringResource(id = R.string.row_body),
                backgroundColour = Color(0xFFB69DF8),
                modifier = Modifier.weight(1f)
            )
            DisplayCard(
                title = stringResource(id = R.string.column_title),
                text = stringResource(id = R.string.column_body),
                backgroundColour = Color(0xFFF6EDFF),
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun DisplayCard(
    modifier: Modifier = Modifier,
    title: String,
    text: String,
    backgroundColour: Color) {
    Column(modifier = modifier
        .background(backgroundColour)
        .padding(16.dp)
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            modifier = Modifier
                .padding(bottom = 16.dp),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = text,
            textAlign = TextAlign.Justify
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true)
@Composable
fun GreetingPreview() {
    UITutorial3Theme {
        Greeting()
    }
}