package com.mvvm.project.database.dao.base

import androidx.room.*
import androidx.sqlite.db.SupportSQLiteQuery

@Dao
interface  BaseDAO<T> {
    @RawQuery
    fun list(query: SupportSQLiteQuery): List<T>
}
