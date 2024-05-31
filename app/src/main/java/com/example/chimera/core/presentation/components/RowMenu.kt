package com.example.chimera.core.presentation.components

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.chimera.core.data.local.model.Menu

@Composable
fun RowMenu(
    navController: NavController,
    modifier: Modifier = Modifier,
    menuItems: List<Menu>,
) {
    LazyRow(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(fraction = 0.5f),

    ){
        items(menuItems){item ->
            MenuItem(menu = item){
                navController.navigate(item.route)
            }
        }
    }
}