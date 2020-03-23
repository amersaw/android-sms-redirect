package dev.sawan.smsredirect

import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val TAG = "PermissionDemo"
    private val RECIEVESMS_CODE = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnDoIt.setOnClickListener{
            Toast.makeText(this,"hi", Toast.LENGTH_LONG).show()

            val task = SendTelegramMessageTask()
            task.execute("hi")
        }


    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        setupPermissions()
    }

    private fun setupPermissions() {
        val permission = ContextCompat.checkSelfPermission(this,
            android.Manifest.permission.RECEIVE_SMS)

        if (permission != PackageManager.PERMISSION_GRANTED) {
            Log.i(TAG, "Permission to record denied")
            makeRequest()
        }
    }

    private fun makeRequest() {
        ActivityCompat.requestPermissions(this,
            arrayOf(android.Manifest.permission.RECEIVE_SMS),
            RECIEVESMS_CODE)
    }
    private fun setupPermissionsOLD() {
        val permission = ContextCompat.checkSelfPermission(this,
            android.Manifest.permission.RECEIVE_SMS)

        if (permission != PackageManager.PERMISSION_GRANTED) {
            Log.i(TAG, "Permission to RECEIVE SMS denied")
        }
        else
            Log.i(TAG, "Permission to RECEIVE SMS GRANTED")

    }
}
