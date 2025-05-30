package com.hanx.whitenoise.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hanx.whitenoise.R
import com.hanx.whitenoise.logic.dao.WhiteNoisePlayViewModel
import com.hanx.whitenoise.logic.entity.WhiteNoise

@Composable
@Preview
fun WhiteNoiseItemPreview() {
    WhiteNoiseItem(
        whiteNoise = WhiteNoise(
            name = "forest_birds",
            chineseName = "森林鸟鸣",
            soundResId = R.raw.forest_birds
        ),
        onToggle = {},
        viewModel()
    )
}

@Composable
fun WhiteNoiseItem(
    // modifier: Modifier,
    whiteNoise: WhiteNoise,
    onToggle: () -> Unit,
    viewModel: WhiteNoisePlayViewModel
) {
    Card(
        modifier = Modifier.padding(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = whiteNoise.chineseName,
                modifier = Modifier
                    .padding(15.dp)
                    .weight(1f)
            )
            IconButton(
                modifier = Modifier.wrapContentSize(),
                onClick = onToggle
            ) {
                val isPlaying = viewModel.playingStates[whiteNoise.soundResId] ?: false
                Icon(
                    modifier = Modifier.size(30.dp),
                    // painter = painterResource(id = R.drawable.play_circle),
                    painter = if (!isPlaying) painterResource(id = R.drawable.play_circle)
                        else painterResource(id = R.drawable.pause_circle),
                    contentDescription = "play/pause button"
                )
            }
        }
    }
}