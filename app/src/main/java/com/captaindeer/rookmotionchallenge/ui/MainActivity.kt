package com.captaindeer.rookmotionchallenge.ui

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.captaindeer.rookmotionchallenge.R
import com.captaindeer.rookmotionchallenge.databinding.ActivityMainBinding
import com.captaindeer.rookmotionchallenge.ui.home.HomeFragment
import com.captaindeer.rookmotionchallenge.ui.login.LoginActivity
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var toggle: ActionBarDrawerToggle

    private var auth: FirebaseAuth? = null

    private var email: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        val header = binding.navView.getHeaderView(0)
        email = header.findViewById(R.id.tv_nav_mail) as TextView
        email!!.text = auth!!.currentUser!!.email.toString()



        toggle = ActionBarDrawerToggle(this, binding.drawerLayout, R.string.open, R.string.close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()
                R.id.extra -> Toast.makeText(this, "Espacio extra", Toast.LENGTH_SHORT).show()
                R.id.profile -> Toast.makeText(
                    this,
                    "Configuracion de la cuenta",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.logout -> logOut()
            }
            true
        }

    }

    override fun onBackPressed() {
        if (this.binding.drawerLayout.isDrawerOpen(GravityCompat.START))
            this.binding.drawerLayout.closeDrawer(GravityCompat.START)
        else
            super.onBackPressed()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item))
            return true
        return super.onOptionsItemSelected(item)
    }

    private fun logOut() {
        auth?.signOut()
        startActivity(Intent(this, LoginActivity::class.java))
        finishAffinity()
    }
}