package com.start.mindcafeclonepractice

import android.app.Application
import com.kakao.sdk.common.KakaoSdk

class GlobalApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        KakaoSdk.init(this, "15d61d8d2d3833bfb11ec220e842ac4f")

    }
}