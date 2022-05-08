package com.henrique.matheus.bankline.ui.statement

import androidx.lifecycle.ViewModel
import com.henrique.matheus.bankline.data.BanklineRepository

class BankStatementViewModel : ViewModel() {

    fun findBankStatement(accountHolderId: Long) =
        BanklineRepository.findBankStatement(accountHolderId)
}