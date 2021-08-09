package com.littledot.androidbugreport

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import autodispose2.android.autoDispose
import io.reactivex.rxjava3.core.Observable
import kotlinx.android.synthetic.main.autodispose_427.*
import java.util.concurrent.TimeUnit

/**
 * https://github.com/uber/AutoDispose/issues/427
 */
class AutoDispose427 : Fragment(R.layout.autodispose_427) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Observable.interval(1, TimeUnit.SECONDS)
            .autoDispose(img1)
            .subscribe()
    }
}

