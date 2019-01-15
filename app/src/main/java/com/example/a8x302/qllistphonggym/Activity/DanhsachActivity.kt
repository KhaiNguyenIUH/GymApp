package com.example.a8x302.qllistphonggym.Activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.CompoundButton
import android.widget.Switch
import com.example.a8x302.qllistphonggym.Adapter.ViecngaymaiAdapter
import com.example.a8x302.qllistphonggym.Model.Doanhnghiep
import com.example.a8x302.qllistphonggym.R
import android.widget.Toast
import com.example.a8x302.qllistphonggym.Fragments.FragmentDshomnay
import com.example.a8x302.qllistphonggym.Fragments.MapFragment


class DanhsachActivity : AppCompatActivity(),CompoundButton.OnCheckedChangeListener{
    private val mListMovie1 = java.util.ArrayList<Doanhnghiep>()
    internal lateinit var sw: Switch
    private var recyclerView1: RecyclerView? = null
    private var mAdapter1: ViecngaymaiAdapter? = null
    var doubleBackToExitPressedOnce : Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_danhsach)
        addFragment(FragmentDshomnay(), false, "a")
        sw = findViewById(R.id.sw_map)
        sw.setOnCheckedChangeListener(this)
        prepareMovieData1()
        recyclerView1 = findViewById<View>(R.id.recycler_view1) as RecyclerView
        mAdapter1 = ViecngaymaiAdapter(this, mListMovie1)
        val mLayoutManager1 = LinearLayoutManager(applicationContext)
        recyclerView1!!.layoutManager = mLayoutManager1 as RecyclerView.LayoutManager?
        recyclerView1!!.itemAnimator = DefaultItemAnimator()
        recyclerView1!!.adapter = mAdapter1
        recyclerView1!!.setNestedScrollingEnabled(false)
    }
    //xử lí sự kiện switch
    override fun onCheckedChanged(compoudButton: CompoundButton, b: Boolean) {
        if (sw.isChecked) {
            addFragment(MapFragment(), false, "a")
        } else {
            addFragment(FragmentDshomnay(), false, "a")
        }
    }
    //add fragment vào vị trí chỉ định
    fun addFragment(fragment: Fragment, addToBackStack: Boolean, tag: String) {
        val manager = supportFragmentManager
        val ft = manager.beginTransaction()

        if (addToBackStack) {
            ft.addToBackStack(tag)
        }
        ft.replace(R.id.dsmap, fragment, tag)
        ft.commitAllowingStateLoss()
    }
    //ghi đè phương thức nút back
    override fun onBackPressed() {
        //thoát khỏi màn hình nếu doubleBackToExitPressedOnce = true
        if (doubleBackToExitPressedOnce) {
            val intent = Intent(Intent.ACTION_MAIN)
            intent.addCategory(Intent.CATEGORY_HOME)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            return
        }
        // set doubleBackToExitPressedOnce = true khi ấn 1 nút back 1 lần
        this.doubleBackToExitPressedOnce = true
        Toast.makeText(this, "ấn lần nữa để thoát", Toast.LENGTH_SHORT).show()
        Handler().postDelayed({ doubleBackToExitPressedOnce = false }, 2000)
    }
    // set dữ liệu cho adapter ds việc trong tuần
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
