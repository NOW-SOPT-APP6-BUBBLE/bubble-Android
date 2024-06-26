package com.sopt.bubble.feature.more

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.sopt.bubble.R
import com.sopt.bubble.feature.more.MoreViewModel.Companion.menuList
import com.sopt.bubble.feature.more.component.MoreTopAppBar
import com.sopt.bubble.feature.nav.BubbleBottomNavigation
import com.sopt.bubble.feature.nav.Screen
import com.sopt.bubble.ui.theme.Black
import com.sopt.bubble.ui.theme.Body03
import com.sopt.bubble.ui.theme.Gray100
import com.sopt.bubble.ui.theme.Gray200
import com.sopt.bubble.ui.theme.Headline04
import com.sopt.bubble.ui.theme.JYPBLUE
import com.sopt.bubble.ui.theme.White

@Composable
fun MoreScreen(
    onNavigate: NavHostController,
    modifier: Modifier = Modifier,
    viewModel: MoreViewModel = viewModel(),
) {
    val uiState by viewModel.uiState.collectAsState()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { MoreTopAppBar() },
        bottomBar = { BubbleBottomNavigation(navHostController = onNavigate) }
    ) { paddingValues ->
        Column(
            modifier = modifier.padding(paddingValues)
        ) {
            MoreUserProfile(
                uiState = uiState
            )

            Spacer(
                modifier = Modifier
                    .padding(start = 20.dp, end = 20.dp, top = 37.dp, bottom = 6.dp)
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(color = Gray100)
            )

            for (menu in menuList) {
                MoreMenuButton(
                    iconResId = menu.iconResId,
                    textResId = menu.textResId,
                    onClick = { if(menu.textResId == R.string.more_btn_store) onNavigate.navigate(Screen.Store.route) }
                )
            }
        }
    }
}


@Composable
private fun MoreUserProfile(
    uiState: MoreUiState,
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box {
            Image(
                painter = painterResource(id = R.drawable.ic_more_profile),
                contentDescription = null
            )

            Image(
                painter = painterResource(id = R.drawable.ic_more_profile_edit),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 100.dp, top = 100.dp)
                    .background(
                        shape = RoundedCornerShape(size = 30.dp),
                        color = White
                    )
            )
        }

        Text(
            text = uiState.nickName,
            style = Headline04,
            color = Black,
            modifier = Modifier.padding(top = 14.dp)
        )

        Text(
            text = uiState.email,
            style = Body03,
            color = Gray200,
            modifier = Modifier.padding(top = 10.dp)
        )
    }
}

@Composable
fun MoreMenuButton(
    @DrawableRes
    iconResId: Int,
    @StringRes
    textResId: Int,
    onClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .padding(vertical = 6.dp, horizontal = 20.dp)
            .fillMaxWidth()
            .height(48.dp)
            .clickable { onClick() },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = iconResId),
                contentDescription = null
            )
            Text(
                text = stringResource(id = textResId),
                color = Black,
                modifier = Modifier.padding(start = 14.dp)
            )
        }
        Icon(
            painter = painterResource(id = R.drawable.ic_more_btn_arrow),
            contentDescription = null,
            tint = JYPBLUE
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MoreScreenPreview() {
    //MoreScreen()
}

@Preview(showBackground = true)
@Composable
fun MoreMenuButtonPreview() {
    MoreMenuButton(
        iconResId = R.drawable.ic_more_my_bubble,
        textResId = R.string.more_btn_my_bubble,
        onClick = {}
    )
}