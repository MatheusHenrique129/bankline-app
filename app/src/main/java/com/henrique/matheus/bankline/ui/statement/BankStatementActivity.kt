package com.henrique.matheus.bankline.ui.statement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.henrique.matheus.bankline.data.State
import com.henrique.matheus.bankline.databinding.ActivityBankStatementBinding
import com.henrique.matheus.bankline.domain.AccountHolder
import com.henrique.matheus.bankline.domain.Movement
import com.henrique.matheus.bankline.domain.TypeMovement
import java.math.BigDecimal

class BankStatementActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_ACCOUNT_HOLDER = "com.henrique.matheus.bankline.ui.statement.EXTRA_ACCOUNT_HOLDER"
    }

    private val binding by lazy {
        ActivityBankStatementBinding.inflate(layoutInflater)
    }

    private val accountHolder by lazy {
        intent.getParcelableExtra<AccountHolder>(EXTRA_ACCOUNT_HOLDER) ?: throw IllegalArgumentException()
    }

    private val viewModel by viewModels<BankStatementViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.rvBankStatement.layoutManager = LinearLayoutManager(this)

        findBankStatement()

        binding.srlBankStatement.setOnRefreshListener { findBankStatement() }
    }

    private fun findBankStatement() {
       viewModel.findBankStatement(accountHolder.id).observe(this) {
           state -> when(state) {
           is State.Successful -> {
               binding.rvBankStatement.adapter = state.data?.let { BankStatementAdapter(it) }
               binding.srlBankStatement.isRefreshing = false
           }
           is State.Error -> {
               state.message?.let { Snackbar.make(binding.rvBankStatement, it, Snackbar.LENGTH_LONG).show() }
               binding.srlBankStatement.isRefreshing = false
           }
           State.Wait -> binding.srlBankStatement.isRefreshing = true
        }
       }
    }
}