package com.littledot.androidbugreport

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.squareup.sqldelight.android.AndroidSqliteDriver
import kotlinx.android.synthetic.main.repro.*

/**
 * https://github.com/cashapp/sqldelight/issues/1820
 */
class SqlDelight1820 : Fragment(R.layout.repro) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val driver = AndroidSqliteDriver(MyCoolStore.Schema, requireContext(), null)
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

