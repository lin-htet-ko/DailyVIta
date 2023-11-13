package com.linhtetko.dailyvita.ui.screens.onboarding.questions

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.linhtetko.dailyvita.R
import com.linhtetko.dailyvita.ui.component.PrimaryButton
import com.linhtetko.dailyvita.ui.component.RadioButtonGroup
import com.linhtetko.dailyvita.ui.component.VerticalSpacer2x
import com.linhtetko.dailyvita.ui.component.textLabelWithContent
import com.linhtetko.dailyvita.ui.theme.DailyVItaTheme

@Composable
fun QuestionsScreen(
    modifier: Modifier = Modifier,
    questionsViewModel: QuestionsViewModel,
    onTapPersonalize: () -> Unit
) {

    Scaffold(modifier = modifier, bottomBar = {
        PrimaryButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.space_3x)),
            label = stringResource(R.string.lbl_get_my_personlized_vitamin),
            onClick = onTapPersonalize
        )
    }) {
        LazyColumn(
            modifier = Modifier
                .padding(it)
                .padding(dimensionResource(id = R.dimen.space_3x))
        ) {
            textLabelWithContent(text = R.string.lbl_daily_expourse_sun_limited) {
                item {
                    RadioButtonGroup(
                        items = questionsViewModel.dailyExposureToSun,
                        onCheckChanged = questionsViewModel::onCheckChangeDailyExposure
                    )
                }
            }
            item {
                VerticalSpacer2x()
            }
            textLabelWithContent(text = R.string.lbl_currently_smoking) {
                item {
                    RadioButtonGroup(
                        items = questionsViewModel.currentSmokee,
                        onCheckChanged = questionsViewModel::onCheckChangeSmokee
                    )
                }
            }
            item {
                VerticalSpacer2x()
            }
            textLabelWithContent(text = R.string.lbl_average_alcoholic_per_week) {
                item {
                    RadioButtonGroup(
                        items = questionsViewModel.alcoholicPerWeek,
                        onCheckChanged = questionsViewModel::onCheckChangeAlcoholic
                    )
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun QuestionsScreenPreview() {
    DailyVItaTheme {
        QuestionsScreen(
            questionsViewModel = hiltViewModel(),
            onTapPersonalize = {}
        )
    }
}