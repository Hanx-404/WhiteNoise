package com.hanx.whitenoise.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hanx.whitenoise.R
import com.hanx.whitenoise.logic.dao.WhiteNoisePlayViewModel
import com.hanx.whitenoise.logic.entity.WhiteNoise
import com.hanx.whitenoise.ui.theme.WhiteNoiseTheme

@Composable
@Preview
fun WhiteNoiseGridPreview() {
    WhiteNoiseTheme {
        WhiteNoiseGrid()
    }
}

val whiteNoises = listOf(
    WhiteNoise(
        name = "forest_birds",
        chineseName = "森林鸟鸣",
        soundResId = R.raw.forest_birds,
    ),
    WhiteNoise(
        name = "bonfire",
        chineseName = "篝火",
        soundResId = R.raw.bonfire,
    ),
    WhiteNoise(
        name = "beach",
        chineseName = "海滩",
        soundResId = R.raw.beach,
    ),
    WhiteNoise(
        name = "cafe",
        chineseName = "咖啡馆",
        soundResId = R.raw.cafe,
    )
)

@Composable
fun WhiteNoiseGrid(viewModel: WhiteNoisePlayViewModel = viewModel()) {

    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 150.dp),
        modifier = Modifier.fillMaxSize().safeDrawingPadding()
    ) {
        items(whiteNoises) { item ->
            WhiteNoiseItem(
                whiteNoise = item,
                onToggle = { viewModel.toggleWhiteNoise(item) },
                viewModel = viewModel
            )
        }
    }
}