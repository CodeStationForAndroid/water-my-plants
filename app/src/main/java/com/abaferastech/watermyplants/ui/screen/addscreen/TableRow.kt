package com.abaferastech.watermyplants.ui.screen.addscreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun TableRow(
    modifier: Modifier = Modifier,
    label: String? = null,
    hasArrow: Boolean = false,
    isDestructive: Boolean = false,
    detailContent: (@Composable RowScope.() -> Unit)? = null,
    content: (@Composable RowScope.() -> Unit)? = null
) {
    val textColor = if (isDestructive) Color.Red else Color.Black



    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        if (label != null) {
            Text(
                text = label,
                color = textColor,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp)
            )
        }
        if (content != null) {
            content()
        }
        if (hasArrow) {
            Icon(
                imageVector = (Icons.Default.ArrowForward),
                contentDescription = "Right arrow",
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 10.dp)
            )
        }
        if (detailContent != null) {
            detailContent()
        }
    }
}