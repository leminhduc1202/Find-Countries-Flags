package com.example.searchViewInRoom

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.searchViewInRoom.databinding.ActivityDetailBinding

class DetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.detailCountryText.text = intent.extras!!.getString("passselectedcountry")!!
    }
}