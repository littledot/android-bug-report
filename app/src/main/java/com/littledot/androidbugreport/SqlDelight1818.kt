package com.littledot.androidbugreport

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * https://github.com/
 */
class SqlDelight1818 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        com.littledot.pass.PassTable(0, "")
        comlittledotfail.FailTable(0, "")
    }
}

