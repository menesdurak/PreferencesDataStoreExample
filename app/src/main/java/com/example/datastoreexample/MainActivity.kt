package com.example.datastoreexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ap = AppPref(this)

        val job = CoroutineScope(Dispatchers.Main).launch {
            ap.saveName("John")

            val receivedName = ap.readName()
            Log.e("Received Name",receivedName)
        }
    }
}