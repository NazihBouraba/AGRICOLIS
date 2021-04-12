package com.example.agricolistest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class EditActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var edit : EditText
    var index =0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
         index = intent.getIntExtra("index",-1)
         edit = findViewById<EditText>(R.id.edit_txt)
        edit.hint = MenuActivity.list[index]
        edit.setText(MenuActivity.list[index]);
        var modifier = findViewById<Button>(R.id.valider)
        var supprimer = findViewById<Button>(R.id.supprimer)
        var annuler = findViewById<Button>(R.id.annuler)
        modifier.setOnClickListener(this)
        supprimer.setOnClickListener(this)
        annuler.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.valider-> {
                var nouvelle = edit.text.toString()
                MenuActivity.list[index]= nouvelle
            }

            R.id.supprimer-> {
            MenuActivity.list.removeAt(index)

            }
            R.id.annuler-> {



            }

        }

        var intent = Intent(this,MenuActivity::class.java)
        startActivity(intent)
    }
}