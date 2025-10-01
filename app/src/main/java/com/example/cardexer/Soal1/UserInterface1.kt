package com.example.cardexer.Soal1

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Mic
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Soal1Preview() {
    val genres = listOf("TOP CHARTS", "ACTION", "PUZZLE", "ADVENTURE", "SPORTS", "CASUAL")

    Scaffold(
        topBar = { BooblePlayTop() }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(Color.White)
                .padding(8.dp)
        ) {
            // Genre fun


            Spacer(Modifier.height(16.dp))
            Text("Recommended for You", fontWeight = FontWeight.Bold)
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








