package com.example.intents_midmorning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class Website_Activity : AppCompatActivity() {
    lateinit var myWeb:WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_website)
        myWeb = findViewById(R.id.Web_mm)
        val webSettings = myWeb.settings
        webSettings.javaScriptEnabled = true
        myWeb.loadUrl("https://google.com")

    }
}