package com.example.cardexer.Soal2

import android.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true, showSystemUi = false)
@Composable
fun cardPreview(){
    ColoredCardDisplay()
}
@Composable
fun ColoredCardDisplay(){
    Card(
        modifier = Modifier.padding(10.dp)
        , shape = RoundedCornerShape(8.dp)
    ) { Column(
        modifier = Modifier.padding(10.dp)
    ) {
        Box(
            modifier = Modifier
                .height(150.dp)
                .padding(5.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Color(0xFFB3E5FC))
        ){
            Image(
                painter = painterResource(id = R.drawable.ic_menu_camera),
                contentDescription = "Sample Image",
                modifier = Modifier
                    .padding(10.dp)
            )
        }
    }

    }

}