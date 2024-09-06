package com.example.superheros

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheros.data.HeroesRepository
import com.example.superheros.model.Hero
import com.example.superheros.ui.theme.SuperheroesTheme
import com.example.superheros.ui.theme.Typography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SuperheroesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SuperheroApp()
                }
            }
        }
    }
}


@Composable
fun SuperheroApp() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            HeroTopBar()
        }
    ) { it ->
        LazyColumn(contentPadding = it) {
            items(HeroesRepository.heroes) {
                HeroListItem(
                    hero = it,
                    modifier = Modifier.padding(
                        top = dimensionResource(R.dimen.padding_small),
                        start = dimensionResource(R.dimen.padding_medium),
                        end = dimensionResource(R.dimen.padding_medium)
                    )
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HeroTopBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(title = {
        Text(
            text = stringResource(id = R.string.app_name),
            style = Typography.displayLarge
        )
    },
        modifier = modifier
    )
}

@Composable
private fun HeroListItem(
    hero: Hero,
    modifier: Modifier = Modifier
) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        modifier = modifier
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .height(72.dp)
        ) {
            HeroInformation(hero = hero)
            Spacer(modifier = Modifier
                .weight(1f)
                .size(16.dp))
            HeroPicture(hero = hero)
        }
    }
}

@Composable
private fun HeroInformation(
    hero: Hero
) {
    Column (
    ) {
        Text(
            text = stringResource(id = hero.nameRes),
            style = Typography.displaySmall
        )

        Text(
            text = stringResource(id = hero.descriptionRes),
            style = Typography.bodyLarge
        )
    }
}

@Composable
private fun HeroPicture(
    hero: Hero
) {
    Box(
        modifier = Modifier
            .size(72.dp)
            .clip(RoundedCornerShape(8.dp))
    ) {
        Image(
            painter = painterResource(id = hero.imageRes),
            contentDescription = "Picture of ${stringResource(id = hero.nameRes)}",
            contentScale = ContentScale.FillWidth
        )
    }
}

@Preview(
    showBackground = true
)
@Composable
fun SuperHeroItemPreview() {
    HeroListItem(hero = HeroesRepository.heroes[0])
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun SuperheroListPreview() {
    SuperheroesTheme(darkTheme = true) {
        SuperheroApp()
    }
}