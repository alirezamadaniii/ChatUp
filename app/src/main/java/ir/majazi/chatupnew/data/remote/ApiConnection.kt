package ir.majazi.chatupnew.data.remote

import ir.majazi.chatupnew.data.model.Chat
import ir.majazi.chatupnew.data.model.data.CompletionRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiConnection {

    @POST("completions")
    @Headers("Authorization: Bearer de03b5ba42fb4be78bd795df9f001c00")
    suspend fun chat(@Body request: CompletionRequest): Response<Chat>
}