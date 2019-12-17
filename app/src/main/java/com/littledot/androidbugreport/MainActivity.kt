package com.littledot.androidbugreport

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.Coil
import coil.api.load
import coil.api.loadAny
import coil.decode.GifDecoder
import com.airbnb.epoxy.EpoxyController
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.airbnb.epoxy.EpoxyViewHolder
import kotlinx.android.synthetic.main.coil_gif_scale.*

class MainActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.coil_gif_scale)
        
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
