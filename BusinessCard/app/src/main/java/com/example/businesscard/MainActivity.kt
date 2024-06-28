package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Column(
        modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(Color(0xFF2be4dc), Color(0xFF243484)))),
        verticalArrangement = Arrangement.Center
    ) {
        val borderWidth = 4.dp
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(id = R.drawable.me),
            contentDescription = "profile picture",
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
                .align(Alignment.CenterHorizontally)
                .border(BorderStroke(borderWidth, Color.Cyan), CircleShape),
            contentScale = ContentScale.Crop
        )
        Text(
            text = "Joshua Kennard",
            modifier = modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 16.dp, bottom = 12.dp),
            color = Color.White,
            fontSize = 40.sp,
            fontWeight = FontWeight.SemiBold
        )
        Text(
            text = "Computer Science Student",
            modifier = modifier
                .align(Alignment.CenterHorizontally),
            color = Color.White,
            fontSize = 22.sp,
        )
        Spacer(modifier = Modifier.weight(1f))
        Row(
            Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                Icons.Outlined.Share,
                contentDescription = "share icon",
                tint = Color.White,
            )
            Text(
                text = "@joshua.s.k03",
                modifier = modifier.padding(start = 12.dp),
                color = Color.White,
                fontSize = 20.sp,
                lineHeight = 20.sp
            )
        }
        Row(
            Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                Icons.Outlined.Phone,
                contentDescription = "Phone icon",
                tint = Color.White,
            )
            Text(
                text = "(+44)7540 265 333",
                modifier = modifier.padding(start = 12.dp),
                color = Color.White,
                fontSize = 20.sp,
                lineHeight = 20.sp
            )
        }
        Row(
            Modifier
                .fillMaxWidth()
                .padding(bottom = 80.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                Icons.Outlined.Email,
                contentDescription = "email icon",
                tint = Color.White,
            )
            Text(
                text = "jsk1n22@soton.ac.uk",
                modifier = modifier.padding(start = 12.dp),
                color = Color.White,
                fontSize = 20.sp,
                lineHeight = 20.sp
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        Greeting()
    }
}