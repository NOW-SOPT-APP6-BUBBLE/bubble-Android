package com.sopt.bubble.feature.precise_store.model

import android.icu.text.CaseMap.Title
import androidx.annotation.StringRes
import com.sopt.bubble.R
import com.sopt.bubble.feature.precise_store.PreciseStoreViewModel

data class CheckBoxContent(
    @StringRes
    val title: Int,
    val content: List<TermsContent>,
    var isChecked: Boolean = false,
    var onClickCheckBox:() -> Unit = {}
)

val checkBoxList: List<CheckBoxContent> = listOf(
    CheckBoxContent(
        title = R.string.precise_store_checkbox_title01,
        content = terms01
    ),
    CheckBoxContent(
        title = R.string.precise_store_checkbox_title02,
        content = terms02
    ),
    CheckBoxContent(
        title = R.string.precise_store_checkbox_title03,
        content = terms03
    )
)
