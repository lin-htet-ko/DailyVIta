package com.linhtetko.dailyvita.ui.screens.onboarding.allergie

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.linhtetko.dailyvita.R
import com.linhtetko.dailyvita.domain.vos.AllergieVO
import com.linhtetko.dailyvita.ui.component.ButtonPair
import com.linhtetko.dailyvita.ui.component.SelectableChip
import com.linhtetko.dailyvita.ui.component.VerticalSpacer2x
import com.linhtetko.dailyvita.ui.component.textLabelWithContent
import com.linhtetko.dailyvita.ui.theme.DailyVItaTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun AllergiesScreen(
    modifier: Modifier = Modifier,
    allergiesViewModel: AllergiesViewModel,
    onTapBack: () -> Unit,
    onTapNext: () -> Unit
) {

    Scaffold(
        modifier = modifier,
        bottomBar = {
            ButtonPair(
                textPair = stringResource(id = R.string.lbl_back) to stringResource(id = R.string.lbl_next),
                onTapFirst = onTapBack,
                onTapSecond = onTapNext
            )
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(it)
                .padding(dimensionResource(id = R.dimen.space_3x))
        ) {
            textLabelWithContent(
                text = R.string.lbl_allergies_header,
                isImportant = false,
                optionText = R.string.lbl_optional
            ) {
                item {
                    VerticalSpacer2x()
                }
                item {
                    ActionsChips(
                        chips = allergiesViewModel.selectedAllergies.map { item -> item.name },
                        value = allergiesViewModel.inputAllergy,
                        onValueChange = allergiesViewModel::filterAllergies
                    )
                }
                item {
                    DropdownItems(
                        allergies = allergiesViewModel.filterAllergies,
                        onTapItem = allergiesViewModel::onSelectedAllergy
                    )
                }
            }
        }
    }
}

@Composable
fun DropdownItems(
    modifier: Modifier = Modifier,
    allergies: List<AllergieVO>,
    onTapItem: (AllergieVO) -> Unit
) {
    val generalCorner = dimensionResource(id = R.dimen.size_coner_general)

    Column(
        modifier = modifier
            .clip(
                RoundedCornerShape(
                    bottomEnd = generalCorner,
                    bottomStart = generalCorner
                )
            )
            .border(
                width = dimensionResource(id = R.dimen.size_stroke_general),
                color = MaterialTheme.colors.secondary.copy(alpha = 0.5f),
                shape = RoundedCornerShape(
                    bottomEnd = dimensionResource(id = R.dimen.size_coner_general),
                    bottomStart = dimensionResource(id = R.dimen.size_coner_general)
                )
            )
    ) {
        allergies.forEach { allergy ->
            DropdownMenuItem(
                modifier = Modifier.background(
                    MaterialTheme.colors.onPrimary.copy(
                        alpha = 0.7f
                    )
                ), onClick = { onTapItem(allergy) }
            ) {
                Text(text = allergy.name)
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun ActionsChips(
    modifier: Modifier = Modifier,
    chips: List<String>,
    value: String,
    onValueChange: (String) -> Unit
) {
    val generalCorner = dimensionResource(id = R.dimen.size_coner_general)
    BasicTextField(
        modifier = modifier.fillMaxWidth(),
        value = value,
        onValueChange = onValueChange,
        decorationBox = {
            FlowRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(
                        RoundedCornerShape(
                            topStart = generalCorner,
                            topEnd = generalCorner
                        )
                    )
                    .border(
                        width = dimensionResource(id = R.dimen.size_stroke_general),
                        color = MaterialTheme.colors.secondary.copy(alpha = 0.5f),
                        shape = RoundedCornerShape(
                            topStart = generalCorner,
                            topEnd = generalCorner
                        )
                    )
                    .background(
                        MaterialTheme.colors.onPrimary.copy(
                            alpha = 0.9f
                        )
                    )
                    .padding(dimensionResource(id = R.dimen.space_2x)),
                verticalAlignment = Alignment.CenterVertically
            ) {
                chips.forEach { allergy ->
                    SelectableChip(
                        modifier = Modifier.padding(
                            end = dimensionResource(id = R.dimen.space_general),
                            bottom = dimensionResource(id = R.dimen.space_general)
                        ),
                        label = allergy,
                        isSelected = true,
                        onSelected = {})
                }
                it()
            }
        })
}

@Preview(showBackground = true)
@Composable
private fun AllergiesScreenPreview() {
    DailyVItaTheme {
        AllergiesScreen(
            allergiesViewModel = hiltViewModel(),
            onTapBack = {},
            onTapNext = {}
        )
    }
}