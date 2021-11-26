package com.rikkei.tranning.activity.activity

import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.rikkei.tranning.activity.R

class SecondActivity : AppCompatActivity() {
    private var mediaManager: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_act_main)
        initViews()
    }

    private fun initViews() {
        mediaManager = MediaPlayer.create(this, R.raw.song_2)
        mediaManager?.start()
        val back = findViewById<TextView>(R.id.tv_back)
        back.setOnClickListener {
            mediaManager?.pause()
            onBackPressed()
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
        Log.i(TAG, "onStop: ")
        mediaManager?.reset()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy: ")
    }

    private companion object {
        val TAG: String? = SecondActivity::class.java.name
    }
}