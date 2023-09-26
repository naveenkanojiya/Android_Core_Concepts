package com.example.recyclerviewwithme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import android.widget.Toast
import com.example.recyclerviewwithme.databinding.ActivityMediaPlayerBinding
import kotlinx.coroutines.Dispatchers

class MediaPlayer : AppCompatActivity() {

    val binding by lazy {
        ActivityMediaPlayerBinding.inflate(layoutInflater)
    }
    lateinit var mediaController: MediaController
    var longList = arrayListOf<String>()
    var indexer = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        longList.add("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4")
        longList.add("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4")
        longList.add("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4")
        longList.add("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4")
        longList.add("android.resource://"+ packageName + "/" +R.raw.mymuscle)

        mediaController = MediaController(this@MediaPlayer)
        videoView(indexer)


    }

    override fun onBackPressed() {
        onBackPressedDispatcher.onBackPressed()
        binding.videoView.stopPlayback()
    }

    fun videoView(index: Int) {
        binding.videoView.stopPlayback()
        mediaController.setAnchorView(binding.mainLayout)
        mediaController.setPrevNextListeners({
        }, {
            if (indexer<=0){
                indexer=longList.size-1
             //   Toast.makeText(this@MediaPlayer,"Out of List",Toast.LENGTH_SHORT)
            }
            else{
                --indexer
                videoView(indexer)
            }



        })
        binding.videoView.setVideoPath(longList.get(index))
        binding.videoView.setOnPreparedListener {
            binding.videoView.setMediaController(mediaController)
            binding.videoView.start()
        }
        binding.videoView.setOnCompletionListener {
            it.start()
            if(indexer>=longList.size-1){
                indexer = 0
                //    Toast.makeText(this@MediaPlayer,"Out of List",Toast.LENGTH_SHORT)

            }else{
                ++indexer
                videoView(indexer)
            }
        }

    }
}


