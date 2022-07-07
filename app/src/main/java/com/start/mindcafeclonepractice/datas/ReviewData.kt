package com.start.mindcafeclonepractice.datas

import java.io.Serializable

data class ReviewData(
    val coachName: String? = null,
    val profileImg: String? = null,
    val purchaseProduct: String? = null,
    val solutionImg: String? = null,
    val content: String? = null,
    val ratingImg: String? = null,
    val ratingNum: Int? = null,
    val coachInstruction: String? = null,
    val solutionImg2: String? = null,
    val solutionImg3: String? = null,
): Serializable {
}