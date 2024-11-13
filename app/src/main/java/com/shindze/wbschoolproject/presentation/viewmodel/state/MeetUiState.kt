package com.shindze.wbschoolproject.presentation.viewmodel.state

internal data class MeetUiState(
    val id: String = "1",
    val imageUrl: String? = null,
    val name: String = "Встреча",
    val date: String = "01.01.1990",
    val isClosed: Boolean = false,
    val tagList: List<String> = emptyList()
)

