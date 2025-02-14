package com.zaid.musicplayer

import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.zaid.musicplayer.core.navigation.AppNavHost
import com.zaid.musicplayer.presentation.view_model.MusicViewModel
import com.zaid.musicplayer.ui.theme.MusicPlayerTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

//    @Inject
//    lateinit var musicViewModel: MusicViewModel

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (!hasRequiredPermissions()) {
            ActivityCompat.requestPermissions(
                this, PERMISSIONS, 0
            )
        }

        setContent {
            val snackBarHostState = remember { SnackbarHostState() }
            MusicPlayerTheme {
                val navHostController = rememberNavController()
                val musicViewModel: MusicViewModel = hiltViewModel()

                Scaffold(modifier = Modifier.fillMaxSize(),snackbarHost = { SnackbarHost(hostState = snackBarHostState) }) { innerPadding ->
                    AppNavHost(
                        modifier = Modifier.padding(innerPadding),
                        navHostController = navHostController,
                        musicViewModel = musicViewModel,
                        onShowSnackBar = { message, action, duration ->
                            snackBarHostState.showSnackbar(
                                message = message,
                                actionLabel = action,
                                duration = duration,
                                withDismissAction = duration == SnackbarDuration.Indefinite
                            ) == SnackbarResult.ActionPerformed
                        }
                    )
                }
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    private fun hasRequiredPermissions(): Boolean {
        return PERMISSIONS.all {
            ContextCompat.checkSelfPermission(
                applicationContext,
                it
            ) == PackageManager.PERMISSION_GRANTED
        }
    }

    companion object {
        @RequiresApi(Build.VERSION_CODES.TIRAMISU)
        private val PERMISSIONS = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            arrayOf(
                android.Manifest.permission.READ_MEDIA_AUDIO,
                android.Manifest.permission.POST_NOTIFICATIONS
            )
        } else {
            arrayOf(
                android.Manifest.permission.READ_EXTERNAL_STORAGE,
                 android.Manifest.permission.POST_NOTIFICATIONS
            )
        }
    }

}
