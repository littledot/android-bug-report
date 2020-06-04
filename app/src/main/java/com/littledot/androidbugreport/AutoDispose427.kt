package com.littledot.androidbugreport

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import autodispose2.android.autoDispose
import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.TimeUnit

/**
 * https://github.com/uber/AutoDispose/issues/427
 */
class AutoDispose427 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.autodispose_427)

        Observable.interval(1, TimeUnit.SECONDS)
            .autoDispose(findViewById(R.id.img1))
            .subscribe()
    }
}

