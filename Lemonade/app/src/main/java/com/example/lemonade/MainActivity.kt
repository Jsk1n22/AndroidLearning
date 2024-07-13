package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeApp()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LemonadeApp(modifier: Modifier = Modifier) {
    Scaffold (
        modifier = modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xfff9e44c),
                    ),
                title = {
                    Text(
                        text = "Lemonade",
                        fontWeight = FontWeight.Bold
                   )
                }
            )
        },
    )
    { innerPadding ->
        MainContent(modifier.padding(innerPadding))
    }
}

@Composable
fun MainContent(modifier: Modifier) {
    var step: Int by remember {
        mutableIntStateOf(1)
    }
    var squeezeCount: Int by remember {
        mutableIntStateOf((2..4).random())
    }
    val imageResource = when (step) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }
    val imageDescriptionResource = when (step) {
        1 -> R.string.select_lemon
        2 -> R.string.squeeze_lemon
        3 -> R.string.drink_lemonade
        else -> R.string.restart
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            if (step==4) step = 1
            else if (step==2) {
                squeezeCount --
                if (squeezeCount == 0) {
                    squeezeCount = (2..4).random()
                    step++
                }
            }
            else step ++
        }, shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(Color(0xffc3ecd2))) {
            Image(
                painter = painterResource(imageResource),
                contentDescription = stringResource(imageDescriptionResource)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(imageDescriptionResource),
            fontSize = 18.sp
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    )
@Composable
fun GreetingPreview() {
    LemonadeApp()
}