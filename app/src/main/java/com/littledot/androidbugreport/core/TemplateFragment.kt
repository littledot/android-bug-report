package com.littledot.androidbugreport.core

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.littledot.androidbugreport.R
import kotlinx.android.synthetic.main.repro.*

/**
 * https://github.com/cashapp/sqldelight/issues/1820
 */
class TemplateFragment : Fragment(R.layout.repro) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        repro.setOnClickListener {
        }
    }
}

