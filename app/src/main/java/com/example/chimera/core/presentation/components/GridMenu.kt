package com.example.chimera.core.presentation.components

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.chimera.core.data.local.model.Menu
import com.example.chimera.ui.theme.spacing

@Composable
fun GridMenu(
    navController: NavController,
    menuItems: List<Menu>,
) {
    LazyVerticalGrid(columns = GridCells.Fixed(3),
        modifier = Modifier
            .fillMaxHeight()
            .padding(bottom = MaterialTheme.spacing.large)
    ){
        items(menuItems){item ->
            MenuItem(menu = item){
                navController.navigate(item.route)
            }
        }
    }
}