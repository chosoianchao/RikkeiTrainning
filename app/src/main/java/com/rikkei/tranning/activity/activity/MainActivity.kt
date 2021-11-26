package com.rikkei.tranning.activity.activity

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.rikkei.tranning.activity.R

class MainActivity : AppCompatActivity() {

    private var mediaManager: MediaPlayer? = null
    private val TAG: String? = MainActivity::class.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState != null) {
            mediaManager?.reset()
        }
        initViews()
        Log.i(TAG, "onCreate: " + savedInstanceState + mediaManager)
    }

    private fun initViews() {
        mediaManager = MediaPlayer.create(this, R.raw.song_1)
        mediaManager?.start()
        val next = findViewById<TextView>(R.id.tv_next)
        next.setOnClickListener {
            mediaManager?.pause()
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        mediaManager?.pause()
        Log.i(TAG, "onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.i(TAG, "onDestroy: ")
    }
}