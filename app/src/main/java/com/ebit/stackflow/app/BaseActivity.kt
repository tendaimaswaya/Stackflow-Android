package com.ebit.stackflow.app

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {

    fun <T> alert (msg:T){
        Toast.makeText(this, msg.toString(), Toast.LENGTH_LONG).show()
    }
}