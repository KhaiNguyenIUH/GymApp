package com.example.a8x302.qllistphonggym.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.a8x302.qllistphonggym.Model.Doanhnghiep
import com.example.a8x302.qllistphonggym.R

class dsAdapter (private val mContext: Context, private val dslist: List<Doanhnghiep>) :
    RecyclerView.Adapter<dsAdapter.MyViewHolder>() {
    private val mLayoutInflater: LayoutInflater
    private var mListener: AdapterView.OnItemClickListener? = null

    init {
        mLayoutInflater = LayoutInflater.from(mContext)
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)

        fun onDeleteClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        mListener = listener as AdapterView.OnItemClickListener
    }
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var name: TextView
        var mCall: CheckBox

        init {
            name = itemView.findViewById<View>(R.id.txtCongviec) as TextView
            mCall = itemView.findViewById(R.id.checkBox)
            itemView.setOnClickListener { Toast.makeText(mContext, name.text, Toast.LENGTH_SHORT).show() }
            mCall.setOnClickListener { Toast.makeText(mContext, "Calling 113", Toast.LENGTH_SHORT).show() }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val item = mLayoutInflater.inflate(R.layout.row_layout_ds, parent, false)

        return MyViewHolder(item)
    }

    override fun onBindViewHolder(holder: dsAdapter.MyViewHolder, position: Int) {
        val dn = dslist[position]
        holder.name.text = dn.ten
    }

    override fun getItemCount(): Int {
        return dslist.size
    }
}
