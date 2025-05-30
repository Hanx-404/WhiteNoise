package com.hanx.whitenoise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.hanx.whitenoise.ui.WhiteNoiseGrid
import com.hanx.whitenoise.ui.theme.WhiteNoiseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WhiteNoiseTheme {
                WhiteNoiseGrid()
            }
        }
    }
}
