package com.shindze.domain.model

data class MeetModel(
    val id: String,
    val imageUrl: String,
    val name: String,
    val date: String,
    val isClosed: Boolean = false,
    val tagList: List<String>
) {
    companion object {
        val defaultValue = MeetModel(
            id = "1",
            imageUrl = "https://storage.yandexcloud.net/newspressfeed/wp-content/uploads/2023/12/offline-events.png",
            name = "Мероприятие",
            date = "01.01.1990",
            isClosed = false,
            tagList = listOf("Moscow")
        )
    }
}

