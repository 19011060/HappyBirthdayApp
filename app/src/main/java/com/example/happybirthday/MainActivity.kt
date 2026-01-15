package com.example.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingImage(
                        message = "Happy Birthday Madie!",
                        from = "From Cade"
                    )
                }
            }
        }
    }

    // This function displays text in the UI by calling the Text() composable function
    @Composable
    fun GreetingText(message: String, from : String, modifier: Modifier = Modifier) {
        Column( // Arranges text objects into a column layout
            verticalArrangement = Arrangement.Center, // Center-aligns text along a vertical axis
            modifier = modifier
        ) {
            Text( // Main message
                text = message,
                fontSize = 100.sp, // Changes the font size
                lineHeight = 116.sp, // Changes the line height
                textAlign = TextAlign.Center
            )
            Text( // Second message
                text = from,
                fontSize = 36.sp, // Changes the font size
                modifier = Modifier
                    .padding(16.dp)
                    .align(alignment = Alignment.End)
            )
        }
    }
    @Composable
    fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
        val image = painterResource(R.drawable.androidparty) // Loads the drawable image
        Box(modifier){ // Allows elements to be stacked
            Image( // Displays image first (in back)
                painter = image,
                contentDescription = null,
                contentScale = ContentScale.Crop, // Crops the image to fill the screen
                alpha = 0.5F // Changes the opacity to 50%
            )
            GreetingText( // Displays text second (in front)
                message = message,
                from = from,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            )
        }
    }

    // This function calls the "GreetingText" function and displays it in the UI preview
    @Preview(showBackground = true)
    @Composable
    fun BirthdayCardPreview() {
        HappyBirthdayTheme {
            GreetingImage(
            message = "Happy Birthday Madie!", from = "From Cade"
            ) // Function call, text arguments passed
        }
    }
}