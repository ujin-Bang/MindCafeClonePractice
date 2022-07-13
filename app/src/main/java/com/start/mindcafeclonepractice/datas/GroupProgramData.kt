package com.start.mindcafeclonepractice.datas

import java.io.Serializable

data class GroupProgramData(
    val programImg: String? = null,
    val programTitle: String? = null,
    val programTime: String? = null,
    val programCoachName: String? = null,
    val numberOfParticipants: String? = null,
    val price: Int? = null,
): Serializable {
}