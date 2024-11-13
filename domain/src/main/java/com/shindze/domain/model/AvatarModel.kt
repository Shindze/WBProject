package com.shindze.domain.model

data class AvatarModel(val img: String) {
    companion object {
        val defaultValue = AvatarModel(
            img = "https://s3-alpha-sig.figma.com/img/dff3/9826/1c3f407d0c7ff3bc9e52078ef2bbe372?Expires=1721606400&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=nuS4k0rvJoo5JJLmf2RGmcdS0fCwyZDMqSSH6tWkaRLDPbWOXhEOQPoHe5SutAgoiSyMqOd8uaJpGN0BIeiyF-VaQyfaXT9aKpQbmTYduYqxzU79PzO9pdQiG4PD~8agXyCUtq42WWjNlbuWYRfGpjAuC89E3830LMI9kqnBX9oGxKWknGXMsNO2tVph9wn1m7sB4ElWEQ5GqCjwxHXMCcVGtd8r-LYYTG71KETyjkxI2kMBj1T1Mh1oxGIFE9nHtxc3NKPQlGdxINDQy0DaL9fzkDavjE7NGySpJd2-IdDLPTKTw9tfvZ8QSOhj3SQfKn55EXVqvE3LCg7c4XkLXA__"
        )
    }
}