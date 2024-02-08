package com.lexa.kotlinmainwork

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lexa.kotlinmainwork.ui.theme.KotlinMainWorkTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinMainWorkTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Part()
                }
            }
        }
    }
}

@Composable
fun Part(modifier: Modifier = Modifier) {
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var parts by remember { mutableStateOf( 1) }
        val imageResource = when(parts) {
            1 -> R.drawable.amort
            2 -> R.drawable.wheel
            3 -> R.drawable.breaks
            4 -> R.drawable.diskscep
            5 -> R.drawable.engine
            6 -> R.drawable.generator
            7 -> R.drawable.oil
            8 -> R.drawable.shatuns
            9 -> R.drawable.shatun
            else -> R.drawable.etc
        }
        Image(modifier = Modifier.size(300.dp), painter = painterResource(id = imageResource), contentDescription = null)
        Spacer(modifier = Modifier.size(10.dp))
        Button(onClick = { parts = (1..10).random() }) {
            Text("Другая запчасть")
        }
    }
}
