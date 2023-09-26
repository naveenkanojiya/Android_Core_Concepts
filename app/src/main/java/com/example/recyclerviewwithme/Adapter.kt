package com.example.recyclerviewwithme

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewwithme.databinding.RvItemBinding

class Adapter(var datalist: ArrayList<Modal>):RecyclerView.Adapter<Adapter.MyviewHolder>(){


    inner class MyviewHolder(var binding: RvItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
        var binding = RvItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyviewHolder(binding)

//        var binding = RvItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
//        return MyviewHolder(binding)
    }

    override fun getItemCount(): Int {
        return datalist.size
    }

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {
        holder.binding.imageView.setImageResource(datalist.get(position).Img)
        holder.binding.textView.text = datalist.get(position).text
    }
}