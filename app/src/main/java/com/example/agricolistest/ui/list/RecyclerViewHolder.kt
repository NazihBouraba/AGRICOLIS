package com.example.agricolistest


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class RecyclerViewHolder (private val context: Context?, private var list: List<String>) :
    RecyclerView.Adapter<RecyclerViewHolder.MyViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = inflater.inflate(R.layout.item_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val current = list[position]
        holder.setData(current, position)
        holder.setListeners(position)
    }

    override fun getItemCount(): Int = list.size

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        private var pos: Int = 0
        lateinit var current: String

        fun setData(current: String, position: Int) {
            var txt = itemView.findViewById<TextView>(R.id.text_view)
            txt.text= current
            this.pos = position
            this.current = current
        }

        fun setListeners(position : Int) {

            itemView.setOnClickListener {
              var i = Intent(context,EditActivity::class.java)
                i.putExtra("index",position)
                context?.startActivity(i)
            }
        }
    }
}