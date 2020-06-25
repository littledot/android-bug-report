package com.littledot.androidbugreport

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.squareup.sqldelight.android.AndroidSqliteDriver
import kotlinx.android.synthetic.main.main.*

/**
 * https://github.com/
 */
class SqlDelight1820 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

        val driver = AndroidSqliteDriver(MyCoolStore.Schema, this, null)
        val db = MyCoolStore(driver)

        repro.setOnClickListener {
            db.sqlDelight1820Queries.upsert(
                col0 = "a",
                col1 = "b",
                col2 = true,
                col3 = 123
            )
        }
    }
}

