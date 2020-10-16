package com.kienct.multipleviewtype

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //create employee list
        val employees: MutableList<Employee> = mutableListOf()
        employees.add(Employee("Anna", "Hanoi", "", "abc@gmail.com"))
        employees.add(Employee("Bob", "Bac Ninh", "0948756413", ""))
        employees.add(Employee("Chris", "Ha Nam", "", "zxy@yahoo.com"))
        employees.add(Employee("Daniel", "HCMC", "", "sdv@bk.ru"))
        employees.add(Employee("Ethan", "Hoa Binh", "0896451236", ""))
        employees.add(Employee("Ferdinand", "Vinh Phuc", "0894356413", ""))
        //setup the recycleView
        val adapter = EmployeeAdapter(employees)
        itemContainer.layoutManager = LinearLayoutManager(this)
        itemContainer.adapter = adapter
    }
}