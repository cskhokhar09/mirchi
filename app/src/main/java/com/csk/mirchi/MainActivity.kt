package com.csk.mirchi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.csk.mirchi.ui.presentation.GroceryViewModel
import com.csk.mirchi.ui.theme.MirchiTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<GroceryViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MirchiTheme {
                QuadrantScreen()
            }
        }

        val flow : Flow<Int> = flowOf(0)

        CoroutineScope(Dispatchers.Main).launch {
            flow.collect{
                println(it)
            }
        }

    }
}

@Composable
fun QuadrantScreen(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .weight(0.5f)) {

            Box(modifier = Modifier
                .fillMaxSize()
                .weight(0.5f)
                .background(Color.Yellow)) {

            }

            Box(modifier = Modifier
                .fillMaxSize()
                .weight(0.5f)
                .background(Color.Blue)){

            }

        }

        Row(modifier = Modifier
            .fillMaxWidth()
            .weight(0.5f)
            .background(Color.Cyan)) {
            Box(modifier = Modifier
                .fillMaxSize()
                .weight(0.5f)
                .background(Color.Cyan)) {

            }

            Box(modifier = Modifier
                .fillMaxSize()
                .weight(0.5f)
                .background(Color.Green)){

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun QuadrantScreenPreview() {
    MirchiTheme {
        QuadrantScreen()
    }
}