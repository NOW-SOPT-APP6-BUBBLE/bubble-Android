package com.sopt.bubble.feature.friends

import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.sopt.bubble.R
import com.sopt.bubble.data.dataclass.FriendsArtist
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class FriendsViewModel : ViewModel() {

    private val _starFriends = MutableStateFlow(
        listOf(
            FriendsArtist(
                profileImage = R.drawable.ic_more_profile,
                name = "설유니",
                description = ""
            ),
            FriendsArtist(
                profileImage = R.drawable.ic_more_profile,
                name = "설유니",
                description = ""
            ),
            FriendsArtist(
                profileImage = R.drawable.ic_more_profile,
                name = "설유니",
                description = ""
            ),
        )
    )
    val starFriendsState = _starFriends.asStateFlow()

    private val _friendsArtist = MutableStateFlow(
        listOf(
            FriendsArtist(
                profileImage = R.drawable.ic_more_profile,
                name = "설유니",
                description = ""
            ),
            FriendsArtist(
                profileImage = R.drawable.ic_more_profile,
                name = "설유니",
                description = ""
            ),
            FriendsArtist(
                profileImage = R.drawable.ic_more_profile,
                name = "설유니",
                description = ""
            ),
            FriendsArtist(
                profileImage = R.drawable.ic_more_profile,
                name = "설유니",
                description = ""
            ),
            FriendsArtist(
                profileImage = R.drawable.ic_more_profile,
                name = "설유니",
                description = ""
            ),
            FriendsArtist(
                profileImage = R.drawable.ic_more_profile,
                name = "설유니",
                description = ""
            ),
        )
    )
    val friendsArtistState = _friendsArtist.asStateFlow()

    companion object FriendsComponentConstants {
        const val TOP_BAR_RATIO = 360/62f
        val COLLAPSED_TOP_BAR_HEIGHT = 56.dp
        val EXPANDED_TOP_BAR_HEIGHT = 200.dp
        const val ENTER_EXPAND_FROM_TOP_INITIAL_HEIGHT = 20
        const val EXIT_SHRINK_DIVISOR = 2
    }
}
