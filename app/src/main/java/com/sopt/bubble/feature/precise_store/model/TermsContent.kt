package com.sopt.bubble.feature.precise_store.model

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color
import com.sopt.bubble.R
import com.sopt.bubble.ui.theme.Gray400
import com.sopt.bubble.ui.theme.White

data class TermsContent(
    @StringRes
    val content: Int,
    val textColor: Color = Gray400
)

val terms01 = listOf(
    TermsContent(content = R.string.precise_store_checkbox_body01_1),
    TermsContent(content = R.string.precise_store_checkbox_body01_2, textColor = White),
    TermsContent(content = R.string.precise_store_checkbox_body01_3, textColor = White),
    TermsContent(content = R.string.precise_store_checkbox_body01_4))

val terms02 = listOf(
    TermsContent(content = R.string.precise_store_checkbox_body02_1, textColor = White),
    TermsContent(content = R.string.precise_store_checkbox_body02_2))

val terms03 = listOf(
    TermsContent(content = R.string.precise_store_checkbox_body03, textColor = White))