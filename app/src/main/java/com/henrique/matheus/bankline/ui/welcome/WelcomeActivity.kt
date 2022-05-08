package com.henrique.matheus.bankline.ui.welcome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.henrique.matheus.bankline.R
import com.henrique.matheus.bankline.databinding.ActivityWelcomeBinding
import com.henrique.matheus.bankline.domain.AccountHolder
import com.henrique.matheus.bankline.ui.statement.BankStatementActivity

class WelcomeActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityWelcomeBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnContinue.setOnClickListener {
            val accountHolderId = binding.etAccountHolderId.text.toString().toLong()
            val accountHolder = AccountHolder(accountHolderId)

            val intent = Intent(this, BankStatementActivity::class.java).apply {
                putExtra(BankStatementActivity.EXTRA_ACCOUNT_HOLDER, accountHolder)
            }
            startActivity(intent)
        }
    }
}