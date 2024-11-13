package com.shindze.domain.model

data class ProfileModel(
    val id: String,
    val firstName: String,
    val lastName: String,
    val imageUrl: String?,
    val phoneCode: String,
    val phoneNumber: String
) {
    companion object {
        val defaultValue = ProfileModel(
            id = "1",
            firstName = "Денис",
            lastName = "Радынов",
            imageUrl = "https://static.wikia.nocookie.net/avatar/images/f/f4/3%D1%8521_%D0%90%D0%B0%D0%BD%D0%B3.jpg/revision/latest?cb=20210125213454&path-prefix=ru",
            phoneCode = "+7",
            phoneNumber = "+79777109031"
        )
    }
}

