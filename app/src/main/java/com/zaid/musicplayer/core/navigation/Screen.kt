package com.zaid.musicplayer.core.navigation

import kotlinx.serialization.Serializable

//@Parcelize
@Serializable
sealed class Screen {

//    @Parcelize
    @Serializable
    data object MusicListScreen: Screen()

//    @Parcelize
    @Serializable
    data object MusicPlayerScreen: Screen()

}