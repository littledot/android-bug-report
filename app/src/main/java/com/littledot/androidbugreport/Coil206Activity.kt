package com.littledot.androidbugreport

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import coil.Coil
import coil.api.loadAny
import coil.decode.GifDecoder
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
        Coil.loadAny(this, src) {
            target(imgView)
            decoder(GifDecoder())
        }
        
        Coil.loadAny(this, src) {
            target(imgView2)
            decoder(GifDecoder())
        }
    }
}
