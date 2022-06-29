package com.start.mindcafeclonepractice.datas

import java.io.Serializable

class NewExpertData(
    val profileImg: String? = null,
    val name: String? = null,
    val introduction: String? = null,
    val consultingTool1: String? = null,
    val consultingTool2: String? = null
): Serializable {
}