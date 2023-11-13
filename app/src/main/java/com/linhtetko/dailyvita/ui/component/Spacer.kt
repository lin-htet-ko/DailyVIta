package com.linhtetko.dailyvita.ui.component

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import com.linhtetko.dailyvita.R

@Composable
fun ColumnScope.VerticalWeightSpacer() {
    Spacer(modifier = Modifier.weight(1f))
}

@Composable
fun VerticalSpacerGeneral() {
    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.space_general)))
}

@Composable
fun VerticalSpacer2x() {
    Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.space_2x)))
}

@Composable
fun HorizontalSpacerGeneral() {
    Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.space_general)))

}