package com.henrique.matheus.bankline.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class AccountHolder(
    val id: Long
) : Parcelable
