package com.example.chimera.core.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SheetValue
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.chimera.core.data.local.model.Menu
import com.example.chimera.core.data.local.model.MenuCategory
import com.example.chimera.core.presentation.components.GridMenu
import com.example.chimera.core.presentation.components.MenuItem
import com.example.chimera.core.presentation.components.RowMenu

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomMenu(
    navController: NavController,
    menuItems: List<Menu>,
    isVisible: Boolean = true,
    screen: @Composable () -> Unit,
) {
    val scaffoldState = rememberBottomSheetScaffoldState()

    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetPeekHeight = if (isVisible) 140.dp else 0.dp,
        sheetContainerColor = MaterialTheme.colorScheme.outlineVariant,
        sheetContent = {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                val mainMenuItems: List<Menu> = Menu.getItems(category = MenuCategory.Main.name)
                LazyColumn(
                    modifier = Modifier
                        .fillMaxHeight(0.5f)
                        .width(100.dp)
                        .background(
                            MaterialTheme.colorScheme.outlineVariant
                        )
                ) {
                    items(mainMenuItems) { item ->
                        MenuItem(
                            menu = item
                        ) {
                            navController.navigate(item.route)
                        }
                    }
                }
                Column(
                    modifier = Modifier
                        .fillMaxHeight(0.5f)
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.surface)
                ) {
                    if (scaffoldState.bottomSheetState.currentValue == SheetValue.Expanded) {
                        GridMenu(
                            navController = navController,
                            menuItems = menuItems
                        )
                    } else {
                        RowMenu(
                            navController = navController,
                            menuItems = menuItems
                        )
                    }
                }
            }
        }
    ) {
        screen()
    }
}

//@Preview(showSystemUi = true)
//@Composable
//fun Prev() {
//    BottomMenu(menuItems = Menu.getItems(category = MenuCategory.Dashboard.name)) {
//
//    }
//}