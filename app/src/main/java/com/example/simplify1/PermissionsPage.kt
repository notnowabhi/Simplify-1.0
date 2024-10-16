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
import com.example.simplify1.ui.theme.CommonBackground
import com.example.simplify1.ui.theme.Simplify1Theme
import com.example.simplify1.ui.theme.TextOrange

class PermissionsPage : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Simplify1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    layoutPermissions()
                }
            }
        }
    }
}

@Composable
fun layoutPermissions(){
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .background(CommonBackground)
            .fillMaxSize()
    ) {
        Row( // row for center logo
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.reliefchain_white),
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
                    text = "We need",
                    fontWeight = FontWeight.Bold,
                    fontSize = 40.sp,
                    color = Color(0xffffffff)
                )

                Row {
                    Text(
                        text = "PERMISSIONS",
                        fontWeight = FontWeight.Bold,
                        fontSize = 40.sp,
                        color = TextOrange
                    )

                }


                Text(
                    text = "To make this experience easier for you, let\nRELEIFCHAIN have access to the following.",
                    fontSize = 12.sp,
                    color = Color(0xffffffff)
                )
            }
        }

        Spacer(modifier = Modifier.size(16.dp))

        Row( //row for google button

        ) {
            Button(
                onClick = { onPermissionButtonClick() }, //TODO add a function to ask for permissions
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                //.border(2.dp, TextOrange, RoundedCornerShape(12.dp)), // Adding border,
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xffffffff))

            ) {
//                Image(
//                    painter = painterResource(id = R.drawable.google_logo), // Your Google logo resource
//                    contentDescription = "Google Logo",
//                    modifier = Modifier.size(24.dp)
//                )
                Spacer(
                    modifier = Modifier
                        .width(8.dp)
                ) // Space between image and text
                Text(
                    text = "Allow Permissions",
                    color = TextOrange
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f)) //to push next button to bottom

        Row( //row for next button
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.End,
            //verticalAlignment = Alignment.Bottom
        ) {
            ExtendedFloatingActionButton(
                onClick = {
                    val intent = Intent(context, MainActivity::class.java)
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
                containerColor = TextOrange,
                contentColor = Color.Black
            )
        }
    }
}

fun onPermissionButtonClick(){

}