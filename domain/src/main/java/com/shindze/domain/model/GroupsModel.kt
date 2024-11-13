package com.shindze.domain.model

data class GroupsModel(
    val id: String,
    val title: String,
    val description: String,
    val imageUrl: String,
    val size: Int,
) {
    companion object {
        val defaultValue = GroupsModel(
            id = "1",
            title = "Designa",
            description = "Lorem ipsum dolor sit amet consectetur. Libero duis cum egestas amet mollis massa. Convallis sit lacus tortor interdum auctor viverra vitae. Egestas aliquam odio aenean eget facilisi ipsum vitae. Risus lectus quam urna condimentum id massa magna id mattis. Sit tempor volutpat ac eget dignissim nibh sagittis vitae duis. Vivamus quis fusce egestas vel sodales arcu praesent non. Ullamcorper elit sit eros egestas euismod amet. Nec molestie a sit sed. At neque diam turpis cursus tincidunt nisi quam sed non. Tempor tortor ultricies ultrices maecenas lectus in nunc sapien dapibus.\n" + "        \\nVolutpat placerat et placerat felis tristique quis. Pharetra velit faucibus lobortis vitae dui. Nibh diam velit hendrerit posuere vel ut augue varius velit. Eu eget ipsum vulputate consectetur adipiscing est mollis eleifend quisque. Porttitor senectus nibh",
            imageUrl = "https://img.freepik.com/premium-vector/group-people-together-young-men-women_507816-688.jpg",
            size = 10000
        )
    }
}

