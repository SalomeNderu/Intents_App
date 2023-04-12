package com.example.intents_midmorning

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var btnsms:Button
    lateinit var btnemail:Button
    lateinit var btncamera:Button
    lateinit var btnshare:Button
    lateinit var btnmpesa:Button
    lateinit var btncall:Button
    lateinit var btnwebsite:Button
    lateinit var btnmap:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnsms = findViewById(R.id.sms_btn)
        btnemail = findViewById(R.id.email_btn)
        btncamera = findViewById(R.id.cam_btn)
        btnshare = findViewById(R.id.share_btn)
        btnmpesa = findViewById(R.id.mpesa_btn)
        btncall = findViewById(R.id.call_btn)
        btnwebsite = findViewById(R.id.web_btn)
        btnmap = findViewById(R.id.map_btn)

        btnsms.setOnClickListener {
            val uri: Uri = Uri.parse("smsto:0718486799")
            val intent = Intent(Intent.ACTION_SENDTO, uri)
            intent.putExtra("sms_body", "vipi wazito")
            startActivity(intent)
        }
        btnemail.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "sallienderu@gmail.com", null))
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "JOB APPLICATION")
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Dear sir, I'm applying for bla bla bla")
            startActivity(Intent.createChooser(emailIntent, "Send email..."))
        }
        btncamera.setOnClickListener {
            val takePictureintent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(takePictureintent, 1)
        }
        btnmpesa.setOnClickListener {
            val simToolKitIntent = applicationContext.packageManager.getLaunchIntentForPackage("com.android.stk")
            simToolKitIntent?.let { startActivity(it) }
        }
        btnwebsite.setOnClickListener {
            val gotoanotheractivity = Intent( this, Website_Activity::class.java)
            startActivity(gotoanotheractivity)
        }
    }
}