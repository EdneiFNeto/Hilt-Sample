package com.example.hilt.repository

import androidx.lifecycle.MutableLiveData

interface ExampleDatabaseHelper<T> {
    fun get(): MutableLiveData<List<T>>
    fun insert(t: T): MutableLiveData<Long>
    fun delete(t: T): MutableLiveData<Int>
}
