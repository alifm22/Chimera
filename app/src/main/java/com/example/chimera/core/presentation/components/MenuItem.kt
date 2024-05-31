package com.example.chimera.core.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.chimera.core.data.local.model.Menu
import com.example.chimera.ui.theme.spacing

@Composable
fun MenuItem(
    menu: Menu,
    onClick: ()->Unit
) {
    Column (
        modifier = Modifier
            .clickable { onClick() }
            .width(100.dp)
            .padding(MaterialTheme.spacing.small),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        Icon(
            modifier = Modifier
                .clip(MaterialTheme.shapes.large)
                .width(50.dp)
                .aspectRatio(1.0f)
                .background(color = menu.backgroundColor)
                .padding(MaterialTheme.spacing.xSmall),
            tint = menu.iconColor,
            imageVector = menu.icon,
            contentDescription = null
        )
        Spacer(modifier = Modifier
                .height(MaterialTheme.spacing.xSmall))
        Text(
            text = menu.title,
            color = menu.titleColor,
            style = MaterialTheme.typography.titleSmall
        )
    }
}

//@Preview
//@Composable
//fun Prev(){
//    MenuItem(
//        onClick = {},
//        menu = Menu(
//            id = 1L,
//            title = "Dashboard",
//            icon = Icons.Default.Dashboard,
//            backgroundColor = colorResource(id = R.color.lightTeal),
//            iconColor = colorResource(id = R.color.onLightTeal),
//            titleColor = colorResource(id = R.color.darkGrey),
//            route = Screen.DashboardScreen.route
//        )
//    )
//}