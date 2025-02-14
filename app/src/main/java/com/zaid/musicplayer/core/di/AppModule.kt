package com.zaid.musicplayer.core.di

import android.content.Context
import com.zaid.musicplayer.core.NotificationHelper
import com.zaid.musicplayer.domain.repository.MusicRepository
import com.zaid.musicplayer.presentation.view_model.MusicViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAppContext(@ApplicationContext context: Context): Context {
        return context
    }


    @Provides
    @Singleton
    fun provideNotificationHelper(@ApplicationContext context: Context): NotificationHelper {
        return NotificationHelper(context)
    }

    @Provides
    @Singleton
    fun providesMusicVM(
        musicRepository: MusicRepository,
        notificationHelper: NotificationHelper
    ): MusicViewModel {
        return MusicViewModel(musicRepository, notificationHelper)
    }

}