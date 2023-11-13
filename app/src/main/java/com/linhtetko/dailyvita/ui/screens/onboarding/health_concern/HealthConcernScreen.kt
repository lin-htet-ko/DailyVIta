package com.linhtetko.dailyvita.ui.screens.onboarding.health_concern

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.linhtetko.dailyvita.R
import com.linhtetko.dailyvita.domain.vos.HealthConcernVO
import com.linhtetko.dailyvita.ui.component.ButtonPair
import com.linhtetko.dailyvita.ui.component.SelectableChip
import com.linhtetko.dailyvita.ui.component.VerticalSpacer2x
import com.linhtetko.dailyvita.ui.component.VerticalSpacerGeneral
import com.linhtetko.dailyvita.ui.component.textLabelWithContent
import com.linhtetko.dailyvita.ui.theme.DailyVItaTheme

@Composable
fun HealthConcernScreen(
    modifier: Modifier = Modifier,
    healthConcernViewModel: HealthConcernViewModel,
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
                .fillMaxHeight()
                .padding(it)
                .padding(dimensionResource(id = R.dimen.space_3x))
        ) {

            healthConcernsSection(
                items = healthConcernViewModel.healthConcerns,
                onSelected = healthConcernViewModel::onSelectedHealthConcern
            )

            item {
                VerticalSpacer2x()
            }

            if (healthConcernViewModel.selectedHealthConcerns.isNotEmpty())
                textLabelWithContent(text = R.string.lbl_prioritize, isImportant = false) {
                    item {
                        VerticalSpacerGeneral()
                    }
                    items(healthConcernViewModel.selectedHealthConcerns) { item ->
                        PrioritizeItem(
                            modifier = Modifier
                                .padding(bottom = dimensionResource(id = R.dimen.space_small)),
                            label = item.name
                        )
                    }
                }
        }
    }
}

@Composable
private fun PrioritizeItem(modifier: Modifier = Modifier, label: String) {
    val cornerShape = RoundedCornerShape(dimensionResource(id = R.dimen.size_coner_general))
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(cornerShape)
            .background(MaterialTheme.colors.onPrimary.copy(alpha = 0.5f))
            .border(
                width = dimensionResource(id = R.dimen.size_stroke_general),
                color = MaterialTheme.colors.secondary,
                shape = cornerShape
            )
            .padding(
                horizontal = dimensionResource(id = R.dimen.space_general),
                vertical = dimensionResource(id = R.dimen.space_small_2x)
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        SelectableChip(label = label, isSelected = true, onSelected = {})
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Default.Menu, contentDescription = null)
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
private fun LazyListScope.healthConcernsSection(
    items: List<HealthConcernVO>, onSelected: (HealthConcernVO) -> Unit
) {
    textLabelWithContent(
        text = R.string.lbl_select_the_top_health_concerns,
        optionText = R.string.lbl_upto_5
    ) {
        item {
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.space_general)),
            ) {
                items.forEach { health ->
                    SelectableChip(modifier = Modifier.padding(top = dimensionResource(id = R.dimen.space_2x)),
                        label = health.name,
                        isSelected = health.isSelected,
                        onSelected = {
                            onSelected(health)
                        })
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HealthConcernScreenPreview() {
    DailyVItaTheme {
        HealthConcernScreen(
            healthConcernViewModel = hiltViewModel(),
            onTapBack = {},
            onTapNext = {}
        )
    }
}