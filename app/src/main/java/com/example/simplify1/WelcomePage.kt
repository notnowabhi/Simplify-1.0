package com.example.simplify1

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.simplify1.ui.theme.DarkPurpleBG
import com.example.simplify1.ui.theme.Green
import com.example.simplify1.ui.theme.PurpleButton
import com.example.simplify1.ui.theme.Simplify1Theme

class WelcomePage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Simplify1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    layoutWelcome()
                }
            }
        }
    }
}


@Composable
fun layoutWelcome() {

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .background(DarkPurpleBG)
            .fillMaxSize()
    ) {
        Row( // row for center logo
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.s_logo),
                contentDescription = "center logo for S",
                modifier = Modifier
                    .size(100.dp)
            )
        }

        Spacer(modifier = Modifier.size(62.dp))

        Box( // box for texts
            modifier = Modifier
                .padding(start = 29.dp)
        ) {
            Column {
                Text(
                    text = "Welcome \n\nName",  //To add name from room database or DataStore
                    fontWeight = FontWeight.Bold,
                    fontSize = 50.sp,
                    color = Color(0xff73ec8b)
                )

                Text(
                    text = "Use SIMPILIFY for your tasks !!",
                    fontSize = 16.sp,
                    color = Color(0xff73ec8b)
                )
            }
        }

        Spacer(modifier = Modifier.size(16.dp))

        Column( //row for Start Task button

        ) {
            Button(
                onClick = {
                    //TODO add function to start task or redirect to add a task page
                }, //onClick to be defined
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .padding(start = 16.dp, end = 16.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults
                    .buttonColors(
                        containerColor = PurpleButton
                    )
            ) {
                Image(
                    painter = painterResource(id = R.drawable.google_logo), // TODO change logo
                    contentDescription = "Google Logo",
                    modifier = Modifier.size(48.dp)
                )
                Spacer(
                    modifier = Modifier
                        .width(8.dp)
                ) // Space between image and text

                Column {
                    Text(
                        text = "Start Task",
                        color = Green,
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp
                    )

                    Text(
                        text = "Got a task? Track your work!",
                        color = Color.Black
                    )
                }

            }
        }

        Button(
            onClick = {
                //TODO add function to start tracking steps
            }, //onClick to be defined
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .padding(start = 16.dp, end = 16.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults
                .buttonColors(
                    containerColor = PurpleButton
                )
        ) {
            Image(
                painter = painterResource(id = R.drawable.google_logo), // TODO change logo
                contentDescription = "Google Logo",
                modifier = Modifier.size(48.dp)
            )
            Spacer(
                modifier = Modifier
                    .width(8.dp)
            ) // Space between image and text

            Column {
                Text(
                    text = "Track Steps",
                    color = Green,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )

                Text(
                    text = "Off for a jog? Track your Steps!",
                    color = Color.Black
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f)) //to push next button to bottom

        Row(
            //row for next button
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.End,
            //verticalAlignment = Alignment.Bottom
        ) {
            ExtendedFloatingActionButton(
                onClick = {
                    val intent = Intent(context, LoginActivity::class.java)
                    context.startActivity(intent)
                },
                icon = {
                    Image(
                        painter = painterResource(id = R.drawable.baseline_add_24),
                        contentDescription = "plus icon for fab"
                    )
                },
                text = { Text(text = "NEXT") },
                //shape = RoundedCornerShape(12.dp),
                containerColor = Green,
                contentColor = Color.Black
            )
        }
    }

}
