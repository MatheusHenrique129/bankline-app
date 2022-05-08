package com.henrique.matheus.bankline.data

import android.util.Log
import androidx.lifecycle.liveData
import com.henrique.matheus.bankline.data.remote.BanklineAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception

object BanklineRepository {

    private val TAG = javaClass.simpleName

    private val restApi by lazy {
        Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BanklineAPI::class.java)
    }

    fun findBankStatement(accountHolderId: Long) = liveData {
        emit(State.Wait)
        try {
            emit(State.Successful(data = restApi.findBankStatement(accountHolderId)))
        } catch (e: Exception) {
            Log.e(TAG, e.message, e)
            emit(State.Error(e.message))
        }
    }
}