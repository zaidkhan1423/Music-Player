package com.zaid.musicplayer.domain.repository

import android.media.MediaPlayer
import com.zaid.musicplayer.data.model.AudioFile
import com.zaid.musicplayer.core.utils.Resource
import kotlinx.coroutines.flow.Flow

interface MusicRepository {
    fun playAudio(audioFile: AudioFile): Resource<Flow<MediaPlayer>>
    fun getAllAudioFiles(): Resource<List<AudioFile>>
}