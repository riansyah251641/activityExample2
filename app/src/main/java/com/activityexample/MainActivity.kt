package com.activityexample

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import com.activityexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by  lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setClickAction()
    }

    private fun setClickAction(){
        binding.buttonToProfile.setOnClickListener{
            navigateToProfile()
        }
    }
    private fun navigateToProfile(){
       /* val intent = Intent(this, DetailActivity::class.java)
        startActivity(intent)*/
        DetailActivity.startActivity(this, R.drawable.ic_launcher_background,"Ryan" , "Programer Beginner")
        Toast.makeText(this, "Navigate to profile", Toast.LENGTH_SHORT).show()
    }

    override fun onStart() {
        Log.d(TAG,
            "onCreate: Activity Created")
        super.onStart()
    }

    override fun onResume() {
        Log.d(
            TAG,
            "onResume: Activity onResume"
        )
        super.onResume()
    }

    override fun onPause() {
        Log.d(
            TAG,
            "onPause: Activity onPause"
        )
        super.onPause()
    }

    override fun onStop() {
        Log.d(
            TAG,
            "onStop: Activity onStop"
        )
        super.onStop()
    }

    override fun onDestroy() {
        Log.d(
            TAG,
            "onDestroy: Activity onDestroy"
        )
        super.onDestroy()
    }

}