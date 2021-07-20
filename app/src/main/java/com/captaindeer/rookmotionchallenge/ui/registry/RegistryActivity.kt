package com.captaindeer.rookmotionchallenge.ui.registry

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.captaindeer.rookmotionchallenge.databinding.ActivityRegistryBinding
import com.captaindeer.rookmotionchallenge.ui.login.LoginActivity

class RegistryActivity : AppCompatActivity(), RegistryInterface.View {

    private lateinit var binding: ActivityRegistryBinding

    private var presenter: RegistryPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = RegistryPresenter(this)

        binding.btnSubmit.setOnClickListener {
            if (binding.etNameNew.text?.isEmpty()!! || binding.etEmailNew.text?.isEmpty()!! || binding.etPasswordNew.text?.isEmpty()!! || binding.etRpasswordNew.text?.isEmpty()!!)
                onError("Please fill all the fields")
            else if (binding.etPasswordNew.text.toString() != binding.etRpasswordNew.text.toString())
                onError("The passwords doesn´t match")
            else if (!binding.cbTermsCond.isChecked)
                onError("You need to accept terms and conditions")
            else {
                presenter?.setNewUser(
                    binding.etEmailNew.text.toString(),
                    binding.etPasswordNew.text.toString()
                )
            }
        }
    }

    override fun onSuccess() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
        finishAffinity()
    }

    override fun onError(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

}