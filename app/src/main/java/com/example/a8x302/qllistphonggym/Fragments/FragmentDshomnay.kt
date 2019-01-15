package com.example.a8x302.qllistphonggym.Fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.a8x302.qllistphonggym.Adapter.ViechomnayAdapter
import com.example.a8x302.qllistphonggym.Model.Doanhnghiep
import com.example.a8x302.qllistphonggym.R
import java.util.ArrayList

class FragmentDshomnay : Fragment() {
    internal lateinit var view: View
    private var myrecycleview: RecyclerView? = null
    private val dn = java.util.ArrayList<Doanhnghiep>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var movie = Doanhnghiep("Thi Nguyễn GYM", "192 Trần Văn Dư, Phường 13, Quận Tân Bình", 84972639402)
        dn.add(movie)
        var movie1 = Doanhnghiep("Thi Nguyễn GYM2", "192 Trần Văn Thừa, Phường 13, Quận Tân Bình", 84972639402)
        dn.add(movie1)
        var movie2 = Doanhnghiep("Thi Nguyễn GYM1", "192 Trần Văn Dư, Phường 13, Quận Tân Bình", 84972639402)
        dn.add(movie2)
    }

    fun FragmentContact() {}
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        view = inflater.inflate(R.layout.viechomnay_fragment, container, false)
        myrecycleview = view.findViewById(R.id.viechomnay_recycleview)
        val recycleViewAdapter = ViechomnayAdapter(context!!, dn!!)
        myrecycleview!!.setLayoutManager(LinearLayoutManager(activity))
        myrecycleview!!.setAdapter(recycleViewAdapter)
        return view
    }
}