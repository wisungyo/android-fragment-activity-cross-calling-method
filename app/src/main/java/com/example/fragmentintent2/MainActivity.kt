package com.example.fragmentintent2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebViewFragment
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_fragment.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.supportActionBar?.hide()

        makeFragment(ActivityFragment())

        btn_activity.setOnClickListener {
            val fragment = supportFragmentManager.findFragmentById(R.id.cl_fragment) as? ActivityFragment
            fragment?.toastFragmentFun()
        }
    }

    private fun makeFragment(fragment: Fragment) = supportFragmentManager.beginTransaction().apply {
        replace(R.id.cl_fragment, fragment)
        commit()
    }

    // this method need to call from fragment !!
    fun toastActivityFun() {
        Toast.makeText(this, "Activity Method called", Toast.LENGTH_SHORT).show()
    }
}