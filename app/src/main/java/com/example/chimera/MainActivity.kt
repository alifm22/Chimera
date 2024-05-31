package com.example.chimera

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.chimera.core.presentation.Navigation
//import com.example.chimera.notes.presentation.screens.detail_screen.DetailAssistedFactory
import com.example.chimera.notes.presentation.screens.detail_screen.NoteDetailAssistedFactory
import com.example.chimera.notes.presentation.screens.note_screen.NotesViewModel
import com.example.chimera.ui.theme.ChimeraTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity: ComponentActivity() {
    @Inject
    lateinit var noteAssistedFactory: NoteDetailAssistedFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChimeraTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ChimeraApp()
                }
            }
        }
    }
    @Composable
    fun ChimeraApp() {
        val navController = rememberNavController()
        Navigation(
            navHostController = navController,
            noteAssistedFactory = noteAssistedFactory
        )
    }
}
