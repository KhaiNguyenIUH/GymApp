package com.example.a8x302.qllistphonggym.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.example.a8x302.qllistphonggym.Adapter.ViechomnayAdapter
import com.example.a8x302.qllistphonggym.Adapter.dsAdapter
import com.example.a8x302.qllistphonggym.Model.Doanhnghiep
import com.example.a8x302.qllistphonggym.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_vieccanthuchien.*

class VieccanthuchienActivity : AppCompatActivity(),View.OnClickListener {

    private val mListds = java.util.ArrayList<Doanhnghiep>()
    private var recyclerView: RecyclerView? = null
    private var mAdapter: dsAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vieccanthuchien)
        val toolbar = findViewById(R.id.my_toolbar) as Toolbar
        setSupportActionBar(toolbar)
        getSupportActionBar()!!.setDisplayShowTitleEnabled(false);
        val drawable = resources.getDrawable(R.drawable.ic_back_24dp)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(drawable)
        btnCall.setOnClickListener(this)
        btnImage.setOnClickListener(this)
        prepareMovieData1()
        recyclerView = findViewById<View>(R.id.recycler_view2) as RecyclerView
        mAdapter = dsAdapter(this, mListds)
        val mLayoutManager = LinearLayoutManager(applicationContext)
        recyclerView!!.layoutManager = mLayoutManager
        recyclerView!!.itemAnimator = DefaultItemAnimator()
        recyclerView!!.adapter = mAdapter
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
            else -> {
            }
        }
        return super.onOptionsItemSelected(item)
    }
    override fun onClick(view: View) {
        when (view.id) {
            R.id.btnCall -> {
                Toast.makeText(this, "Calling 131313", Toast.LENGTH_SHORT).show()
            }
            R.id.btnImage -> {
                Toast.makeText(this, "Image nè", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun prepareMovieData1() {
        var movie = Doanhnghiep("Thi Nguyễn GYM2", "192 Trần Văn Dư, Phường 13, Quận Tân Bình", 84972639402)
        mListds.add(movie)

        movie = Doanhnghiep("Inside Out2", "Animation, Kids & Family", 84972639402)
        mListds.add(movie)

        movie = Doanhnghiep("Star Wars2: Episode VII - The Force Awakens", "Action", 84972639402)
        mListds.add(movie)

        movie = Doanhnghiep("Shaun the Sheep2", "Animation", 84972639402)
        mListds.add(movie)

    }
}
