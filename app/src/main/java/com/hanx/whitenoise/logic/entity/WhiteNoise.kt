package com.hanx.whitenoise.logic.entity

import androidx.media3.exoplayer.ExoPlayer

data class WhiteNoise(
    val name: String,
    val chineseName: String,
    val soundResId: Int,
    var player: ExoPlayer? = null
)

