package com.example.hilt.repository

import androidx.lifecycle.MutableLiveData
import com.example.hilt.domain.User
import com.example.hilt.domain.database.dao.UserDao
import com.example.hilt.netiwork.ExampleService
import com.example.hilt.util.LauncherUtil
import javax.inject.Inject

class ExampleRepositoryImpl @Inject constructor(
    private val dao: UserDao
) : ExampleDatabaseHelper<User> {

    private val liveDataUser = MutableLiveData<List<User>>()
    private val liveDataNewUse = MutableLiveData<Long>()
    private val liveDataNewUseLong = MutableLiveData<Int>()
    private lateinit var users: List<User>
    private var userId: Long = 0L

    override fun get(): MutableLiveData<List<User>> {
        LauncherUtil(inprogress = {
            users = dao.all()
        }, finish = { liveDataUser.value = users }).execute()

        return liveDataUser
    }

    override fun insert(user: User): MutableLiveData<Long> {
        LauncherUtil(inprogress = {
            userId = dao.insert(user)
        }, finish = { liveDataNewUse.value = userId }).execute()

        return liveDataNewUse
    }

    override fun delete(user: User): MutableLiveData<Int> {
        LauncherUtil(inprogress = {
            userId = dao.delete(user).toLong()
        }, finish = { liveDataNewUseLong.value = userId.toInt() }).execute()

        return liveDataNewUseLong
    }
}
