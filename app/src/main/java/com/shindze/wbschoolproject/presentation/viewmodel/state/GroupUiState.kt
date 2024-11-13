package com.shindze.wbschoolproject.presentation.viewmodel.state

internal data class GroupUiState(
    val id: String = "1",
    val title: String = "Designa",
    val description: String = "Описание",
    val imageUrl: String? = null,
    val size: Int = 10000
)
