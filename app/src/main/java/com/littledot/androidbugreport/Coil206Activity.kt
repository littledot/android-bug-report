package com.littledot.androidbugreport

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import coil.Coil
import coil.decode.GifDecoder
import coil.request.LoadRequestBuilder
import kotlinx.android.synthetic.main.coil_206.*

/**
 * https://github.com/coil-kt/coil/issues/206
 */
class Coil206Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.coil_206)

        val src =
            "https://media1.giphy.com/media/mTANPe0FgBuo/giphy.gif?cid=4d1e4f2998945bed1522c2608e7db022535fa1bfbd50ad4b&rid=giphy.gif"
        LoadRequestBuilder(this)
            .target(imgView)
            .data(src)
            .decoder(GifDecoder())
            .build()
            .let { Coil.execute(it) }

        LoadRequestBuilder(this)
            .target(imgView2)
            .data(src)
            .decoder(GifDecoder())
            .build()
            .let { Coil.execute(it) }
    }
}
