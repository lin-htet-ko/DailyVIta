package com.linhtetko.dailyvita.ui.screens.get_started

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.linhtetko.dailyvita.R
import com.linhtetko.dailyvita.ui.component.PrimaryButton
import com.linhtetko.dailyvita.ui.component.VerticalSpacer2x
import com.linhtetko.dailyvita.ui.component.VerticalWeightSpacer
import com.linhtetko.dailyvita.ui.theme.DailyVItaTheme

@Composable
fun GetStartedScreen(modifier: Modifier = Modifier, onTapGetStarted: () -> Unit) {
    Column(
        modifier = modifier
            .background(MaterialTheme.colors.surface)
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.space_3x)),
    ) {
        VerticalWeightSpacer()
        Text(
            text = stringResource(R.string.lbl_welcome_to_dailyvita),
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Medium
        )
        VerticalSpacer2x()
        Text(
            text = stringResource(R.string.lbl_welcome_content_1),
            fontWeight = FontWeight.Medium
        )
        VerticalWeightSpacer()
        Image(
            imageVector = ImageVector.vectorResource(R.drawable.vector_chat_dicussion_undrawn),
            contentDescription = null
        )
        VerticalSpacer2x()
        Text(text = stringResource(R.string.lbl_welcome_content_2), fontWeight = FontWeight.Normal)
        VerticalWeightSpacer()
        PrimaryButton(
            modifier = Modifier.fillMaxWidth(),
            label = stringResource(R.string.lbl_get_started),
            onClick = onTapGetStarted
        )
        VerticalWeightSpacer()
    }
}

@Preview(showBackground = true)
@Composable
private fun GetStartedScreenPreview() {
    DailyVItaTheme {
        GetStartedScreen(onTapGetStarted = {})
    }
}