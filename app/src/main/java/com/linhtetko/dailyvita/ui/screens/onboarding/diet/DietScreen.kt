package com.linhtetko.dailyvita.ui.screens.onboarding.diet

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.linhtetko.dailyvita.R
import com.linhtetko.dailyvita.ui.component.ButtonPair
import com.linhtetko.dailyvita.ui.component.CheckboxWithLabel
import com.linhtetko.dailyvita.ui.component.VerticalSpacer2x
import com.linhtetko.dailyvita.ui.component.textLabelWithContent
import com.linhtetko.dailyvita.ui.theme.DailyVItaTheme

@Composable
fun DietScreen(
    modifier: Modifier = Modifier,
    dietViewModel: DietViewModel,
    onTapBack: () -> Unit,
    onTapNext: () -> Unit
) {
    Scaffold(modifier = modifier, bottomBar = {
        ButtonPair(
            textPair = stringResource(id = R.string.lbl_back) to stringResource(id = R.string.lbl_next),
            onTapFirst = onTapBack,
            onTapSecond = onTapNext
        )
    }) {
        LazyColumn(
            modifier = Modifier
                .padding(it)
                .padding(dimensionResource(id = R.dimen.space_3x))
        ) {
            textLabelWithContent(text = R.string.lbl_diet_follow) {
                item {
                    VerticalSpacer2x()
                }
                item {
                    CheckboxWithLabel(
                        label = stringResource(R.string.lbl_none),
                        isSelected = dietViewModel.isNoneSelected(),
                        showTooltip = false,
                        toolTip = null,
                        onChecked = {},
                        onTapTooltip = {}
                    )
                }
                items(dietViewModel.diets) { diet ->
                    CheckboxWithLabel(
                        label = diet.name,
                        isSelected = diet.isSelected,
                        showTooltip = diet.showTooltip,
                        toolTip = diet.toolTip,
                        onChecked = {
                            dietViewModel.onCheckDietItem(diet)
                        },
                        onTapTooltip = {
                            dietViewModel.onTapShowTooltip(diet)
                        }
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DietScreenPreview() {
    DailyVItaTheme {
        DietScreen(
            dietViewModel = hiltViewModel(),
            onTapBack = {},
            onTapNext = {}
        )
    }
}