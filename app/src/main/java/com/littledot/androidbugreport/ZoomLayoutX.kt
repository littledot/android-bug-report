package com.littledot.androidbugreport

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.zoomlayout_x.*

/**
 * https://github.com/cashapp/sqldelight/issues/1820
 */
class ZoomLayoutX : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.zoomlayout_x)

        btn160.setOnClickListener {
            loadImg(R.drawable.zoomlayout160)
        }
        btn320.setOnClickListener {
            loadImg(R.drawable.zoomlayout320)
        }
        btn640.setOnClickListener {
            loadImg(R.drawable.zoomlayout640)
        }

        zoom.setOnTouchListener { v, event ->
            zoomInfo()
            false
        }
    }

    fun loadImg(res: Int) {
        zoom.zoomTo(1f, false)
        img.setImageResource(res)
        zoom.zoomTo(1f, false)
        zoomInfo()
    }

    fun zoomInfo() {
        val z = zoom.zoom
        val rz = zoom.realZoom
        info.text = "z=$z rz=$rz"
    }
}

