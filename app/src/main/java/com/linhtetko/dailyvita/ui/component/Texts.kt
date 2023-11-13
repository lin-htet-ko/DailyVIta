package com.linhtetko.dailyvita.ui.component

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString

@OptIn(ExperimentalLayoutApi::class)
fun LazyListScope.textLabelWithContent(
    @StringRes text: Int,
    @StringRes optionText: Int? = null,
    isImportant: Boolean = true,
    content: LazyListScope.() -> Unit
) {
    item {
        FlowRow {
            Text(
                text = buildAnnotatedString {
                    append(stringResource(id = text))
                    if (isImportant) append(buildAnnotatedString {
                        addStyle(
                            style = SpanStyle(
                                color = MaterialTheme.colors.primary
                            ), 0, 2
                        )
                        append(" * ")
                    }
                    )
                },
                style = MaterialTheme.typography.h6,
            )
            if (optionText != null) Text(
                text = stringResource(id = optionText),
                style = MaterialTheme.typography.h6,
            )
        }
    }
    item {

        VerticalSpacerGeneral()
    }
    content()
}