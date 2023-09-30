package com.example.recyclerviewwithme

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewwithme.databinding.RvItemBinding
import kotlin.coroutines.coroutineContext

class Adapter(var datalist: ArrayList<Modal>, var context :Context):RecyclerView.Adapter<Adapter.MyviewHolder>(){


    inner class MyviewHolder(var binding: RvItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
        var binding = RvItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyviewHolder(binding)
    }

    override fun getItemCount(): Int {
        return datalist.size
    }

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {
        holder.binding.imageView.setImageResource(datalist.get(position).Img)
        holder.binding.textView.text = datalist.get(position).text
        holder.itemView.setOnClickListener {
          //  Toast.makeText(context,datalist.get(position).text,Toast.LENGTH_LONG).show()
       var dialog =Dialog(context)
            dialog.setContentView(R.layout.dialog)
            var imgView:ImageView = dialog.findViewById(R.id.imgViewRv)
            imgView.setImageResource(datalist.get(position).Img)
            dialog.show()
        }
    }
}