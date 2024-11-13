package com.shindze.repository.mock

import com.shindze.domain.model.GroupsModel
import com.shindze.domain.model.MeetModel
import com.shindze.domain.model.ProfileModel
import com.shindze.domain.model.SettingButtonModel
import com.shindze.repository.R

object MockData {

    fun getMeetsListData() = meetsLists
    fun getGuestsListData() = guestsList
    fun getGroupsListData() = groupsModelLists
    fun getSettingsListData() = settingsButtonList
    fun getExtendedSettingsButtonListData() = extendedSettingsButtonList


    private var meetsLists = listOf(
        MeetModel(
            id = "1",
            imageUrl = "https://papik.pro/grafic/uploads/posts/2023-09/1693980728_papik-pro-p-plakati-den-amerikanskogo-futbola-55.jpg",
            name = "Хоккей",
            date = "12.03.2002",
            isClosed = true,
            tagList = listOf("Москва", "Хоккей", "Кубок", "Спартак")
        ),
        MeetModel(
            id = "2",
            imageUrl = "https://static.tildacdn.com/tild3462-6563-4032-a466-623531353565/image.png",
            name = "Стройка",
            date = "23.04.2021",
            isClosed = false,
            tagList = listOf("Санкт Петербург", "Россия", "Лавочка")
        ),
        MeetModel(
            id = "3",
            imageUrl = "https://sun9-72.userapi.com/impg/irSEm53eW3O81mz7-oUGB0CaMpZggpACaTAvSA/AXMP4jgVDro.jpg?size=814x588&quality=96&sign=a1f81ea6e93531e5b3ffab950826e927&c_uniq_tag=mPUtlxCFclFNPt6RtlX01OIeqasZxCUxJvO-zhc3bCI&type=album",
            name = "Фестиваль кино",
            date = "10.06.2021",
            isClosed = false,
            tagList = listOf("Москва", "Россия", "Кино")
        ),
        MeetModel(
            id = "4",
            imageUrl = "https://www.yuga.ru/media/77/6e/dsc_0454__9hpeovv.jpg",
            name = "Выставка искусства",
            date = "15.07.2021",
            isClosed = true,
            tagList = listOf("Нью-Йорк", "США", "Искусство")
        ),
        MeetModel(
            id = "5",
            imageUrl = "https://furman.top/uploads/posts/2022-06/1654265530_64-furman-top-p-marketing-art-krasivo-oboi-66.jpg",
            name = "Конференция по технологиям",
            date = "20.09.2021",
            isClosed = false,
            tagList = listOf("Сан-Франциско", "США", "Технологии")
        ),
        MeetModel(
            id = "6",
            imageUrl = "https://static.tildacdn.com/tild3063-6330-4539-a464-376630643239/GENERAL_FUNNEL_SSB_A.png",
            name = "Музыкальный фестиваль",
            date = "05.08.2021",
            isClosed = false,
            tagList = listOf("Лондон", "Великобритания", "Музыка")
        ),
        MeetModel(
            id = "7",
            imageUrl = "https://avatars.mds.yandex.net/i?id=f3e541a0e4bbd265bb66f1d654accbbaafdb9bb1-5242334-images-thumbs&n=13",
            name = "Спортивный турнир",
            date = "30.10.2021",
            isClosed = true,
            tagList = listOf("Токио", "Япония", "Спорт")
        ),
        MeetModel(
            id = "8",
            imageUrl = "https://storage.yandexcloud.net/newspressfeed/wp-content/uploads/2023/12/offline-events.png",
            name = "Мероприятие",
            date = "01.01.1990",
            isClosed = false,
            tagList = listOf("Лондон")
        ),
    )

