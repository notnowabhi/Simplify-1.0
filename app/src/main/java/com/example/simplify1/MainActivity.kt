package com.example.simplify1

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simplify1.ui.theme.Simplify1Theme
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.ui.platform.LocalContext
import com.example.simplify1.ui.theme.Green


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Simplify1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    layoutMain()
                }
            }
        }
    }
}

@Composable
fun layoutMain() {

    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xff241b38)), //screen 2 = 241b38
        contentAlignment = Alignment.TopCenter
    ) {
        Image(
            painter = painterResource(id = R.drawable.s_logo),
            contentDescription = "top S logo small",
            modifier = Modifier
                .size(100.dp)
        )
    }

    Column(
        modifier = Modifier
            .offset(x = 29.dp, y = 162.dp)
    ) {
        Box(){
            Column {
                Text(
                    text = "Let's get \n\nYou started!",
                    fontWeight = FontWeight.Bold,
                    fontSize = 50.sp,
                    color = Color(0xff73ec8b)
                )

                Text(
                    text = "Tell us your name!",
                    fontSize = 16.sp,
                    color = Color(0xff73ec8b)
                )
            }

        }
        
        Spacer(modifier = Modifier.size(16.dp))
        
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            val name = remember { mutableStateOf(TextFieldValue("")) }

                TextField(
                    modifier = Modifier
                        .border(2.dp, Color(0xff73ec8b), RoundedCornerShape(12.dp)), // Adding border
                    value = name.value,
                    onValueChange = { name.value = it },
                    shape = RoundedCornerShape(12.dp),
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color(0xff24b3d),
                        focusedContainerColor = Color(0xff522da2),
                        focusedIndicatorColor = Color.Transparent, // Focused underline color
                        unfocusedIndicatorColor = Color.Transparent,
                        cursorColor = Color(0xff73ec8b), // Cursor color
                        focusedTextColor = Color.White, // Text color when focused
                        unfocusedTextColor = Color(0xff73ec8b)
                    )
                )
        }

    }

    Row (
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.Bottom,
        modifier = Modifier
            .padding(16.dp)
    ){
        Button(
            onClick = {
                //val intent = Intent(context, LoginActivity::class.java)
                val intent = Intent(context, LoginActivity::class.java)
                context.startActivity(intent)
            },
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Green,
                contentColor = Color.Black
            )
        ) {
            Text(text = "NEXT")
        }
    }

}