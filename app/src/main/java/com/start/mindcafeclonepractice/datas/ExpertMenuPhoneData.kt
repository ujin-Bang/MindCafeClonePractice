package com.start.mindcafeclonepractice.datas

import java.io.Serializable

class ExpertMenuPhoneData(
    val expirationPeriod : String? = null,
    val normalPrice : Int? = null,
    val price: Int? = null,
    val severalMinutesTime: String? =null,
    val title: String? = null,
    val detailContent: String? = null,

): Serializable {
}