package com.example.a8x302.qllistphonggym.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.*
import com.example.a8x302.qllistphonggym.Adapter.ViechomnayAdapter
import com.example.a8x302.qllistphonggym.Adapter.ViecngaymaiAdapter
import com.example.a8x302.qllistphonggym.Model.Doanhnghiep
import com.example.a8x302.qllistphonggym.R
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.row_layout_list.*
import android.widget.AdapterView.OnItemClickListener




class DanhsachActivity : AppCompatActivity(){
    private val mListMovie = java.util.ArrayList<Doanhnghiep>()
    private var recyclerView: RecyclerView? = null
    private var mAdapter: ViechomnayAdapter? = null
    private val mListMovie1 = java.util.ArrayList<Doanhnghiep>()
    private var recyclerView1: RecyclerView? = null
    private var mAdapter1: ViecngaymaiAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_danhsach)
        prepareMovieData()
        prepareMovieData1()
        recyclerView = findViewById<View>(R.id.recycler_view) as RecyclerView
        mAdapter = ViechomnayAdapter(this, mListMovie)
        val mLayoutManager = LinearLayoutManager(applicationContext)
        recyclerView!!.layoutManager = mLayoutManager
        recyclerView!!.itemAnimator = DefaultItemAnimator()
        recyclerView!!.adapter = mAdapter
        recyclerView1 = findViewById<View>(R.id.recycler_view1) as RecyclerView
        mAdapter1 = ViecngaymaiAdapter(this, mListMovie1)
        val mLayoutManager1 = LinearLayoutManager(applicationContext)
        recyclerView1!!.layoutManager = mLayoutManager1
        recyclerView1!!.itemAnimator = DefaultItemAnimator()
        recyclerView1!!.adapter = mAdapter1
    }

    private fun prepareMovieData() {
        var movie = Doanhnghiep("Thi Nguyễn GYM", "192 Trần Văn Dư, Phường 13, Quận Tân Bình", 84972639402)
        mListMovie.add(movie)

        movie = Doanhnghiep("Inside Out", "Animation, Kids & Family", 84972639402)
        mListMovie.add(movie)

        movie = Doanhnghiep("Star Wars: Episode VII - The Force Awakens", "Action", 84972639402)
        mListMovie.add(movie)


    }
    private fun prepareMovieData1() {
        var movie = Doanhnghiep("Thi Nguyễn GYM2", "192 Trần Văn Dư, Phường 13, Quận Tân Bình", 84972639402)
        mListMovie1.add(movie)

        movie = Doanhnghiep("Inside Out2", "Animation, Kids & Family", 84972639402)
        mListMovie1.add(movie)

        movie = Doanhnghiep("Star Wars2: Episode VII - The Force Awakens", "Action", 84972639402)
        mListMovie1.add(movie)

        movie = Doanhnghiep("Shaun the Sheep2", "Animation", 84972639402)
        mListMovie1.add(movie)

    }

}
