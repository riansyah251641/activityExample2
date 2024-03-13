package com.activityexample

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.activityexample.databinding.ActivityDetailBinding
import com.activityexample.databinding.ActivityMainBinding
import com.activityexample.model.Person


class DetailActivity : AppCompatActivity() {



//old way 2
  /*  companion object {
        const val EXTRAS_KEY_IMG_PROFILE = "EXTRAS_KEY_IMG_PROFILE"
        const val EXTRAS_KEY_NAME = "EXTRAS_KEY_NAME"
        const val EXTRAS_KEY_ROLE = "EXTRAS_KEY_ROLE"

        fun startActivity(context: Context, imgResDrawable: Int?, name: String?, role: String?) {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(EXTRAS_KEY_IMG_PROFILE, imgResDrawable)
            intent.putExtra(EXTRAS_KEY_NAME, name)
            intent.putExtra(EXTRAS_KEY_ROLE, role)
            context.startActivity(intent)
              }
        }*/

    companion object {
        const val EXTRAS_DETAIL_DATA = "EXTRAS_DETAIL_DATA"
        fun startActivity (context: Context, person: Person){
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(EXTRAS_DETAIL_DATA, person)
            context.startActivity((intent))
        }
    }


    private val binding: ActivityDetailBinding by lazy {
        ActivityDetailBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        getIntentData()
    }

    private fun getIntentData() {
        intent.extras?.getParcelable <Person>(EXTRAS_DETAIL_DATA)?. let{
            setProfileImage(it.imgResDrawable)
            setProfileData(it.name, it.jobDesk)
        }


    }

    private fun setProfileData(textName: String?, textRole: String?) {
        textName?.let { binding.tvName.text = it }
        textRole?.let { binding.tvJobDesk.text = it }
    }

    private fun setProfileImage(imgResDrawable: Int?) {
        imgResDrawable?.let { binding.ivProfile.setImageResource(it) }
    }
}