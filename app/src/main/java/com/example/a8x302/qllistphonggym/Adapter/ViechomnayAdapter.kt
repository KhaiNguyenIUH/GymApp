package com.example.a8x302.qllistphonggym.Adapter

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.a8x302.qllistphonggym.Activity.LoginActivity
import com.example.a8x302.qllistphonggym.Activity.VieccanthuchienActivity
import com.example.a8x302.qllistphonggym.Model.Doanhnghiep
import com.example.a8x302.qllistphonggym.R

class ViechomnayAdapter(private val mContext: Context, private val movieList: List<Doanhnghiep>) :
    RecyclerView.Adapter<ViechomnayAdapter.MyViewHolder>() {
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
        var diachi: TextView
        var sdt: TextView
        var mCall: Button

        init {
            name = itemView.findViewById<View>(R.id.edtname) as TextView
            diachi = itemView.findViewById<View>(R.id.edtdiachi) as TextView
            sdt = itemView.findViewById<View>(R.id.edtsdt) as TextView
            mCall = itemView.findViewById(R.id.btnCall)
            itemView.setOnClickListener {val intent = Intent(mContext, VieccanthuchienActivity::class.java)
                mContext.startActivity(intent)}

            itemView.setOnLongClickListener {
                Toast.makeText(mContext, diachi.text, Toast.LENGTH_SHORT).show()
                true
            }
            mCall.setOnClickListener { Toast.makeText(mContext, "Calling 113", Toast.LENGTH_SHORT).show() }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val item = mLayoutInflater.inflate(R.layout.row_layout_list, parent, false)

        return MyViewHolder(item)
    }

    override fun onBindViewHolder(holder: ViechomnayAdapter.MyViewHolder, position: Int) {
        val dn = movieList[position]
        holder.name.text = dn.ten
        holder.diachi.text = dn.diachi
        holder.sdt.text = dn.sodienthoai.toString()

    }

    override fun getItemCount(): Int {
        return movieList.size
    }

}
