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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val Poppins = FontFamily(
    Font(R.font.poppins_regular, FontWeight.Normal),
    Font(R.font.poppins_medium, FontWeight.Medium),
    Font(R.font.poppins_bold, FontWeight.Bold),
    Font(R.font.poppins_light, FontWeight.Light),
    Font(R.font.poppins_thin, FontWeight.Thin)
)


@Preview(showBackground = true, showSystemUi = false)
@Composable
fun Soal2Preview() {
    val genres = listOf("All", "Favorite", "Sleep", "Anxious", "Trauma", "Music")
    val datasource = ModuleDataSource()

    Scaffold { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Color(0xFFF6F6F6)),
            verticalArrangement = Arrangement.spacedBy(16.dp) // space between sections
        ) {
            item {
                Spacer(Modifier.height(100.dp))
                Text(
                    text = "Good Morning, Jennie!",
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    text = "We wish you have a good day",
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Light,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(horizontal = 16.dp),
                    color = Color.Gray
                )
            }

            item {
                ModuleGenreDis(genres)
            }

            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    ColoredCardDisplay(
                        title = "Basics",
                        genre = "Course",
                        duration = "3–10 MIN",
                        backgroundColor = Color(0xFF8E9BFF),
                        imageResId = R.drawable.heart_face
                    )
                    ColoredCardDisplay(
                        title = "Relaxation",
                        genre = "Music",
                        duration = "3–10 MIN",
                        backgroundColor = Color(0xFFFFC966),
                        imageResId = R.drawable.reading_a_book
                    )
                }
            }

            item {
                ContentBarCard(
                    title = "Daily Thought",
                    desc = "MEDITATION • 3–10 MIN",
                    backgroundColor = Color(0xFF3C3C50),
                    onClick = {  }
                )
            }

            item {
                ModuleCardDisplay(
                    title = "Recommended for you",
                    modules = datasource.loadCourses()
                )
            }
        }
    }
}



    @Composable
    fun ModuleCard(module: Module) {
        Card(
            modifier = Modifier
                .width(210.dp)
                .padding(8.dp),
            shape = RoundedCornerShape(16.dp)
            , colors = CardDefaults.cardColors(
                containerColor = Color(0xFFF6F6F6)
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp),
                horizontalAlignment = Alignment.Start
            ) {
                val context = LocalContext.current
                val imageRes = remember(module.imageUrl) {
                    context.resources.getIdentifier(module.imageUrl, "drawable", context.packageName)
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(160.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color(0xFFE3E2E9)),
                    contentAlignment = Alignment.Center
                ){
                    if (imageRes != 0) {
                        Image(
                            painter = painterResource(id = imageRes),
                            contentDescription = module.title,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(140.dp)
                                .clip(RoundedCornerShape(12.dp))
                        )
                    }
                }

                Spacer(Modifier.height(6.dp))

                Text(
                    text = module.title,
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = Color.Black

                )

                Spacer(Modifier.height(2.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = module.genre,
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Light,
                        fontSize = 12.sp,
                        color = Color.Gray
                    )
                    Text(
                        text = module.duration,
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Normal,
                        fontSize = 12.sp,
                        color = Color.Black
                    )
                }
            }
        }
    }




@Composable
fun ModuleCardDisplay(title: String, modules: List<Module>){
    Column(modifier = Modifier.fillMaxWidth()
    ) {

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 12.dp)
            , horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(title, fontWeight = FontWeight.Bold, fontSize = 26.sp, fontFamily = Poppins)
        }
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
            , contentPadding = PaddingValues(horizontal = 12.dp)
        ) {
            items(modules) { module ->
                ModuleCard(module)
            }
        }
    }
}



//Copas dari Soal1 terus aku pake items biar bisa bedain isSelected
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

