package com.github.nikokann.jsonpost

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    fun post(): String?{
        val url = "url"
        val client: OkHttpClient = OkHttpClient.Builder().build()

        // create json
        val json = JSONObject()
        json.put("name", "mituba")
        json.put("hobby", "programming")

        // post
        val postBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json.toString())
        val request: Request = Request.Builder().url(url).post(postBody).build()
        val response = client.newCall(request).execute()

        // getResult
        val result: String? = response.body()?.string()
        response.close()
        return result
    }
}