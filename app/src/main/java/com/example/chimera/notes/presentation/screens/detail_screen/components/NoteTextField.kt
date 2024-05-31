package com.example.chimera.notes.presentation.screens.detail_screen.components

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.chimera.core.presentation.components.rememberImeState
import com.example.chimera.notes.presentation.components.getOnColor
import com.example.chimera.notes.presentation.events.NoteDetailEvents

@Composable
fun NoteTextField(
    modifier: Modifier = Modifier,
    value: String,
//    onValueChange: Unit
    label: String,
    labelAlign: TextAlign? = null,
    color: Int,
    isBold: Boolean = false,
    isEditable: Boolean? = false,
    isTitle: Boolean,
    onEvent: (NoteDetailEvents) -> Unit,
) {
    val imeState = rememberImeState()
    var textFieldValue by remember { mutableStateOf(TextFieldValue(value)) }
    OutlinedTextField(
        value = textFieldValue,
        onValueChange = { newValue ->
            textFieldValue = newValue
            onEvent(NoteDetailEvents.ContentChange(newValue.text))
        },
        modifier = modifier,
        enabled = isEditable == true,
        maxLines = if (isTitle) 2 else if (imeState.value) 10 else 20,
        colors = TextFieldDefaults.colors(
            disabledContainerColor = Color.Transparent,
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            focusedTextColor = colorResource(id = getOnColor(color = color)),
            unfocusedTextColor = colorResource(id = getOnColor(color = color)),
            disabledTextColor = colorResource(id = getOnColor(color = color)),
            disabledIndicatorColor = Color.Transparent
        ),
        textStyle = TextStyle(
            fontWeight = if (isBold) FontWeight.Bold else FontWeight.Normal,
            fontSize = 14.sp
        ),
        placeholder = {
            Text(
                text = "Insert $label",
                textAlign = labelAlign,
                color = colorResource(id = getOnColor(color = color)),
                style = TextStyle(
                    fontWeight = if (isBold) FontWeight.Bold else FontWeight.Normal,
                    fontSize = 14.sp
                )
            )
        }
    )
}