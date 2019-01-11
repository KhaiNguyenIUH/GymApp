package com.example.a8x302.qllistphonggym.Activity


import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.text.method.ScrollingMovementMethod
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.a8x302.qllistphonggym.Model.User
import com.example.a8x302.qllistphonggym.R
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.FuelManager
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_login.*
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEvent
import net.yslibrary.android.keyboardvisibilityevent.Unregistrar


class LoginActivity : AppCompatActivity(), View.OnClickListener {

    var mUnregistrar: Unregistrar? = null
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val toolbar = findViewById(R.id.my_toolbar) as Toolbar
        setSupportActionBar(toolbar)
        getSupportActionBar()!!.setDisplayShowTitleEnabled(false);
        val drawable = resources.getDrawable(R.drawable.ic_back_24dp)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeAsUpIndicator(drawable)
        var btn_login = findViewById(R.id.btnLogin) as Button
        var quenmk=findViewById(R.id.quenmk) as TextView
        btn_login.setMovementMethod(ScrollingMovementMethod())
        mUnregistrar = KeyboardVisibilityEvent.registerEventListener(this) {
            if (KeyboardVisibilityEvent.isKeyboardVisible(this@LoginActivity) == true) {
                btn_login.setTranslationY(-720f)
            } else
                btn_login.setTranslationY(0f)
        }
        btnLogin.setOnClickListener(this)
        quenmk.setOnClickListener(this)
        FuelManager.instance.basePath = "https://alpha.qcoop.vn"
    }

    internal fun unregister() {
        mUnregistrar?.unregister()
    }

    override fun onDestroy() {
        super.onDestroy()
        mUnregistrar?.unregister()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true

    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btnLogin -> {
                if(validateLogin(edt_sdt.text.toString(), edt_pass.text.toString())){
                httpPost()
                }
            }
            R.id.btnLogin -> {
                unregister()
            }
            R.id.quenmk->{
                val intent = Intent(this@LoginActivity, VerifyActivity::class.java)
                startActivity(intent)
            }
        }
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

    fun validateLogin(email: String?, password: String?): Boolean {
        if (email == null || email.trim { it <= ' ' }.length == 0) {
            Toast.makeText(this, "Email is required", Toast.LENGTH_SHORT).show()
            return false
        }
        if (password == null || password.trim { it <= ' ' }.length == 0) {
            Toast.makeText(this, "Password is required", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }
    //Đăng nhập
    private fun httpPost() {
        //Lấy text của edittext
        val email = edt_sdt.getText().toString()
        val password = edt_pass.getText().toString()
        //Gán text cho class user
        val user = User(email = email, password = password)
        //
        val personJson = Gson().toJson(user)
        Fuel.post("/user/signin").jsonBody(personJson).responseString { request, response, result ->
            result.fold(success = {
                    val intent = Intent(this@LoginActivity, DanhsachActivity::class.java)
                    startActivity(intent)
                }, failure = {
                    println(String(it.errorData))
                    Toast.makeText(this, String(it.errorData), Toast.LENGTH_SHORT).show()
                })
            }
    }
}
