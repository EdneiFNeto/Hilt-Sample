package com.example.hilt.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.hilt.domain.model.User
import com.example.hilt.network.ExampleService
import com.example.hilt.network.model.Images
import com.example.hilt.presentation.viewmodel.base.ViewModelHelper
import com.example.hilt.repository.ExampleRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExampleViewModel @Inject constructor(
    private val repositoryDao: ExampleRepositoryImpl,
    private val service: ExampleService
) : ViewModelHelper() {

    private val images = MutableLiveData<Images>()

    init {
        getImagesApi()
    }

    override fun getImagesApi(){
        viewModelScope.launch {
            var countries = service.all()
            if (countries.isSuccessful) {
                countries.body()?.also {
                    images.postValue(it)
                }
            } else println("Error connection")
        }
    }

    fun getImages() = images

    fun all(): LiveData<List<User>> {
        return repositoryDao.get()
    }

    fun insert(user: User): LiveData<Long> {
        return repositoryDao.insert(user)
    }

    fun delete(user: User): LiveData<Int> {
        return repositoryDao.delete(user)
    }
}
