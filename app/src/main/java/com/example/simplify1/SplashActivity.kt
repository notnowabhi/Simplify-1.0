package com.example.simplify1

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import com.example.simplify1.ui.theme.Simplify1Theme
import kotlinx.coroutines.delay

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Simplify1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    layoutSplash()
                }
            }
        }
    }
}


@Composable
fun layoutSplash() {
    val context = LocalContext.current
    Box(modifier = Modifier
        .fillMaxSize()
        .clickable {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
        .background(
            Brush.verticalGradient(
                listOf(
                    Color(0xff775ab4),
                    Color(0xff522da2)
                )
            )
        )
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    )
    {
        //logo here
        Image(
            painter = painterResource(id = R.drawable.s_logo),
            contentDescription = "S logo for Simplify"
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Curating your motivation,",
                fontWeight = FontWeight.Bold,
                color = Color(0xff73ec8b)
            )
            Text(
                text = "Simplified!",
                fontWeight = FontWeight.Bold,
                color = Color(0xff73ec8b)
            )
        }
    }

    LaunchedEffect(Unit) {
        delay(2000) // Delay for 2 seconds
//        val context = LocalContext.current
        val intent = Intent(context, MainActivity::class.java)
        context.startActivity(intent)
        (context as? ComponentActivity)?.finish() // Optionally finish the activity
    }
}
//start / up = 775ab4
// end / down = 522da2

//green = 73ec8b

