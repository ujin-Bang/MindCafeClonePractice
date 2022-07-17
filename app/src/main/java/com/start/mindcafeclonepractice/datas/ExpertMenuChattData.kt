package com.start.mindcafeclonepractice.datas

import java.io.Serializable

class ExpertMenuChattData(
    val expirationPeriod: String? = null,
    val title: String? = null,
    val severalMinutesTime: String? =null,
    val price: Int? = null,
    val therapyContent: String? = null,
    val normalPrice: Int? = null,

):Serializable {
}