package com.example.agricolistest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var userid : EditText
    lateinit var userpasswd : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userid = findViewById<EditText>(R.id.editTextTextPersonName)
        userpasswd = findViewById<EditText>(R.id.editTextTextPassword)
        var login = findViewById<Button>(R.id.button)
        login.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
       when(v?.id){

           R.id.button -> {
               if(TextUtils.isEmpty(userid.text) || TextUtils.isEmpty(userpasswd.text)){
                   Toast.makeText(this,"please fill all the fields abouve",Toast.LENGTH_SHORT).show()
               }else{

                   var username = userid.text.toString()
                   var passwd = userpasswd.text.toString()
                   var intent = Intent(this,MenuActivity::class.java)
                   intent.putExtra("userid",username)
                   intent.putExtra("passwd",passwd)
                   startActivity(intent)

               }


           }
       }
    }
}