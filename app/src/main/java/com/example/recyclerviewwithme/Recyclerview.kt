package com.example.recyclerviewwithme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewwithme.databinding.ActivityRecyclerviewBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityRecyclerviewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var dataList = ArrayList<Modal>()

        for (i in 1..40){
            dataList.add(Modal(R.drawable.men,"shivam Emoji"))
            dataList.add(Modal(R.drawable.me,"Naveen Kanojiya"))
            dataList.add(Modal(R.drawable.navin,"visal"))
            dataList.add(Modal(R.drawable.man,"kumar jii"))
            dataList.add(Modal(R.drawable.girl,"shaliy"))
            dataList.add(Modal(R.drawable.men,"shivam Emoji"))
            dataList.add(Modal(R.drawable.me,"Naveen Kanojiya"))
            dataList.add(Modal(R.drawable.navin,"visal"))
            dataList.add(Modal(R.drawable.man,"kumar jii"))
            dataList.add(Modal(R.drawable.girl,"shaliy"))
        }

        var adapter = Adapter(dataList,this)
        binding.rvView.adapter = adapter
        binding.rvView.layoutManager = LinearLayoutManager(this)

    }

    fun Hindi_button(view: View) {
        binding.btnHindi.setOnClickListener {
            val implictIntent = Intent(Intent.ACTION_VIEW)
            startActivity(Intent.createChooser(implictIntent,"Implicit"))

        }
    }
    fun English_Button(view: View) {
        binding.englishBtn.setOnClickListener {

            val explicitIntent = Intent(this,MainActivity2::class.java)
            startActivity(explicitIntent)
        }
    }
}