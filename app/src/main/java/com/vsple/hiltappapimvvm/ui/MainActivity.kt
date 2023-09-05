package com.vsple.hiltappapimvvm.ui

import android.R
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.telephony.SmsManager
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.vsple.hiltapp.network.Resources
import com.vsple.hiltappapimvvm.databinding.ActivityMainBinding
import com.vsple.hiltappapimvvm.viewmodels.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding :ActivityMainBinding
    private val REQUEST_SMS_PERMISSION: Int = 300
    private val viewModel: HomeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // message sending code
        binding.btSend.setOnClickListener{
            if (checkPermissions())
            {
                val phoneNumber = "9907079953" // Replace with the recipient's phone number

                val message = "Hello, this is a test message."

                try {
                    val smsManager: SmsManager = SmsManager.getDefault()
                    smsManager.sendTextMessage(phoneNumber, null, message, null, null)
                    Toast.makeText(this, "SMS sent successfully", Toast.LENGTH_SHORT).show()
                } catch (e: Exception) {
                    Toast.makeText(this, "SMS sending failed", Toast.LENGTH_SHORT).show()
                    e.printStackTrace()
                }
            }
            else{
                requestPermissions()
            }

        }

        // calling api
        viewModel.refreshData()
        viewModel?.posts?.observe(this) { resource ->
            when (resource) {
                is Resources.Loading -> {
                    // Show loading indicator
                }

                is Resources.Success -> {
                    val posts = resource.data
                    // tvtitle.text = posts.data.homepageChatiesCollection.get(0).title.toString()

                    Log.d("DataChatty", "onCreate: "+posts)
                    // Update UI with posts
                }

                is Resources.Error -> {
                    val errorMessage = resource.errorMessage
                    Toast.makeText(this,errorMessage, Toast.LENGTH_SHORT).show()
                    // Display error to user
                }

                else -> {

                }
            }
        }

    }


    private fun checkPermissions(): Boolean {
        val androidVersion = Build.VERSION.SDK_INT

        val permissions = when {
            androidVersion < 23 -> arrayOf(
                android.Manifest.permission.SEND_SMS,
            )

            else -> arrayOf(
                android.Manifest.permission.SEND_SMS,
            )
        }

        return permissions.all {
            ContextCompat.checkSelfPermission(
                this,
                it
            ) == PackageManager.PERMISSION_GRANTED
        }
    }


    private fun requestPermissions() {
        val androidVersion = Build.VERSION.SDK_INT
        if (androidVersion < 13) {
            ActivityCompat.requestPermissions(
                this, arrayOf(
                    android.Manifest.permission.SEND_SMS,
                ), REQUEST_SMS_PERMISSION
            )
        } else {
            ActivityCompat.requestPermissions(
                this, arrayOf(
                    android.Manifest.permission.SEND_SMS,
                    ), REQUEST_SMS_PERMISSION
            )

        }
    }


}
