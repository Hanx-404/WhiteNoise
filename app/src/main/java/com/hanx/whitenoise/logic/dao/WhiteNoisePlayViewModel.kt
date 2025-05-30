package com.hanx.whitenoise.logic.dao

import android.app.Application
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.lifecycle.AndroidViewModel
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import com.hanx.whitenoise.logic.entity.WhiteNoise

class WhiteNoisePlayViewModel(application: Application): AndroidViewModel(application) {

    val context = application.applicationContext

    var whiteNoises = mutableStateListOf<Int>()

    val playingStates = mutableStateMapOf<Int, Boolean>()

    fun toggleWhiteNoise(whiteNoise: WhiteNoise) {
        val soundResId = whiteNoise.soundResId
        if (soundResId in whiteNoises) {
            whiteNoises.remove(soundResId)
            whiteNoise.player?.pause()
            playingStates[soundResId] = false
        } else {
            whiteNoises.add(soundResId)
            whiteNoise.player = ExoPlayer.Builder(context).build()
            val mediaItem = MediaItem.Builder()
                .setMediaId("$soundResId")
                .setUri("android.resource://${context.packageName}/$soundResId")
                .build()
            whiteNoise.player?.apply {
                setMediaItem(mediaItem)
                prepare()
                playWhenReady = true
            }
            playingStates[soundResId] = true
        }
    }
}