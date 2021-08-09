package com.littledot.androidbugreport

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.zoomlayout_209.*

/**
 * https://github.com/natario1/ZoomLayout/issues/209
 */
class ZoomLayout209 : Fragment(R.layout.zoomlayout_209) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
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

