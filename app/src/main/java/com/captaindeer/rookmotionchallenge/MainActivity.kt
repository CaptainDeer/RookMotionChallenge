package com.captaindeer.rookmotionchallenge

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.captaindeer.rookmotionchallenge.databinding.ActivityMainBinding
import com.captaindeer.rookmotionchallenge.ui.login.LoginActivity
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var auth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.btnLogout.setOnClickListener {
            auth?.signOut()
            startActivity(Intent(this, LoginActivity::class.java))
            finishAffinity()
        }

    }
}