package com.example.chimera.core.domain

sealed class Screen (val route: String){
    object DashboardScreen: Screen("dashboard_screen")
    object NotesScreen: Screen("notes_screen")
    object NoteDetailScreen: Screen("notes_detail_screen")
}