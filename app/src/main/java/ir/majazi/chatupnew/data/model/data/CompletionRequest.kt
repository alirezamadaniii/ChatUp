package ir.majazi.chatupnew.data.model.data

data class CompletionRequest(
    val model: String,
    val messages: List<Message>
)