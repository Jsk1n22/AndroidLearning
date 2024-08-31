package com.example.superheros

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.superheros.model.Hero
import com.example.superheros.ui.theme.SuperherosTheme
import com.example.superheros.data.HeroesRepository

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SuperherosTheme {
                SuperheroApp()
            }
        }
    }
}


@Composable
fun SuperheroApp(
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {

        }
    ) { it ->
        LazyColumn(contentPadding = it) {
            items(HeroesRepository.heroes) {
                HeroListItem(
                    hero = it,
                    modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
                )
            }
        }
    }
}

@Composable
private fun HeroListItem(
    hero: Hero,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
    ) {
        Row {
            HeroInformation(hero = hero)
            HeroPicture(hero = hero)
        }
    }
}

@Composable
private fun HeroInformation(
    hero: Hero
) {
    Column {
        Text(
            text = stringResource(id = hero.nameRes)
        )

        Text(
            text = stringResource(id = hero.descriptionRes)
        )
    }
}

@Composable
private fun HeroPicture(
    hero: Hero
) {
    Image(
        painter = painterResource(id = hero.imageRes),
        contentDescription = "Picture of ${stringResource(id = hero.nameRes)}"
    )
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun SuperheroListPreview() {
    SuperherosTheme {
        SuperheroApp()
    }
}