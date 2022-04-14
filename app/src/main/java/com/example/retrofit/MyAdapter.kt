package com.example.retrofit

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.row_item.view.*

class MyAdapter(val context: Context, val userlist: List<MyData.MyDataItem>):
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        var name :TextView
        var subject:TextView
        var imageView:ImageView
        var qualification:TextView
        init {
            name =itemView.name
            subject =itemView.subject
            imageView =itemView.imageview
            qualification =itemView.qualification
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       var itemView =LayoutInflater.from(context).inflate(R.layout.row_item,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text= userlist[position].name

        userlist[position].subjects.let {
            holder.subject.text =it[0].toString()
        }
        userlist[position].qualification.let {
            holder.qualification.text =it[0].toString()
        }
        Glide.with(context)
            .load(userlist[position].profileImage)
            .into(holder.imageView)
    }

    override fun getItemCount(): Int {
       return userlist.size
    }
}