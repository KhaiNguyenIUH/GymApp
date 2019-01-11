package com.example.a8x302.qllistphonggym.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.a8x302.qllistphonggym.Model.Doanhnghiep
import com.example.a8x302.qllistphonggym.R


class ViecngaymaiAdapter(private val mContext: Context, private val movieList: List<Doanhnghiep>) :
    RecyclerView.Adapter<ViecngaymaiAdapter.MyViewHolder1>() {
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder1 {
        val item = mLayoutInflater.inflate(R.layout.row_layout_list_week, p0, false)

        return MyViewHolder1(item)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(p0: MyViewHolder1, p1: Int) {
        val dn = movieList[p1]
        p0.name.text = dn.ten
        p0.diachi.text = dn.diachi
        p0.sdt.text = dn.sodienthoai.toString()
    }

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

    inner class MyViewHolder1(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var name: TextView
        var diachi: TextView
        var sdt: TextView
        var mCall: Button

        init {
            name = itemView.findViewById<View>(R.id.edtname) as TextView
            diachi = itemView.findViewById<View>(R.id.edtdiachi) as TextView
            sdt = itemView.findViewById<View>(R.id.edtsdt) as TextView
            mCall = itemView.findViewById(R.id.btnCall)
            itemView.setOnClickListener { Toast.makeText(mContext, name.text, Toast.LENGTH_SHORT).show() }

            itemView.setOnLongClickListener {
                Toast.makeText(mContext, "Long item clicked " + diachi.text, Toast.LENGTH_SHORT).show()
                true
            }
            mCall.setOnClickListener { Toast.makeText(mContext, "Calling 113", Toast.LENGTH_SHORT).show() }
        }
    }




}
