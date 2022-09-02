package com.example.livedataexperiment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.livedataexperiment.screens.AdditionalFragment
import com.example.livedataexperiment.screens.MainFragment

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val mainFragment = MainFragment()
        val additionalFragment = AdditionalFragment()

        supportFragmentManager.beginTransaction().apply {
            add(R.id.mainFragment, mainFragment)
            add(R.id.additionalFragment, additionalFragment)
        }.commit()


    }
}