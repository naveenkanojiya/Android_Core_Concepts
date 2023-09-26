package com.example.recyclerviewwithme

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }

    fun OpenDialDialer(view: View) {
        val phoneNumber  = 9956794927
        val explictDilerIntent = Intent(Intent.ACTION_DIAL,Uri.parse("tel:$phoneNumber"))
        startActivity(explictDilerIntent)
    }
    fun OpenBrowser(view: View) {
        val url = "https://www.linkedin.com/in/naveen-k-5511191a1/"
        val explictBrowserIntent = Intent(Intent.ACTION_VIEW,Uri.parse(url))
        startActivity(explictBrowserIntent)

    }
    fun OpenMassage(view: View) {
        val phoneNumber = "9956794927"
        val massage = "Call for Naveen immediately"
        val explictMassageIntent = Intent(Intent.ACTION_SENDTO, Uri.fromParts("sms",phoneNumber,""))
        explictMassageIntent.putExtra("sms_body",massage)
        startActivity(explictMassageIntent)
    }
}