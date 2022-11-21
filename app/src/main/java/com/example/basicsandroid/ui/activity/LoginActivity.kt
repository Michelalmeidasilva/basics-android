package com.example.basicsandroid.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.basicsandroid.R

class LoginActivity : AppCompatActivity(R.layout.activity_login) {


    private fun bindComponents() {
        val buttonSave = findViewById<Button>(R.id.login_save_button)

        buttonSave.setOnClickListener {
            val intent = Intent(this, ProductsListActivity::class.java)
            startActivity(intent);
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindComponents();
    }
}