package com.csk.mirchi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.csk.mirchi.ui.theme.MirchiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MirchiTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    CustomButton(title = "Click Me", color = "0xFFEFB8C8", textColor = "0xFF7D5260", modifier = Modifier.size(200.dp, 20.dp))
                }

            }
        }

    }
}

private fun parseColor(color: String) : Color{
    return Color(android.graphics.Color.parseColor(color))
}

@Composable
fun CustomButton(title: String, color: String, textColor: String, modifier: Modifier = Modifier) {
    var title1 by remember { mutableStateOf(title) }
    Button(onClick = {
                    title1 = "Done"
    }, colors = ButtonDefaults.buttonColors(containerColor = Color.White), border = BorderStroke(2.dp, Color.Yellow), modifier = modifier) {
        Text(text = title1, fontSize = 14.sp, color = Color.Green)
    }
}

@Preview(showBackground = true)
@Composable
fun CustomButtonPreview() {
    Surface(modifier = Modifier.fillMaxSize()) {
        CustomButton(title = "Click Me", color = "0xFFEFB8C8", textColor = "0xFF7D5260", modifier = Modifier.wrapContentSize().fillMaxWidth())
    }
}

