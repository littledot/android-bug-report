package com.littledot.androidbugreport

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import coil.Coil
import coil.request.LoadRequestBuilder
import kotlinx.android.synthetic.main.coil_387.*

/**
 * https://github.com/coil-kt/coil/issues/387
 */
class Coil387 : Fragment(R.layout.coil_387) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val src = "https://i.imgur.com/q40xWVn.png"
        LoadRequestBuilder(requireContext())
            .target(img1)
            .data(src)
            .listener { request, source -> img1.visibility = View.VISIBLE }
            .build()
            .let { Coil.execute(it) }
    }
}
