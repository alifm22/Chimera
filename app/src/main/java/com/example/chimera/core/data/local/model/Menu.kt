package com.example.chimera.core.data.local.model

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Alarm
import androidx.compose.material.icons.filled.AssignmentLate
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Checklist
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.Games
import androidx.compose.material.icons.filled.ManageSearch
import androidx.compose.material.icons.filled.Message
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.material.icons.filled.NoteAdd
import androidx.compose.material.icons.filled.NoteAlt
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import com.example.chimera.R
import com.example.chimera.core.domain.Screen

enum class MenuCategory {
    Main,
    Dashboard,
    Notes,
    NoteDetail
}


data class Menu(
    val id: Long,
    val title: String,
    val icon: ImageVector,
    val backgroundColor: Color,
    val iconColor: Color,
    val titleColor: Color,
    val route: String
) {
    companion object {
        @Composable
        fun getItems(category: String): List<Menu> {
            return when (category) {
                MenuCategory.Main.name ->
                    listOf(
                        Menu(
                            id = 1001L,
                            title = "Dashboard",
                            icon = Icons.Default.Dashboard,
                            backgroundColor = colorResource(id = R.color.paleOrange),
                            iconColor = colorResource(id = R.color.onPaleOrange),
                            titleColor = if (isSystemInDarkTheme()) {
                                colorResource(id = R.color.darkWhite)
                            } else colorResource(id = R.color.darkGrey),
                            route = Screen.DashboardScreen.route
                        ),
                        Menu(
                            id = 1002L,
                            title = "Notify",
                            icon = Icons.Default.Notifications,
                            backgroundColor = colorResource(id = R.color.veryLightViolet),
                            iconColor = colorResource(id = R.color.onVeryLightViolet),
                            titleColor = if (isSystemInDarkTheme()) {
                                colorResource(id = R.color.darkWhite)
                            } else colorResource(id = R.color.darkGrey),
                            route = Screen.DashboardScreen.route
                        ),
                        Menu(
                            id = 1002L,
                            title = "Settings",
                            icon = Icons.Default.Settings,
                            backgroundColor = colorResource(id = R.color.lightBlueGreen),
                            iconColor = colorResource(id = R.color.onLightBlueGreen),
                            titleColor = if (isSystemInDarkTheme()) {
                                colorResource(id = R.color.darkWhite)
                            } else colorResource(id = R.color.darkGrey),
                            route = Screen.DashboardScreen.route
                        ),
                        Menu(
                            id = 1002L,
                            title = "About",
                            icon = Icons.Default.AssignmentLate,
                            backgroundColor = colorResource(id = R.color.darkBlueGreen),
                            iconColor = colorResource(id = R.color.onDarkBlueGreen),
                            titleColor = if (isSystemInDarkTheme()) {
                                colorResource(id = R.color.darkWhite)
                            } else colorResource(id = R.color.darkGrey),
                            route = Screen.DashboardScreen.route
                        )
                    )

                MenuCategory.Dashboard.name ->
                    listOf(
                        Menu(
                            id = 2004L,
                            title = "Music",
                            icon = Icons.Default.MusicNote,
                            backgroundColor = colorResource(id = R.color.green),
                            iconColor = colorResource(id = R.color.onGreen),
                            titleColor = if (isSystemInDarkTheme()) {
                                colorResource(id = R.color.darkWhite)
                            } else colorResource(id = R.color.darkGrey),
                            route = Screen.DashboardScreen.route
                        ),
                        Menu(
                            id = 2003L,
                            title = "Movies",
                            icon = Icons.Default.Movie,
                            backgroundColor = colorResource(id = R.color.turquoise),
                            iconColor = colorResource(id = R.color.onTurquoise),
                            titleColor = if (isSystemInDarkTheme()) {
                                colorResource(id = R.color.darkWhite)
                            } else colorResource(id = R.color.darkGrey),
                            route = Screen.DashboardScreen.route
                        ),
                        Menu(
                            id = 2005L,
                            title = "Games",
                            icon = Icons.Default.Games,
                            backgroundColor = colorResource(id = R.color.darkRed),
                            iconColor = colorResource(id = R.color.onDarkRed),
                            titleColor = if (isSystemInDarkTheme()) {
                                colorResource(id = R.color.darkWhite)
                            } else colorResource(id = R.color.darkGrey),
                            route = Screen.DashboardScreen.route
                        ),
                        Menu(
                            id = 2002L,
                            title = "Todo",
                            icon = Icons.Default.Checklist,
                            backgroundColor = colorResource(id = R.color.yellowOrange),
                            iconColor = colorResource(id = R.color.onYellowOrange),
                            titleColor = if (isSystemInDarkTheme()) {
                                colorResource(id = R.color.darkWhite)
                            } else colorResource(id = R.color.darkGrey),
                            route = Screen.DashboardScreen.route
                        ),
                        Menu(
                            id = 2001L,
                            title = "Notes",
                            icon = Icons.Default.NoteAlt,
                            backgroundColor = colorResource(id = R.color.goldenYellow),
                            iconColor = colorResource(id = R.color.onGoldenYellow),
                            titleColor = if (isSystemInDarkTheme()) {
                                colorResource(id = R.color.darkWhite)
                            } else colorResource(id = R.color.darkGrey),
                            route = Screen.NotesScreen.route
                        ),
                        Menu(
                            id = 2007L,
                            title = "Calculator",
                            icon = Icons.Default.Calculate,
                            backgroundColor = colorResource(id = R.color.forestGreen),
                            iconColor = colorResource(id = R.color.onForestGreen),
                            titleColor = if (isSystemInDarkTheme()) {
                                colorResource(id = R.color.darkWhite)
                            } else colorResource(id = R.color.darkGrey),
                            route = Screen.DashboardScreen.route
                        ),
                        Menu(
                            id = 2006L,
                            title = "Calendar",
                            icon = Icons.Default.CalendarMonth,
                            backgroundColor = colorResource(id = R.color.sageGreen),
                            iconColor = colorResource(id = R.color.onSageGreen),
                            titleColor = if (isSystemInDarkTheme()) {
                                colorResource(id = R.color.darkWhite)
                            } else colorResource(id = R.color.darkGrey),
                            route = Screen.DashboardScreen.route
                        ),
                        Menu(
                            id = 2008L,
                            title = "Messages",
                            icon = Icons.Default.Message,
                            backgroundColor = colorResource(id = R.color.softPink),
                            iconColor = colorResource(id = R.color.onSoftPink),
                            titleColor = if (isSystemInDarkTheme()) {
                                colorResource(id = R.color.darkWhite)
                            } else colorResource(id = R.color.darkGrey),
                            route = Screen.DashboardScreen.route
                        ),
                        Menu(
                            id = 2009L,
                            title = "Alarm",
                            icon = Icons.Default.Alarm,
                            backgroundColor = colorResource(id = R.color.veryLightViolet),
                            iconColor = colorResource(id = R.color.onVeryLightViolet),
                            titleColor = if (isSystemInDarkTheme()) {
                                colorResource(id = R.color.darkWhite)
                            } else colorResource(id = R.color.darkGrey),
                            route = Screen.DashboardScreen.route
                        ),
                    )

                MenuCategory.Notes.name ->
                    listOf(
                        Menu(
                            id = 3001L,
                            title = "Add",
                            icon = Icons.Default.NoteAdd,
                            backgroundColor = colorResource(id = R.color.veryLightViolet),
                            iconColor = colorResource(id = R.color.onVeryLightViolet),
                            titleColor = if (isSystemInDarkTheme()) {
                                colorResource(id = R.color.darkWhite)
                            } else colorResource(id = R.color.darkGrey),
                            route = Screen.NoteDetailScreen.route
                        ),
                        Menu(
                            id = 3002L,
                            title = "Search",
                            icon = Icons.Default.ManageSearch,
                            backgroundColor = colorResource(id = R.color.lightTeal),
                            iconColor = colorResource(id = R.color.onLightTeal),
                            titleColor = if (isSystemInDarkTheme()) {
                                colorResource(id = R.color.darkWhite)
                            } else colorResource(id = R.color.darkGrey),
                            route = Screen.DashboardScreen.route
                        ),
                    )

                MenuCategory.NoteDetail.name ->
                    listOf(
                        Menu(
                            id = 3101L,
                            title = "Notes",
                            icon = Icons.Default.NoteAlt,
                            backgroundColor = colorResource(id = R.color.goldenYellow),
                            iconColor = colorResource(id = R.color.onGoldenYellow),
                            titleColor = if (isSystemInDarkTheme()) {
                                colorResource(id = R.color.darkWhite)
                            } else colorResource(id = R.color.darkGrey),
                            route = Screen.NotesScreen.route
                        ),
                    )

                else ->
                    listOf()
            }
        }
    }
}

