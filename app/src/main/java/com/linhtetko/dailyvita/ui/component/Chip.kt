package com.linhtetko.dailyvita.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import com.linhtetko.dailyvita.R

@Composable
fun SelectableChip(
    modifier: Modifier = Modifier,
    label: String,
    isSelected: Boolean,
    onSelected: () -> Unit
) {
    Box(modifier = modifier
        .clip(CircleShape)
        .border(
            width = dimensionResource(id = R.dimen.size_stroke_general),
            color = MaterialTheme.colors.onBackground,
            shape = CircleShape
        )
        .background(if (isSelected) MaterialTheme.colors.secondary else Color.Transparent)
        .clickable { onSelected() }.padding(
            horizontal = dimensionResource(id = R.dimen.space_2x),
            vertical = dimensionResource(id = R.dimen.space_general)
        ), contentAlignment = Alignment.Center) {
        Text(
            text = label,
            color = if (isSelected) MaterialTheme.colors.onPrimary else MaterialTheme.colors.onBackground,
            softWrap = false
        )
    }
}