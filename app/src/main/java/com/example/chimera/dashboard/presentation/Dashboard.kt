package com.example.chimera.dashboard.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.chimera.core.data.local.model.Menu
import com.example.chimera.core.data.local.model.MenuCategory
import com.example.chimera.core.presentation.BottomMenu

@Composable
fun Dashboard(navController: NavController) {
    BottomMenu(
        navController = navController,
        menuItems = Menu.getItems(category = MenuCategory.Dashboard.name)
    ) {

    }
}