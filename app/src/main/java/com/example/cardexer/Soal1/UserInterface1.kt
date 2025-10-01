package com.example.cardexer.Soal1

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.filled.MoreVert


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Soal1Preview() {
    val genres = listOf("TOP CHARTS", "ACTION", "PUZZLE", "ADVENTURE", "SPORTS", "CASUAL")
    val dataSource = GameDataSource()
    Scaffold(
        topBar = { BooblePlayTop() }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Color.White)
        ) {
            item { GenreDisplay(genres) }
            item { GameCardDisplay("Recommended for you", dataSource.loadRecommendedGames()) }
            item { GameCardDisplay("New Games & Apps", dataSource.loadNewGames()) }
            item { GameCardDisplay("Popular Games", dataSource.loadPopularGames()) }
        }
    }
}

@Composable
fun BooblePlayTop() {
    var query by remember { mutableStateOf("") }
    var selectTab by remember { mutableStateOf(0) }
    val tabs = listOf("Apps & Games", "Movies, Music, Books")
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF129E59))
            .statusBarsPadding()
            .padding(horizontal = 12.dp, vertical = 10.dp)
    ) {
        TextField(
            value = query,
            onValueChange = { query = it },
            placeholder = {
                Text(
                    "Boogle Play",
                    fontSize = 25.sp,
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                    color = Color.Gray
                )
            },
            leadingIcon = { Icon(Icons.Default.Menu, contentDescription = "Menu", Modifier.size(35.dp)) },
            trailingIcon = { Icon(Icons.Default.Mic, contentDescription = "Voice search", Modifier.size(35.dp)) },
            singleLine = true,
            shape = RoundedCornerShape(4.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .shadow(2.dp, RoundedCornerShape(4.dp)),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                disabledContainerColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                cursorColor = Color.Black
            )
        )
        TabRow(
            selectedTabIndex = selectTab,
            containerColor = Color(0xFF129E59),
            contentColor = Color.White,
            indicator = { tabPositions ->
                val currentTab = tabPositions[selectTab]

                val left by animateDpAsState(
                    targetValue = currentTab.left,
                    label = "indicatorOffset"
                )
                val right by animateDpAsState(
                    targetValue = currentTab.width,
                    label = "indicatorWidth"
                )

                Box(Modifier.fillMaxSize()){
                    Box(
                        Modifier
                            .offset(x = left)
                            .width(right)
                            .align ( Alignment.BottomStart )
                            .height(3.dp)
                            .background(Color.White, RoundedCornerShape(2.dp))
                    )
                }
            }

        ) {
            tabs.forEachIndexed { index, string ->
                Tab(
                    selected = selectTab == index,
                    onClick = { selectTab = index },
                    selectedContentColor = Color.White,
                    unselectedContentColor = Color.White.copy(alpha = 0.7f),
                    text = {
                        Text(
                            string,
                            fontSize = 21.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                )
            }
        }
    }
}

@Composable
fun GenreDisplay(genres: List<String>){
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 4.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
        , contentPadding = PaddingValues(horizontal = 5.dp)
    ) {
        items(genres) { genre ->
            Box(
                modifier = Modifier
                    .width(100.dp)
                    .height(30.dp)
                    .background(Color(0xFF129E59),RoundedCornerShape(60))
                    .clickable{/* TODO: nanti*/}
                    , contentAlignment = Alignment.Center
            ) {
                Text(
                    text = genre,
                    color = Color(0xFFFFFFFF),
                    fontWeight = FontWeight.Bold,
                )
            }
        }
    }
}





@Composable
fun GameCard(game: GameModel){
    val context = LocalContext.current
    val imageRes = remember(game.imageId) {
        context.resources.getIdentifier(game.imageId,"drawable",context.packageName)
    }
Column(
    modifier = Modifier
        .width(160.dp)
        .padding(8.dp)
) {
    Image(
        painter = painterResource(id = imageRes),
        contentDescription = game.name,
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .clip(RoundedCornerShape(8.dp))
    )
    Spacer(Modifier.height(4.dp))
    Row(modifier = Modifier
        .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = game.name,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 2
        )
        Icon(
            imageVector = Icons.Default.MoreVert,
            contentDescription = "More Options",
            tint = Color.Gray
            , modifier = Modifier
                .size(22.dp)
                .padding(start = 4.dp)
        )
    }
    Row {
        Icon(
            imageVector = Icons.Default.Star,
            contentDescription = "Rating",
            tint = Color(0xFFFFD700),
            modifier = Modifier.size(14.dp)
        )
        Spacer(Modifier.width(2.dp))
        Text(
            text = game.rating.toString(),
            fontSize = 12.sp
        )
        Spacer(Modifier.width(4.dp))
        Text(
            if (game.isFree)"FREE" else "PAID",
            color = if (game.isFree) Color(0xFF0BE077) else Color.Red,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
}

@Composable
fun GameCardDisplay(title: String, games: List<GameModel>){
    Column(modifier = Modifier.fillMaxWidth()) {

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 25.dp)
            , horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(title, fontWeight = FontWeight.Bold)
            Text("More", color = Color(0xFF129E59), fontWeight = FontWeight.Bold)
        }
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
            , contentPadding = PaddingValues(horizontal = 12.dp)
        ) {
            items(games) { game ->
                GameCard(game)
            }
        }
    }
}