    private var guestsList = listOf(
        ProfileModel(
            id = "1",
            firstName = "Денис",
            lastName = "Радынов",
            imageUrl = "https://static.wikia.nocookie.net/avatar/images/f/f4/3%D1%8521_%D0%90%D0%B0%D0%BD%D0%B3.jpg/revision/latest?cb=20210125213454&path-prefix=ru",
            phoneCode = "+7",
            phoneNumber = "+79777109031"
        ),
        ProfileModel(
            id = "1",
            firstName = "Денис",
            lastName = "Радынов",
            imageUrl = "https://static.wikia.nocookie.net/avatar/images/f/f4/3%D1%8521_%D0%90%D0%B0%D0%BD%D0%B3.jpg/revision/latest?cb=20210125213454&path-prefix=ru",
            phoneCode = "+7",
            phoneNumber = "+79777109031"
        ),
        ProfileModel(
            id = "1",
            firstName = "Денис",
            lastName = "Радынов",
            imageUrl = "https://static.wikia.nocookie.net/avatar/images/f/f4/3%D1%8521_%D0%90%D0%B0%D0%BD%D0%B3.jpg/revision/latest?cb=20210125213454&path-prefix=ru",
            phoneCode = "+7",
            phoneNumber = "+79777109031"
        ),
        ProfileModel(
            id = "1",
            firstName = "Денис",
            lastName = "Радынов",
            imageUrl = "https://static.wikia.nocookie.net/avatar/images/f/f4/3%D1%8521_%D0%90%D0%B0%D0%BD%D0%B3.jpg/revision/latest?cb=20210125213454&path-prefix=ru",
            phoneCode = "+7",
            phoneNumber = "+79777109031"
        ),
        ProfileModel(
            id = "1",
            firstName = "Денис",
            lastName = "Радынов",
            imageUrl = "https://static.wikia.nocookie.net/avatar/images/f/f4/3%D1%8521_%D0%90%D0%B0%D0%BD%D0%B3.jpg/revision/latest?cb=20210125213454&path-prefix=ru",
            phoneCode = "+7",
            phoneNumber = "+79777109031"
        ),
        ProfileModel(
            id = "1",
            firstName = "Денис",
            lastName = "Радынов",
            imageUrl = "https://static.wikia.nocookie.net/avatar/images/f/f4/3%D1%8521_%D0%90%D0%B0%D0%BD%D0%B3.jpg/revision/latest?cb=20210125213454&path-prefix=ru",
            phoneCode = "+7",
            phoneNumber = "+79777109031"
        ),
        ProfileModel(
            id = "1",
            firstName = "Денис",
            lastName = "Радынов",
            imageUrl = "https://static.wikia.nocookie.net/avatar/images/f/f4/3%D1%8521_%D0%90%D0%B0%D0%BD%D0%B3.jpg/revision/latest?cb=20210125213454&path-prefix=ru",
            phoneCode = "+7",
            phoneNumber = "+79777109031"
        ),
    )

