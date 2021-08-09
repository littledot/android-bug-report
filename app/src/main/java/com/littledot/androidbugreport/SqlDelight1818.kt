package com.littledot.androidbugreport

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

/**
 * https://github.com/cashapp/sqldelight/issues/1818
 */
class SqlDelight1818 : Fragment(R.layout.repro) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        com.littledot.pass.PassTable(0, "")
        comlittledotfail.FailTable(0, "")
    }
}

