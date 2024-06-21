//package com.example.applimobilefilm.Test
//
//import android.os.Bundle
//import android.widget.Button
//import androidx.appcompat.app.AppCompatActivity
//import com.example.applimobilefilm.R
//import okhttp3.OkHttpClient
//import okhttp3.Request
//import java.io.IOException
//import kotlin.concurrent.thread
//
//class MainActivity : AppCompatActivity() {
//
//    private val client = OkHttpClient()
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        val buttonRequest = findViewById<Button>(R.id.button_request)
//        buttonRequest.setOnClickListener {
//            thread {
//                try {
//                    run()
//                } catch (e: IOException) {
//                    e.printStackTrace()
//                }
//            }
//        }
//    }
//
//    private fun run() {
//        val request = Request.Builder()
//            .url("https://api.ipstack.com/134.201.250.155?access_key=YOUR_ACCESS_KEY")
//            .build()
//
//        client.newCall(request).execute().use { response ->
//            if (!response.isSuccessful) throw IOException("Unexpected code $response")
//
//            // Imprimer les headers
//            for ((name, value) in response.headers) {
//                println("$name: $value")
//            }
//
//            // Imprimer le corps de la réponse
//            println(response.body!!.string())
//        }
//    }
//}
