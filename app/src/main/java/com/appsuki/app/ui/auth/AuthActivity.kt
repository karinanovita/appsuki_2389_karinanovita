package com.appsuki.app.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.appsuki.app.R
import com.appsuki.app.data.model.AuthUser
import com.appsuki.app.databinding.ActivityAuthBinding
import com.appsuki.app.ui.home.MainActivity

class AuthActivity : AppCompatActivity() {
    lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_auth)
    }

    fun onSuccess(user: AuthUser) {

        val intent = Intent(this, MainActivity::class.java )
        startActivity(intent)
        finish()

    }
}