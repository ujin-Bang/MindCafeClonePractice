package com.start.mindcafeclonepractice.datas

import java.io.Serializable

data class CoachData(
    val profileImg: String? = null,
    val name: String? = null,
    val introduction: String? = null,
    val talkImg: String? = null,
    val phoneImg: String? = null,
    val meetImg: String? = null,
):Serializable {
}