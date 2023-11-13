package com.linhtetko.dailyvita.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Checkbox
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import com.linhtetko.dailyvita.R
import com.linhtetko.dailyvita.ui.theme.LightBlue

@Composable
fun PrimaryButton(modifier: Modifier = Modifier, label: String, onClick: () -> Unit) {
    Button(
        modifier = modifier,
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.space_small)),
        onClick = onClick,
    ) {
        Text(
            modifier = Modifier.padding(dimensionResource(id = R.dimen.space_small)),
            text = label
        )
    }
}

@Composable
fun OutlinedButton(modifier: Modifier = Modifier, label: String, onClick: () -> Unit) {
    TextButton(modifier = modifier, onClick = onClick) {
        Text(modifier = Modifier.padding(dimensionResource(id = R.dimen.space_small)), text = label)
    }
}

@Composable
fun ButtonPair(
    modifier: Modifier = Modifier,
    textPair: Pair<String, String>,
    onTapFirst: () -> Unit,
    onTapSecond: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                horizontal = dimensionResource(id = R.dimen.space_2x),
                vertical = dimensionResource(id = R.dimen.space_3x)
            ), horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        OutlinedButton(label = textPair.first, modifier = Modifier.weight(1f), onClick = onTapFirst)
        HorizontalSpacerGeneral()
        PrimaryButton(
            modifier = Modifier.weight(1f),
            label = textPair.second,
            onClick = onTapSecond
        )
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CheckboxWithLabel(
    modifier: Modifier = Modifier,
    label: String,
    toolTip: String? = null,
    isSelected: Boolean,
    showTooltip: Boolean = false,
    onChecked: () -> Unit,
    onTapTooltip: () -> Unit
) {
    Row(
        modifier = modifier
            .padding(bottom = dimensionResource(id = R.dimen.space_general)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(checked = isSelected, onCheckedChange = { onChecked() })
        Text(
            text = label, style = MaterialTheme.typography.button
        )
        if (!toolTip.isNullOrEmpty()) {
            IconButton(onClick = onTapTooltip) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_rounded_help),
                    contentDescription = null,
                    tint = LightBlue
                )
            }
        }

        if (showTooltip && !toolTip.isNullOrEmpty())
            Box(
                modifier = Modifier
                    .weight(1f)
            ) {
                Popup(
                    alignment = Alignment.CenterEnd,
                    offset = IntOffset(180, 0),
                    properties = PopupProperties(
                        usePlatformDefaultWidth = true
                    )
                ) {
                    Text(
                        modifier = Modifier
                            .padding(end = dimensionResource(id = R.dimen.space_general))
                            .fillMaxWidth(0.75f)
                            .border(
                                width = dimensionResource(id = R.dimen.size_stroke_general),
                                color = MaterialTheme.colors.secondary.copy(alpha = 0.5f),
                                shape = RoundedCornerShape(dimensionResource(id = R.dimen.size_coner_general))
                            )
                            .clip(RoundedCornerShape(dimensionResource(id = R.dimen.size_coner_general)))
                            .background(MaterialTheme.colors.onPrimary)
                            .padding(dimensionResource(id = R.dimen.space_general)),
                        text = toolTip,
                    )
                }
            }
    }
}

@Composable
fun RadioButtonWithLabel(
    modifier: Modifier = Modifier,
    isSelected: Boolean = false,
    label: String,
    onCheckChanged: () -> Unit
) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        RadioButton(selected = isSelected, onClick = onCheckChanged)
        Text(text = label, fontWeight = FontWeight.Medium)
    }
}

@Composable
fun RadioButtonGroup(
    modifier: Modifier = Modifier,
    items: List<Pair<String, Boolean>>,
    onCheckChanged: (index: Int) -> Unit
) {

    Column(modifier = modifier) {
        items.forEachIndexed { index, item ->
            RadioButtonWithLabel(
                label = item.first,
                isSelected = item.second,
                onCheckChanged = { onCheckChanged(index) }
            )
        }
    }

}