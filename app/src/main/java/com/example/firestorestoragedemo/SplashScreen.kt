package com.example.firestorestoragedemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.google.firebase.auth.FirebaseAuth

class SplashScreen : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        supportActionBar?.hide()
        mAuth = FirebaseAuth.getInstance()
        val user = mAuth.currentUser

        if(user != null){

            Handler().postDelayed({
                val intent = Intent(this,Profile::class.java)
                startActivity(intent)
                finish()
            },1800)
        }
        else{

            Handler().postDelayed({
                val signInintent = Intent(this,MainActivity::class.java)
                startActivity(signInintent)
                finish()
            },2500)
        }
    }
}