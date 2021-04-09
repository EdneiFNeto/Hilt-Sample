package com.mvvm.project.recycleview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mvvm.project.databinding.TesteLayoutBinding
import com.mvvm.project.model.Data
import com.mvvm.project.model.Person
import java.util.*

class PersonAdapter(private val context: Context?, private val list: ArrayList<Person>) :
    RecyclerView.Adapter<PersonAdapter.ViewHolder>() {

    class ViewHolder(private val viewDataBinding: TesteLayoutBinding) : RecyclerView.ViewHolder(viewDataBinding.root) {

        private  lateinit var person: Person

        fun add(data: Person){
            this.person = data
            viewDataBinding.person = person
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(TesteLayoutBinding.inflate(LayoutInflater.from(context), parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.add(list[position])
    }

}
