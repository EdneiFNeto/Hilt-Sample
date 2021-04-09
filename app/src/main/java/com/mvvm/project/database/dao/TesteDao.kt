package com.mvvm.project.database.dao

import androidx.room.Dao
import com.mvvm.project.database.dao.base.BaseDAO
import com.mvvm.project.model.Teste

@Dao
abstract class TesteDao: BaseDAO<Teste>
