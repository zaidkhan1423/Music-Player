package com.zaid.musicplayer.presentation.view_model

import com.zaid.musicplayer.data.model.AudioFile

data class MusicUiState(
    val isMusicPlaying: Boolean = false,
    val playingAudioFile: AudioFile? = null,
    val audioFiles: List<AudioFile> = emptyList(),
    val currentPosition: Int = 0,
    val loading: Boolean = false,
    val snackBarMessage: String? = null,
    val audioFile: AudioFile? = null,
    val playerSeekBarPosition: Int = 0,
    val isLooping: Boolean = false
)