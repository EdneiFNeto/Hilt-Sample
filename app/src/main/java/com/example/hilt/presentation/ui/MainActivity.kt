package com.example.hilt.presentation.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.hilt.R
import com.example.hilt.domain.model.User
import com.example.hilt.presentation.viewmodel.ExampleViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val exampleViewModel: ExampleViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        exampleViewModel.apply {
            this.getImages()
                .observe(this@MainActivity, {
                    this.insert(User(id = null, name = it.message))
                        .observe(this@MainActivity, { userId -> println("Success save image $userId")})
                })
        }
    }
}