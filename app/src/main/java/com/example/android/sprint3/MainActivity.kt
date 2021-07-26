package com.example.android.sprint3

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : Activity() {

    enum class LoginSuccess {
        Login,
        Password,
        Success
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtLogin = findViewById<TextView>(R.id.idLoginText)
        val txtPassword = findViewById<TextView>(R.id.idPasswordText)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {

            when (checkLogin(txtLogin.text.toString(), txtPassword.text.toString())) {
                LoginSuccess.Login -> {
                    Toast.makeText(applicationContext, getString(R.string.errMessageLogin), Toast.LENGTH_SHORT).show()
                    txtLogin.requestFocus()
                }
                LoginSuccess.Password -> {
                    Toast.makeText(applicationContext, getString(R.string.errMessagePassword), Toast.LENGTH_SHORT).show()
                    txtPassword.requestFocus()
                }
                else -> startActivity(Intent(this@MainActivity, MainClassList::class.java))
            }
        }

    }

    private fun checkLogin(txtLogin: String, txtPassword: String): LoginSuccess {
        val holdLogin = "Colin"
        val holdPass = "password"

        if (holdLogin != txtLogin) {
            return LoginSuccess.Login
        }

        return if (holdPass != txtPassword) {
            LoginSuccess.Password
        } else LoginSuccess.Success

    }
}