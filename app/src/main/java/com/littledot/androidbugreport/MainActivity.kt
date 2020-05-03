package com.littledot.androidbugreport

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import coil.Coil
import coil.api.loadAny
import kotlinx.android.synthetic.main.main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

        val src =
            "https://pbs.twimg.com/profile_images/378800000666093975/cbe970ce9a19d2c6bec0d06c6004ccf0_400x400.png"

        Coil.loadAny(this, src) {
            target(img1)
            listener { request, source ->
                img1.visibility = View.VISIBLE
            }
        }
    }
}
