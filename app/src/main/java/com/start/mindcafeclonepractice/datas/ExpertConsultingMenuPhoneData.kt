package com.start.mindcafeclonepractice.datas

import java.io.Serializable
import java.text.DecimalFormat

data class ExpertConsultingMenuPhoneData(
    val title: String? = null,
    val price: Int? = null,
    val timeMinutes: String? = null,
    val expiration: String? = null,
):Serializable {
    fun getFormattedPrice(price: Int): String {

        val dec = DecimalFormat("#,###")
        return dec.format(this.price)+"원"
    }
}