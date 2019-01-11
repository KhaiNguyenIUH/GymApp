package com.example.a8x302.qllistphonggym.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.a8x302.qllistphonggym.R

class VerifyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verify)
        val toolbar = findViewById(R.id.my_toolbar) as Toolbar
        setSupportActionBar(toolbar)
        getSupportActionBar()!!.setDisplayShowTitleEnabled(false);
        val drawable = resources.getDrawable(R.drawable.ic_back_24dp)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(drawable)
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
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
}
