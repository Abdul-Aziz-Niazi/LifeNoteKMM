package com.abdulaziz.lifenote.android

import android.os.Bundle
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.abdulaziz.lifenote.android.theme.MyApplicationTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme(darkTheme = false) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column() {
                        TitleBar("Hello, Aziz!")
                    }
                }
            }
        }
    }
}

@Composable
fun TitleBar(text: String) {

    val stringText = remember {
        mutableStateOf("")
    }
    Column(modifier = Modifier
        .fillMaxWidth()
        .height(240.dp)
        .clip(RoundedCornerShape(bottomEnd = 16.dp, bottomStart = 16.dp))
        .background(color = MaterialTheme.colors.primary)
        .padding(16.dp),
    verticalArrangement = Arrangement.Bottom,
    horizontalAlignment = Alignment.Start) {
        Text(
            text = text,
            fontSize = 34.sp,
            color=Color.White,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier
                .fillMaxWidth())
        Text(
            text = "What's on your mind!",
            fontSize = 16.sp,
            color=Color.White.copy(alpha = 0.9f),
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth())
        Spacer(modifier = Modifier.height(16.dp))
        TextField(modifier = Modifier
            .fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent),
            label = {Text(text = "Write here ...")},
            value = stringText.value, onValueChange = {
                stringText.value = it
        })
        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        TitleBar("Hello, Aziz!")
    }
}
