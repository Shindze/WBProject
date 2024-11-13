package com.shindze.wbschoolproject.presentation.viewmodel.state

internal data class ProfileUiState(
    val profileImage: String? = null,
    val firstName: String = "",
    val lastName: String = "",
    val phoneCode: String = "7",
    val phoneNumber: String = ""
)
