package com.zaid.musicplayer.core.broadcast_receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.zaid.musicplayer.core.NotificationHelper
import com.zaid.musicplayer.presentation.music_screens.MusicPlayerUiEvent
import com.zaid.musicplayer.presentation.view_model.MusicViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MusicNotificationReceiver : BroadcastReceiver() {

    @Inject
    lateinit var musicViewModel: MusicViewModel

    override fun onReceive(context: Context, intent: Intent) {
        val action = intent.action
        val isMusicPlaying = intent.getBooleanExtra("isMusicPlaying", false)

        when (action) {
            NotificationHelper.Action.ACTION_NEXT.toString() -> {
                musicViewModel.onEvent(MusicPlayerUiEvent.OnNextTrackClick)
                Log.e("MusicNotificationReceiver", "ACTION_NEXT")
            }

            NotificationHelper.Action.ACTION_PAUSE_PLAY.toString() -> {
                if (isMusicPlaying) {
                    musicViewModel.onEvent(MusicPlayerUiEvent.OnPauseMusicClick)
                } else {
                    musicViewModel.onEvent(MusicPlayerUiEvent.OnStartMusicClick)
                }
                Log.e("MusicNotificationReceiver", "ACTION_PAUSE_PLAY")
            }

            NotificationHelper.Action.ACTION_PREVIOUS.toString() -> {
                musicViewModel.onEvent(MusicPlayerUiEvent.OnPreviousTrackClick)
                Log.e("MusicNotificationReceiver", "ACTION_PREVIOUS")
            }
        }

    }
}