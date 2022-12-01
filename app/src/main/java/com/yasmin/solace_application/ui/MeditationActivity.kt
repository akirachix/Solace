package com.yasmin.solace_application.ui

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SeekBar
import android.widget.TextView
import com.yasmin.solace_application.R
import com.yasmin.solace_application.databinding.ActivityMeditationBinding



class MeditationActivity : AppCompatActivity() {
    lateinit var binding: ActivityMeditationBinding
    lateinit var textView: TextView
    private var mp: MediaPlayer? = null
    private var currentSong: MutableList<Int> = mutableListOf(R.raw.meditation)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMeditationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        controlSound(currentSong[0])

        binding.ivBackword.setOnClickListener {

            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }



    }

    private fun controlSound(id: Int) {
        binding.fabPlay.setOnClickListener{
            if (mp == null){
                mp = MediaPlayer.create(this, id)
                Log.d("MeditationActivity", "ID: ${mp!!.audioSessionId}")

                initialiseSeekbar()
            }
            mp?.start()
            Log.d("Meditation", "Duration: ${mp!!.duration/1000} seconds")
        }

        binding.fabPause.setOnClickListener{
            if (mp !== null) mp?.pause()
            Log.d("MeditationActivity", "Paused at: ${mp!!.currentPosition/1000} seconds ")
        }
        binding.fabStop.setOnClickListener{
            if (mp !== null){
                mp?.stop()
                mp?.reset()
                mp?.release()
                mp = null
            }
        }
        binding.seekbar.setOnSeekBarChangeListener (object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) mp?.seekTo(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })
    }

    private fun initialiseSeekbar() {
        binding.seekbar.max = mp!!.duration
    }
}