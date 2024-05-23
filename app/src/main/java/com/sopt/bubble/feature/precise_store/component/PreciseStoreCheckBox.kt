package com.sopt.bubble.feature.precise_store.component

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.sopt.bubble.R
import com.sopt.bubble.feature.precise_store.model.CheckBoxContent
import com.sopt.bubble.ui.theme.Body02
import com.sopt.bubble.ui.theme.Body03
import com.sopt.bubble.ui.theme.Gray800
import com.sopt.bubble.ui.theme.White
import com.sopt.bubble.util.extension.noRippleClickable

@Composable
fun PreciseStoreCheckBox(
    checkBoxContent: CheckBoxContent
) {
    var isTextFolded: Boolean by remember { mutableStateOf(false) }

    val foldImageDrawRes =
        if (isTextFolded) R.drawable.ic_precise_store_fold
        else R.drawable.ic_precise_store_unfold
    val checkImageRes =
        if (checkBoxContent.isChecked) R.drawable.ic_precise_store_checkbox_selected
        else R.drawable.ic_precise_store_checkbox_unselected

    Card(
        shape = RoundedCornerShape(
            topStart = 10.dp, topEnd = 10.dp,
            bottomStart = 10.dp, bottomEnd = 10.dp
        ),
        colors = CardDefaults.cardColors(containerColor = Gray800),
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioNoBouncy,
                    stiffness = Spring.StiffnessMedium
                )
            )
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 9.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .noRippleClickable { isTextFolded = !isTextFolded },
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        painter = painterResource(id = checkImageRes),
                        contentDescription = stringResource(id = R.string.precise_store_content_description_checkbox_checked),
                        modifier = Modifier.noRippleClickable { checkBoxContent.onClickCheckBox }
                    )

                    Text(
                        text = stringResource(id = checkBoxContent.title),
                        style = Body02,
                        color = White,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }

                Image(
                    painter = painterResource(id = foldImageDrawRes),
                    contentDescription = stringResource(id = R.string.precise_store_content_description_fold),
                )
            }

            if (isTextFolded) {
                Column (
                    modifier = Modifier.padding(
                        top = 12.dp, start = 1.dp, end = 1.dp, bottom = 11.dp
                    )
                ) {
                    for (content in checkBoxContent.content) {
                        Text(
                            text = stringResource(id = content.content),
                            style = Body03,
                            color = content.textColor,)
                    }
                }
            }
        }
    }
}