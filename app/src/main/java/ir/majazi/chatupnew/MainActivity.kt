package ir.majazi.chatupnew

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ir.majazi.chatupnew.data.model.data.CompletionRequest
import ir.majazi.chatupnew.data.model.data.Message
import ir.majazi.chatupnew.data.util.RetrofitInstance
import ir.majazi.chatupnew.ui.theme.ChatUpNewTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.math.log

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val messages = listOf(
                Message("system", "You are a helpful assistant that can access external functions. The responses from these function calls will be appended to this dialogue. Please provide responses based on the information from these function calls."),
                Message("user", "language android developer")
            )

            val completionRequest = CompletionRequest(
                model = "gpt-4o",
                messages = messages
            )

            val scope = rememberCoroutineScope()
            LaunchedEffect(key1 = true) {
                scope.launch(Dispatchers.IO) {
                    val response = try {
                        RetrofitInstance.api.chat(completionRequest)
                    }catch (e:Exception){
                        Log.i("TAG", "onCreate: "+e.toString())
                        return@launch
                    }catch (e:Exception){
                        Log.i("TAG", "onCreate: "+e.toString())
                        return@launch
                    }
                    if (response.isSuccessful && response.body()!=null){
                        withContext(Dispatchers.Main){
                            val aiResponse = response.body()?.choices?.get(0)?.message?.content
                            Log.i("User:" , messages[1].content)
                            Log.i("User:" ,"$aiResponse")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MyUi(){

}

