package com.henrique.matheus.bankline.ui.statement

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.henrique.matheus.bankline.R
import com.henrique.matheus.bankline.databinding.BankStatementItemBinding
import com.henrique.matheus.bankline.domain.Movement
import com.henrique.matheus.bankline.domain.TypeMovement

/**
 * Reference: https://developer.android.com/guide/topics/ui/layout/recyclerview?hl=pt-br#kotlin
 */
class BankStatementAdapter(private val dataSet: List<Movement>) : RecyclerView.Adapter<BankStatementAdapter.ViewHolder>() {

    class ViewHolder(private val binding: BankStatementItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Movement) = with(binding) {
            tvDescription.text = item.description
            tvValue.text = item.value.toString()
            tvDatetime.text = item.dateTime
            val typeIcon = if (TypeMovement.RECEITA == item.type) R.drawable.ic_money_in else R.drawable.ic_money_out
            ivIcon.setImageResource(typeIcon)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = BankStatementItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val item = dataSet[position]
        viewHolder.bind(item)
    }

    override fun getItemCount() = dataSet.size
}