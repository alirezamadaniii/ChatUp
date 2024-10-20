package ir.majazi.chatupnew.data.model


import com.squareup.moshi.Json

data class Chat(
    @Json(name = "choices")
    val choices: List<Choice?>?,
    @Json(name = "created")
    val created: Int?,
    @Json(name = "id")
    val id: String?,
    @Json(name = "model")
    val model: String?,
    @Json(name = "object")
    val objectX: String?,
    @Json(name = "usage")
    val usage: Usage?
)