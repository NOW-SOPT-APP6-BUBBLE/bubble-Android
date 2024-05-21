package com.sopt.bubble.feature.friends

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
}