package com.captaindeer.rookmotionchallenge.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.captaindeer.rookmotionchallenge.databinding.ActivityLoginBinding
import com.captaindeer.rookmotionchallenge.ui.main.MainActivity
import com.captaindeer.rookmotionchallenge.ui.forgotpassword.ForgotPasswordDialog
import com.captaindeer.rookmotionchallenge.ui.registry.RegistryActivity
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity(), LoginInterface.View {

    private lateinit var binding: ActivityLoginBinding
    private var auth: FirebaseAuth? = null
    private var presenter: LoginPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = LoginPresenter(this)
        auth = FirebaseAuth.getInstance()

        binding.btnLog.setOnClickListener {
            presenter?.goToLogin(
                binding.etEmail.text.toString(),
                binding.etPassword.text.toString()
            )
        }
        binding.tvRegistry.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    RegistryActivity::class.java
                )
            )
        }
        binding.forgot.setOnClickListener {
            ForgotPasswordDialog().show(supportFragmentManager, "customDialog")
        }
    }

    override fun onStart() {
        super.onStart()
        if (auth?.currentUser != null) {
            onSuccess()
        }
    }

    override fun onSuccess() {
        startActivity(Intent(this, MainActivity::class.java))
        finishAffinity()
    }

    override fun onError(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

}