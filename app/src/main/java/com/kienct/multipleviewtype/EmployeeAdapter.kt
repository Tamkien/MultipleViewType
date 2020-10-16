package com.kienct.multipleviewtype

import android.app.AlertDialog
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmployeeAdapter(private val employees: List<Employee>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val TYPE_CALL = 1
    private val TYPE_EMAIL = 2
    override fun getItemViewType(position: Int): Int {
        when {
            employees[position].email == "" -> return TYPE_CALL
            employees[position].phone == "" -> return TYPE_EMAIL
        }
        return 0
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            1 -> {
                AreaViewHolder(
                    LayoutInflater.from(parent.context).inflate(R.layout.item_call, parent, false)
                )
            }
            else -> {
                AreaViewHolder(
                    LayoutInflater.from(parent.context).inflate(R.layout.item_email, parent, false)
                )
            }
        }
    }

    override fun getItemCount(): Int {
        return employees.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is AreaViewHolder) {
            holder.bind(employees[position])
            holder.itemView.setOnClickListener {
                val dialog = AlertDialog.Builder(it.context).create()
                dialog.setTitle("Information")

                dialog.setMessage(
                    when (employees[position].email) {
                        "" -> employees[position].phone
                        else -> employees[position].email
                    }
                )
                dialog.setButton(
                    AlertDialog.BUTTON_NEUTRAL, "OK"
                ) { _: DialogInterface, _: Int -> dialog.dismiss() }
                dialog.show()
            }
        }
    }

    inner class AreaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(employee: Employee) {
            val name: TextView = itemView.findViewById(R.id.tvName)
            val address: TextView = itemView.findViewById(R.id.tvAddress)
            address.text = employee.address
            name.text = employee.name
        }
    }
}