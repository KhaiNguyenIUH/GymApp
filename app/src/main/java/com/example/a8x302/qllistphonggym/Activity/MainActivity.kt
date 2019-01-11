package com.example.a8x302.qllistphonggym.Activity

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import com.example.a8x302.qllistphonggym.R


class MainActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_Loginmain.setOnClickListener(this)
    }
    override fun onClick(view: View) {
        when (view.id) {
            R.id.btn_Loginmain -> {
                val intent = Intent(this@MainActivity, LoginActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
