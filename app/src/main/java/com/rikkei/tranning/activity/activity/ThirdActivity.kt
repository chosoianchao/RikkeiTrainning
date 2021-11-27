package com.rikkei.tranning.activity.activity

import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.rikkei.tranning.activity.R

class ThirdActivity : AppCompatActivity() {
    private val TAG: String? = ThirdActivity::class.java.name
    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.third_act)
        mediaPlayer = MediaPlayer.create(this, R.raw.song_2)
        mediaPlayer?.isLooping
        mediaPlayer?.start()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        mediaPlayer?.currentPosition?.let { outState.putInt("position", it) }
        mediaPlayer?.pause()
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        val position = savedInstanceState.getInt("position")
        mediaPlayer?.seekTo(position)
        super.onRestoreInstanceState(savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy: ")
        mediaPlayer?.stop()
    }
}