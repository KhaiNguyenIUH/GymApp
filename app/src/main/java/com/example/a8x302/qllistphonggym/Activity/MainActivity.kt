package com.example.a8x302.qllistphonggym.Activity

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.os.Handler
import android.widget.Toast
import com.example.a8x302.qllistphonggym.R
import com.example.a8x302.qllistphonggym.Utils.PreferenceUtils


class MainActivity : AppCompatActivity(), View.OnClickListener {

    var doubleBackToExitPressedOnce: Boolean =false
    val utils = PreferenceUtils()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (utils.getEmail(this) != null) {
            val intent = Intent(this@MainActivity, DanhsachActivity::class.java)
            startActivity(intent)
            finish()
        } else {

        }
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
    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            val intent = Intent(Intent.ACTION_MAIN)
            intent.addCategory(Intent.CATEGORY_HOME)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            return
        }
        this.doubleBackToExitPressedOnce = true
        Toast.makeText(this, "Ấn lần nữa để thoát", Toast.LENGTH_SHORT).show()
        Handler().postDelayed({ doubleBackToExitPressedOnce = false }, 2000)
    }
}
