package com.example.happybirthday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
                }
            }
        }
    }

    // This function displays text in the UI by calling the Text() composable function
    @Composable
    fun GreetingText(message: String, from : String, modifier: Modifier = Modifier) {
        Text( // Main message
            text = message,
            fontSize = 100.sp, // Changes the font size
            lineHeight = 116.sp
        )
        Text( // Second message
            text = from,
            fontSize = 36.sp // Changes the line height
        )
    }

    // This function calls the "GreetingText" function and displays it in the UI preview
    @Preview(showBackground = true)
    @Composable
    fun BirthdayCardPreview() {
        HappyBirthdayTheme {
            GreetingText(message = "Happy Birthday Madie!", from = "From Cade") // Function call, text arguments passes
        }
    }
}