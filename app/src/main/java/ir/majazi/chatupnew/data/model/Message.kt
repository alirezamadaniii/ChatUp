package ir.majazi.chatupnew.data.model


import com.squareup.moshi.Json

data class Message(
    @Json(name = "content")
    val content: String?,
    @Json(name = "refusal")
    val refusal: Any?,
    @Json(name = "role")
    val role: String?
)