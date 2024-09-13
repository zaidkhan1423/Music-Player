package com.zaid.musicplayer.presentation.music_screens

import com.zaid.musicplayer.data.model.AudioFile

sealed interface MusicPlayerUiEvent {

    data object OnStopMusicClick: MusicPlayerUiEvent
    data object OnPauseMusicClick: MusicPlayerUiEvent
    data object OnStartMusicClick: MusicPlayerUiEvent
    data class OnPlayAudioClick(val audioFile: AudioFile) : MusicPlayerUiEvent
    data class OnSeekToClick(val seekPosition: Int) : MusicPlayerUiEvent
    data object OnUpdateSeekBarPosition: MusicPlayerUiEvent
    data object OnPreviousTrackClick: MusicPlayerUiEvent
    data object OnNextTrackClick: MusicPlayerUiEvent
    data object OnFetchAudioFiles: MusicPlayerUiEvent

}