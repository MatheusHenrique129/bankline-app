package com.henrique.matheus.bankline.data.remote

import com.henrique.matheus.bankline.domain.Movement
import retrofit2.http.GET
import retrofit2.http.Path

interface BanklineAPI {

    @GET("movements/{id}")
    suspend fun findBankStatement(@Path("id") accountHolderId: Long): List<Movement>
}