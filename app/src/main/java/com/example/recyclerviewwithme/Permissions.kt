package com.example.recyclerviewwithme

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.recyclerviewwithme.databinding.ActivityPermissionsBinding

class Permissions : AppCompatActivity() {

    val binding by lazy {
        ActivityPermissionsBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        if (ContextCompat.checkSelfPermission(this@Permissions, Manifest.permission.WRITE_CONTACTS)
            == PackageManager.PERMISSION_GRANTED
        ) {
            Toast.makeText(this,"Given",Toast.LENGTH_SHORT).show()

        }else{
            Toast.makeText(this,"Not Given",Toast.LENGTH_SHORT).show()
            ActivityCompat.requestPermissions(
                this@Permissions, arrayOf(Manifest.permission.WRITE_CONTACTS, Manifest.permission.ACCESS_FINE_LOCATION),
                100
            )
        }
        binding.buttonPermission.setOnClickListener {
            val intent  = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
            val uri = Uri.fromParts("package",packageName,null)
            intent.data = uri
            startActivity(intent)
        }
    }
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (grantResults[0]==PackageManager.PERMISSION_GRANTED){
            Toast.makeText(this@Permissions,"Ha bhai pta hai Tune mana kr diya",Toast.LENGTH_LONG).show()
        }else{
            ActivityCompat.requestPermissions(
                this@Permissions, arrayOf(Manifest
                    .permission
                    .WRITE_CONTACTS,
                    Manifest.permission.ACCESS_FINE_LOCATION),
                100
            )

        }
    }
}