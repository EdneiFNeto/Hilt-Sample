package com.mvvm.project.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mvvm.project.model.Data
import com.mvvm.project.model.Teste
import com.mvvm.project.repository.TesteRepository
import com.mvvm.project.repository.resource.Resources

class TesteViewModel(private val repository: TesteRepository) : ViewModel(){

    fun list(): LiveData<Resources<Data>>{
        return repository.list()
    }
}
