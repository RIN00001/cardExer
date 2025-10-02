package com.example.cardexer.Soal2

import com.example.cardexer.R

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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cardexer.Soal1.GameCard
import com.example.cardexer.Soal1.modules
import com.example.cardexer.Soal1.GenreDisplay

val Poppins = FontFamily(
    Font(R.font.poppins_regular, FontWeight.Normal),
    Font(R.font.poppins_medium, FontWeight.Medium),
    Font(R.font.poppins_bold, FontWeight.Bold),
    Font(R.font.poppins_light, FontWeight.Light),
    Font(R.font.poppins_thin, FontWeight.Thin)
)


@Preview(showBackground = true, showSystemUi = false)
@Composable
fun Soal2Preview(){
    val genres = listOf("All", "Favorite", "Sleep", "Anxious", "Trauma", "Music")
    val datasource = ModuleDataSource()
    Scaffold( ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()

                .background(Color(0xFFF6F6F6))
        ) {
            item {
                Spacer(Modifier.height(100.dp))
                Text(
                    text = "Good Morning, Jennie",
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Spacer(Modifier.height(8.dp))

                Text(
                    text = "Recommended for you",
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Light,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Spacer(Modifier.height(16.dp))
                ModuleGenreDis(genres)
                Spacer(Modifier.height(8.dp))
            }
        }
    }


@Composable
fun CourseCard(x0: Module) {
    TODO("Not yet implemented")
}


@Composable
fun MedititationBottom() {

}

@Composable
fun GameCard(module: Module){
    val context = LocalContext.current
    val imageRes = remember(module.imageUrl) {
        context.resources.getIdentifier(module.imageUrl,"drawable",context.packageName)
    }
    Column(
        modifier = Modifier
            .width(160.dp)
            .padding(8.dp)
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = module.title,
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .clip(RoundedCornerShape(8.dp))
        )
        Spacer(Modifier.height(4.dp))
            Text(
                text = module.title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 2
            )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "Rating",
                tint = Color(0xFFFFD700),
                modifier = Modifier.size(14.dp)
            )
            Text(
                text = module.genre.toString(),
                fontSize = 12.sp
            )
            Spacer(Modifier.width(75.dp))
            Text(
                text = module.duration.toString(),
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}



@Composable
fun GameCardDisplay(title: String, modules: List<Module>){
    Column(modifier = Modifier.fillMaxWidth()
        .shadow(
            elevation = 2.dp,
            shape = RoundedCornerShape(4.dp),
            clip = true
        )
    ) {

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp)
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
            items(modules) { game ->
                GameCard(game)
            }
        }
    }
}
}
@Composable
fun ModuleGenreDis(genres: List<String>) {
    var selectedGenre by remember { mutableStateOf(genres.first()) }

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 4.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 5.dp)
    ) {
        items(genres) { genre ->
            val isSelected = genre == selectedGenre
            Box(
                modifier = Modifier
                    .height(36.dp)
                    .clip(RoundedCornerShape(50))
                    .background(
                        if (isSelected) Color.Black else Color.Transparent
                    )
                    .clickable { selectedGenre = genre }
                    .padding(horizontal = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = genre,
                    fontFamily = Poppins,
                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                    color = if (isSelected) Color.White else Color.Gray,
                    fontSize = 14.sp
                )
            }
        }
    }
}

