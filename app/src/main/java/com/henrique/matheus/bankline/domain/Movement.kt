package com.henrique.matheus.bankline.domain

import com.google.gson.annotations.SerializedName
import java.math.BigDecimal

data class Movement(
    val id: Long,
    val dateTime: String,
    val description: String,
    val value: BigDecimal,
    val type: TypeMovement,
    @SerializedName("accountId")
    val idAccountHolder: Long
)