    private var groupsModelLists = listOf(
        GroupsModel(
            id = "1",
            title = "Designa",
            description = "Что за группа",
            imageUrl = "https://img.freepik.com/premium-vector/group-people-together-young-men-women_507816-688.jpg",
            size = 4324
        ),
        GroupsModel(
            id = "2",
            title = "ВКОНТАКТЕ",
            description = "Lorem ipsum dolor sit amet consectetur. Libero duis cum egestas amet mollis massa. Convallis sit lacus tortor interdum auctor viverra vitae. Egestas aliquam odio aenean eget facilisi ipsum vitae. Risus lectus quam urna condimentum id massa magna id mattis. Sit tempor volutpat ac eget dignissim nibh sagittis vitae duis. Vivamus quis fusce egestas vel sodales arcu praesent non. Ullamcorper elit sit eros egestas euismod amet. Nec molestie a sit sed. At neque diam turpis cursus tincidunt nisi quam sed non. Tempor tortor ultricies ultrices maecenas lectus in nunc sapien dapibus.\\n\" + \"        \\\\nVolutpat placerat et placerat felis tristique quis. Pharetra velit faucibus lobortis vitae dui. Nibh diam velit hendrerit posuere vel ut augue varius velit. Eu eget ipsum vulputate consectetur adipiscing est mollis eleifend quisque. Porttitor senectus nibh\",\n",
            imageUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f3/VK_Compact_Logo_%282021-present%29.svg/640px-VK_Compact_Logo_%282021-present%29.svg.png",
            size = 546456
        ),
        GroupsModel(
            id = "3",
            title = "ВАЛБЕРИС",
            description = "Lorem ipsum dolor sit amet consectetur. Libero duis cum egestas amet mollis massa. Convallis sit lacus tortor interdum auctor viverra vitae. Egestas aliquam odio aenean eget facilisi ipsum vitae. Risus lectus quam urna condimentum id massa magna id mattis. Sit tempor volutpat ac eget dignissim nibh sagittis vitae duis. Vivamus quis fusce egestas vel sodales arcu praesent non. Ullamcorper elit sit eros egestas euismod amet. Nec molestie a sit sed. At neque diam turpis cursus tincidunt nisi quam sed non. Tempor tortor ultricies ultrices maecenas lectus in nunc sapien dapibus.\\n\" + \"        \\\\nVolutpat placerat et placerat felis tristique quis. Pharetra velit faucibus lobortis vitae dui. Nibh diam velit hendrerit posuere vel ut augue varius velit. Eu eget ipsum vulputate consectetur adipiscing est mollis eleifend quisque. Porttitor senectus nibh\",\n",
            imageUrl = "https://bmarket24.ru/upload/iblock/import/LS01m5BRQC.jpg",
            size = 1045334234
        ),
        GroupsModel(
            id = "4",
            title = "ТЕЛЕГРАМ",
            description = "Lorem ipsum dolor sit amet consectetur. Libero duis cum egestas amet mollis massa. Convallis sit lacus tortor interdum auctor viverra vitae. Egestas aliquam odio aenean eget facilisi ipsum vitae. Risus lectus quam urna condimentum id massa magna id mattis. Sit tempor volutpat ac eget dignissim nibh sagittis vitae duis. Vivamus quis fusce egestas vel sodales arcu praesent non. Ullamcorper elit sit eros egestas euismod amet. Nec molestie a sit sed. At neque diam turpis cursus tincidunt nisi quam sed non. Tempor tortor ultricies ultrices maecenas lectus in nunc sapien dapibus.\\n\" + \"        \\\\nVolutpat placerat et placerat felis tristique quis. Pharetra velit faucibus lobortis vitae dui. Nibh diam velit hendrerit posuere vel ut augue varius velit. Eu eget ipsum vulputate consectetur adipiscing est mollis eleifend quisque. Porttitor senectus nibh\",\n",
            imageUrl = "https://lavali.ru/wp-content/uploads/2024/04/Telegram1.png",
            size = 123
        ),
        GroupsModel(
            id = "5",
            title = "МДК",
            description = "Lorem ipsum dolor sit amet consectetur. Libero duis cum egestas amet mollis massa. Convallis sit lacus tortor interdum auctor viverra vitae. Egestas aliquam odio aenean eget facilisi ipsum vitae. Risus lectus quam urna condimentum id massa magna id mattis. Sit tempor volutpat ac eget dignissim nibh sagittis vitae duis. Vivamus quis fusce egestas vel sodales arcu praesent non. Ullamcorper elit sit eros egestas euismod amet. Nec molestie a sit sed. At neque diam turpis cursus tincidunt nisi quam sed non. Tempor tortor ultricies ultrices maecenas lectus in nunc sapien dapibus.\\n\" + \"        \\\\nVolutpat placerat et placerat felis tristique quis. Pharetra velit faucibus lobortis vitae dui. Nibh diam velit hendrerit posuere vel ut augue varius velit. Eu eget ipsum vulputate consectetur adipiscing est mollis eleifend quisque. Porttitor senectus nibh\",\n",
            imageUrl = "https://sun1-15.userapi.com/s/v1/if1/mlwE4WzcL1eAdw8Rrii5gB6MroIP_sVKZlOBXHmgtofQJs5pNhoKTcX-_u2G6b9402U3YjSZ.jpg?size=957x957&quality=96&crop=33,33,957,957&ava=1",
            size = 564
        ),
        GroupsModel(
            id = "6",
            title = "ДВАЧ",
            description = "Lorem ipsum dolor sit amet consectetur. Libero duis cum egestas amet mollis massa. Convallis sit lacus tortor interdum auctor viverra vitae. Egestas aliquam odio aenean eget facilisi ipsum vitae. Risus lectus quam urna condimentum id massa magna id mattis. Sit tempor volutpat ac eget dignissim nibh sagittis vitae duis. Vivamus quis fusce egestas vel sodales arcu praesent non. Ullamcorper elit sit eros egestas euismod amet. Nec molestie a sit sed. At neque diam turpis cursus tincidunt nisi quam sed non. Tempor tortor ultricies ultrices maecenas lectus in nunc sapien dapibus.\\n\" + \"        \\\\nVolutpat placerat et placerat felis tristique quis. Pharetra velit faucibus lobortis vitae dui. Nibh diam velit hendrerit posuere vel ut augue varius velit. Eu eget ipsum vulputate consectetur adipiscing est mollis eleifend quisque. Porttitor senectus nibh\",\n",
            imageUrl = "https://storage.googleapis.com/kaggle-datasets-images/1519009/2508255/bbb98bf384ba2d6c83fcd746d6ea0012/dataset-card.png?t=2021-08-08-11-21-44",
            size = 1678
        ),
        GroupsModel(
            id = "7",
            title = "КОД ДУРОВА",
            description = "Lorem ipsum dolor sit amet consectetur. Libero duis cum egestas amet mollis massa. Convallis sit lacus tortor interdum auctor viverra vitae. Egestas aliquam odio aenean eget facilisi ipsum vitae. Risus lectus quam urna condimentum id massa magna id mattis. Sit tempor volutpat ac eget dignissim nibh sagittis vitae duis. Vivamus quis fusce egestas vel sodales arcu praesent non. Ullamcorper elit sit eros egestas euismod amet. Nec molestie a sit sed. At neque diam turpis cursus tincidunt nisi quam sed non. Tempor tortor ultricies ultrices maecenas lectus in nunc sapien dapibus.\\n\" + \"        \\\\nVolutpat placerat et placerat felis tristique quis. Pharetra velit faucibus lobortis vitae dui. Nibh diam velit hendrerit posuere vel ut augue varius velit. Eu eget ipsum vulputate consectetur adipiscing est mollis eleifend quisque. Porttitor senectus nibh\",\n",
            imageUrl = "https://sun6-21.userapi.com/s/v1/ig2/Ni4EmGxmx_mR7ZwO9p0KfBWbv3jq1QHk-5T7ORoDEkX2q6bRW1kF8pJrxvcx7L7LI3Er6VLpB3guAlmsdyGQipim.jpg?size=2160x2160&quality=95&crop=0,0,2160,2160&ava=1",
            size = 908
        ),
        GroupsModel(
            id = "8",
            title = "ТОПОР",
            description = "Lorem ipsum dolor sit amet consectetur. Libero duis cum egestas amet mollis massa. Convallis sit lacus tortor interdum auctor viverra vitae. Egestas aliquam odio aenean eget facilisi ipsum vitae. Risus lectus quam urna condimentum id massa magna id mattis. Sit tempor volutpat ac eget dignissim nibh sagittis vitae duis. Vivamus quis fusce egestas vel sodales arcu praesent non. Ullamcorper elit sit eros egestas euismod amet. Nec molestie a sit sed. At neque diam turpis cursus tincidunt nisi quam sed non. Tempor tortor ultricies ultrices maecenas lectus in nunc sapien dapibus.\\n\" + \"        \\\\nVolutpat placerat et placerat felis tristique quis. Pharetra velit faucibus lobortis vitae dui. Nibh diam velit hendrerit posuere vel ut augue varius velit. Eu eget ipsum vulputate consectetur adipiscing est mollis eleifend quisque. Porttitor senectus nibh\",\n",
            imageUrl = "https://pngimg.com/uploads/ax/ax_PNG9100.png",
            size = 123
        ),
        GroupsModel(
            id = "9",
            title = "КБ",
            description = "Lorem ipsum dolor sit amet consectetur. Libero duis cum egestas amet mollis massa. Convallis sit lacus tortor interdum auctor viverra vitae. Egestas aliquam odio aenean eget facilisi ipsum vitae. Risus lectus quam urna condimentum id massa magna id mattis. Sit tempor volutpat ac eget dignissim nibh sagittis vitae duis. Vivamus quis fusce egestas vel sodales arcu praesent non. Ullamcorper elit sit eros egestas euismod amet. Nec molestie a sit sed. At neque diam turpis cursus tincidunt nisi quam sed non. Tempor tortor ultricies ultrices maecenas lectus in nunc sapien dapibus.\\n\" + \"        \\\\nVolutpat placerat et placerat felis tristique quis. Pharetra velit faucibus lobortis vitae dui. Nibh diam velit hendrerit posuere vel ut augue varius velit. Eu eget ipsum vulputate consectetur adipiscing est mollis eleifend quisque. Porttitor senectus nibh\",\n",
            imageUrl = "https://работа-в-магнитогорске.рф/wp-content/uploads/2023/07/263DA85F-2DF7-436D-813A-07DB9985D0D8.png",
            size = 7567
        ),
        GroupsModel(
            id = "10",
            title = "ВИДЕО УДАЛЬЦА",
            description = "Lorem ipsum dolor sit amet consectetur. Libero duis cum egestas amet mollis massa. Convallis sit lacus tortor interdum auctor viverra vitae. Egestas aliquam odio aenean eget facilisi ipsum vitae. Risus lectus quam urna condimentum id massa magna id mattis. Sit tempor volutpat ac eget dignissim nibh sagittis vitae duis. Vivamus quis fusce egestas vel sodales arcu praesent non. Ullamcorper elit sit eros egestas euismod amet. Nec molestie a sit sed. At neque diam turpis cursus tincidunt nisi quam sed non. Tempor tortor ultricies ultrices maecenas lectus in nunc sapien dapibus.\\n\" + \"        \\\\nVolutpat placerat et placerat felis tristique quis. Pharetra velit faucibus lobortis vitae dui. Nibh diam velit hendrerit posuere vel ut augue varius velit. Eu eget ipsum vulputate consectetur adipiscing est mollis eleifend quisque. Porttitor senectus nibh\",\n",
            imageUrl = "https://img.freepik.com/premium-vector/group-people-together-young-men-women_507816-688.jpg",
            size = 1
        ),
    )

    private val settingsButtonList = listOf(SettingButtonModel(
        "Тема", R.drawable.theme_icon
    ) { },
        SettingButtonModel("Уведомления", R.drawable.notification_icon) { },
        SettingButtonModel("Безопасность", R.drawable.secure_icon) { },
        SettingButtonModel("Память и ресурсы", R.drawable.data_icon) { })

    private val extendedSettingsButtonList =
        listOf(SettingButtonModel("Помощь", R.drawable.question_icon) { },
            SettingButtonModel("Пригласи друга", R.drawable.invite_icon) { })
}